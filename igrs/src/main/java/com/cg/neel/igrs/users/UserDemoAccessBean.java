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
 * @Description : This table stores demographics information for users.
 */

@Entity
@Data 
@Table(name = "USERDEMO")
@NoArgsConstructor
public class UserDemoAccessBean  implements Serializable{

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
	
	@Column(name="GENDER") 
	private char gender;
	
	@Column(name="AGE")  
	private char age;
	
	@Column(name="COMPANYNAME")  // 
	private String companyName; 
	
	@Column(name="DATEOFBIRTH") 
	private Date dateOfBirth;
	
	@Column(name="FIELD1")
	private String filed1;
	
	@Column(name="FIELD2")
	private String filed2;
	
	@Column(name="FIELD3")
	private String filed3;
	
	@Column(name="FIELD4")
	private String filed4;
	
	@Column(name="FIELD5")
	private String filed5;
	
	@Column(name="OPTCOUNTER")
	private int optCounter;
	
	
	
}
