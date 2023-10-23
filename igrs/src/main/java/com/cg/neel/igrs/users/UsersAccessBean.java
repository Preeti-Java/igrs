/**
 * 
 */
package com.cg.neel.igrs.users;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Preeti
 * @Description : This table contains all users: registered users and  guest users.
 */

@Entity
@Data 
@Table(name = "USERS")
@NoArgsConstructor
public class UsersAccessBean  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="USERS_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long userId;
	
	@OneToOne(cascade =CascadeType.ALL)
	@JoinColumn(name = "userId", insertable = false, updatable = false)
	private UserRegAccessBean userRegAccessBean;
	
	@Column(name="REGISTERTYPE") ////R - registered user G - guest user A - administrator S - site administrator
	private char registerType;
	
	@Column(name="REGISTRATION") //The date or time that the user was registered
	private Date registration;
	
	@Column(name="LASTSESSION")  // The date and time that the user last visited
	private Date lastSession; 
	
	@Column(name="REGISTRATIONUPDATE") // The date or time the user last changed registration information.
	private Date registrationUpdate;
	
	@Column(name="REGISTRATIONCANCEL")
	private Date registrationCancel;
	
}
