/**
 * 
 */
package com.cg.neel.igrs.users.service;

import java.util.Date;
import java.util.concurrent.CompletableFuture;

import javax.annotation.PostConstruct;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.cg.neel.igrs.exceptions.MobileSaveDatabaseException;
import com.cg.neel.igrs.users.MobileVerification;
import com.cg.neel.igrs.users.UserRegAccessBean;
import com.cg.neel.igrs.users.configuration.IgrsUserDetails;
import com.cg.neel.igrs.users.repository.MobileVerificationRepository;
import com.cg.neel.igrs.utils.Utils;
import com.twilio.Twilio;
import com.twilio.base.ResourceSet;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

import lombok.RequiredArgsConstructor;
/**
 * @author Preeti
 *
 */
@Service
@Configuration
@PropertySource(
		value = {"classpath:otp.properties"},
		ignoreResourceNotFound = false
		)
@ConfigurationProperties(prefix = "otp")
@RequiredArgsConstructor
public class VerifyCredentialsServiceImpl implements VerifyCredentialsService{
	
	
	
	private final Environment env;
	
	
	private final MobileVerificationRepository mobileVerificationRepository;
	
	
	private final RegistrationService registrationService;
	
	
	private final IgrsUserDetails igrsUserDetails;
	

	private final PasswordEncoder passwordEncoder;
	
	private static String MOBILE_ACCOUNT_SID;
	private static String MOBILE_ACCOUNT_TOKEN;
	private static String MOBILE_NUMBER;
	private static String OTP_MESSAGE;
	private static String QUEUED;
	private static String SENDING;
	private static String SENT;
	private static String DELIVERED;
	private static String FAILED;
	private static String UNDELIVERED;
	private static String MSG_OTP_MATCH;
	private static String MSG_OTP_NOT_MATCH;
	private static String MSG_OTP_NOT_FOUND;
	private static String MSG_OTP_EXPIRE;

	@PostConstruct
	public synchronized void init() {
	    MOBILE_ACCOUNT_SID = env.getProperty("mobilAccountSID");
	    MOBILE_ACCOUNT_TOKEN = env.getProperty("mobilAccountToken");
	    MOBILE_NUMBER = env.getProperty("mobilNumber");
	    OTP_MESSAGE = env.getProperty("message.otpMessage");
	    QUEUED = env.getProperty("otp.message.status.queued");
	    SENDING = env.getProperty("otp.message.status.sending");
	    SENT = env.getProperty("otp.message.status.sent");
	    DELIVERED = env.getProperty("otp.message.status.delivered");
	    FAILED = env.getProperty("otp.message.status.failed");
	    UNDELIVERED = env.getProperty("otp.message.status.undelivered");
	    MSG_OTP_MATCH = env.getProperty("otp.message.match");
	    MSG_OTP_NOT_MATCH = env.getProperty("otp.message.notMatch");
	    MSG_OTP_NOT_FOUND = env.getProperty("otp.message.notfound");
	    MSG_OTP_EXPIRE = env.getProperty("otp.message.expire");
	}

	//Update in future for proper status return		
	@Override
	public String sendingOtp(final String recipientPhoneNumber) {
		
		//Remove 2 starting digit because this is code of country
		//check mobile alreday exit or not
			if(registrationService.isMobileExists(recipientPhoneNumber.substring(2)) && registrationService.isMobileVerified(recipientPhoneNumber.substring(2))) {
				throw new MobileSaveDatabaseException("This mobile Already Exist : "+recipientPhoneNumber);
			}
		return otpSendMethod(recipientPhoneNumber);
	}

	/**
	 * @param recipientPhoneNumber 
	 * @return
	 */
	@Override
	public
	 String otpSendMethod(String recipientPhoneNumber) {
	
		String response = UNDELIVERED;
		
		try {
			Twilio.init(MOBILE_ACCOUNT_SID,MOBILE_ACCOUNT_TOKEN);
			//Generate OTP
			String otp = generateOtp();
			
			//Compose the message
			String otpMessage = OTP_MESSAGE + otp;
			System.out.println("otp :"+otp);
			Message.creator(
		                new PhoneNumber("+"+recipientPhoneNumber), //Change in fronted
		                new PhoneNumber(MOBILE_NUMBER),
		                otpMessage)
		                .create();
			
			 CompletableFuture<String> future = getMessageStatusAsync();
			 response = future.get();
		   //Response is Delivered
		   //Save in db
		     if(response.equals("delivered") || response.equals("sent")) {
		    	 saveMobileAndOtp(recipientPhoneNumber,otp);
		     }
		}
		catch(Exception e) {
			return FAILED + ": " + e;
		}
		return response;
	}

	/**
	 * @param recipientPhoneNumber
	 * @param otp
	 */
	private void saveMobileAndOtp(String recipientPhoneNumber, String otp) {
		MobileVerification mobileVerification = new MobileVerification(recipientPhoneNumber,otp);
		if(mobileVerificationRepository.save(mobileVerification) == null) {
			throw new MobileSaveDatabaseException("There is an issue when mobile number save in database");
		};
	}

	/**
	 * @return msg
	 */
	private CompletableFuture<String> getMessageStatusAsync() {
		 CompletableFuture<ResourceSet<Message>> future = Message.reader().readAsync();
	        CompletableFuture<String> responseFuture = new CompletableFuture<>();

	        future.thenAccept(messages -> {
	            for (Message responseMessage : messages) {
	                responseFuture.complete(responseMessage.getStatus().toString());
	            }
	            responseFuture.complete(""); // No messages found
	        }).exceptionally(t -> {
	            responseFuture.complete(t.getMessage());
	            return null;
	        });

	        return responseFuture;
	}

	/**
	 * @return 6 digit OTP number
	 */
	private String generateOtp() {
		// Generate a random 6-digit number (between 100000 and 999999)
		int otpNum = (int) (100000 +  Math.random() * 900000);
		return String.valueOf(otpNum);
	}

	@Override
	public String verifiedOtp(@Valid String mobileNumber, String enteredOtp) {
		MobileVerification mobileVerification= mobileVerificationRepository.findTopByMobileNumberOrderByMobileVerificationIdDesc(mobileNumber);
		if(mobileVerification == null) {
			return MSG_OTP_NOT_FOUND;
		}
		//Check OTP Expire or not
		if(verifyOtpExpire(mobileVerification))
			return MSG_OTP_EXPIRE;
		boolean isOtpValid = verifyOtp(mobileVerification.getOtp(), enteredOtp);
		if(isOtpValid) {
		   mobileVerificationRepository.deleteByMobileNumber(mobileNumber);
		   return MSG_OTP_MATCH;
		}
		return MSG_OTP_NOT_MATCH;
	}

	/**
	 * @param mobileVerification
	 * @return true/false
	 */
	private boolean verifyOtpExpire(MobileVerification mobileVerification) {
		Date expiryDate = mobileVerification.getExpiryDate();
		Date todayDate = Utils.getDate();
		return expiryDate.equals(todayDate) || expiryDate.before(todayDate);
	}

	/**
	 * @paramreceivedOtp
	 * @paramenteredOtp
	 * @return true/false
	 */
	private boolean verifyOtp(String receivedOtp, String enteredOtp) {
		return receivedOtp.equals(enteredOtp);
	}

	@Override
	public boolean checkIfValidOldPassword(String password,UserRegAccessBean user) {
		// password convert into encryption, then match
		String encodePassword = passwordEncoder.encode(password);
		return igrsUserDetails.matchPassword(encodePassword, user.getLogonPassword());
	}


}
