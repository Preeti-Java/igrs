/**
 * 
 */
package com.cg.neel.igrs.users;

import java.util.Calendar;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.cg.neel.igrs.utils.Utils;

import lombok.Data;

/**
 * @author Preeti
 * @Des Store  OTP for verify mobile ,after use for verify, it will delete from table 
 *
 */
@Data
@Entity
@Table(name = "MOBILEVERIFICATION") 
public class MobileVerification {
	
	private static final int EXPIRATION = 60 * 30;
	
	@Id
	@Column(name = "MOBILEVERIFICATION_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long mobileVerificationId;
	
	@Column(name = "MOBILENUMBER")
	private String mobileNumber;
	
	@Column(name = "OTP")
	private String otp;
	
	@Column(name="CREATEDATE")
	private Date createDate;
	
	@Column(name="EXPIRYDATE")
	private Date expiryDate;
	
	public MobileVerification() {
		super();
	}
	
	public MobileVerification(final String mobileNumber)
	{
		super();
		this.mobileNumber = mobileNumber;
		this.createDate = Utils.getDate();
		this.expiryDate = calculatedExpiryDate(EXPIRATION);
	}
	
	public MobileVerification(final String mobileNumber, final String otp) {
		super();
		this.mobileNumber = mobileNumber;
		this.otp = otp;
		this.createDate = Utils.getDate();
		this.expiryDate = calculatedExpiryDate(EXPIRATION);
	}

	/**
	 * @paramexpirationTimeInSec
	 * @return Date
	 */
	private Date calculatedExpiryDate(final int expirationTimeInSec) {
		final Calendar cal = Calendar.getInstance();
		cal.setTimeInMillis(new Date().getTime());
		cal.add(Calendar.SECOND, expirationTimeInSec);
		return new Date(cal.getTime().getTime());
	}

}
