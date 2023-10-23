/**
 * 
 */
package com.cg.neel.igrs.users;

import java.util.Calendar;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

/**
 * @author Preeti
 * @Des Store Unique token for register user with expiryDate
 *
 */
@Data
@Entity
@Table(name = "VERIFICATIONTOKEN") 
public class VerificationToken {
	
	private static final int EXPIRATION = 60 * 24;
	
	@Id
	@Column(name = "VERIFICATIONTOKEN_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long verificationTokenId;
	
	
	@Column(name = "TOKEN")
	private String token;
	
	@OneToOne(targetEntity = UserRegAccessBean.class, fetch = FetchType.EAGER)
	@JoinColumn(nullable = false,
	             name = "userId",
	             foreignKey = @ForeignKey (name = "FK_VERIFY_USER"))
	private UserRegAccessBean userRegAccessBean;
	
	@Column(name = "EXPIRYDATE")
	private Date expiryDate;
	
	public VerificationToken() {
		super();
	}
	
	public VerificationToken(final String token) {
		super();
		this.token = token;
		this.expiryDate = calculateExpiryDate(EXPIRATION);
	}

	public VerificationToken(final String token, final UserRegAccessBean userRegAccessBean) {
		super();
		
		this.token = token;
		this.userRegAccessBean =  userRegAccessBean;
		this.expiryDate = calculateExpiryDate(EXPIRATION);
		
	}
	
	/**
	 * @param expiryTimeInMinutes
	 * @return Date
	 */
	private Date calculateExpiryDate(final int expiryTimeInMinutes) {
		final Calendar cal = Calendar.getInstance();
		cal.setTimeInMillis(new Date().getTime());
		cal.add(Calendar.MINUTE, expiryTimeInMinutes);
		return new Date(cal.getTime().getTime());
	}

}
