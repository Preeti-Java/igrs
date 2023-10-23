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
 * @Description : This table contains all user contact related info.
 */

@Entity
@Data 
@Table(name = "ADDRESS")
@NoArgsConstructor
public class AddressAccessBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ADDRESS_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long addressId;
	
	@OneToOne(cascade =CascadeType.ALL)
	@JoinColumn(name = "userId", insertable = false, updatable = false)
	private UserRegAccessBean userRegAccessBean;
	
	@Column(name="ADDRESSTYPE") //Value
	private char addressType;
	
	@Column(name="STATUS") //Specifies the status of the address. Valid values are P (permanent or current) and T (temporary or historical). 
	private char status;
	
	@Column(name="PHONE1")  
	private String phone1; 
	
	@Column(name="PHONE2") 
	private String phone2;
	
	@Column(name="EMAIL1")
	private String email1;
	
	@Column(name="EMAIL2")
	private String email2;
	
	@Column(name="ADDRESS1")
	private String address1;
	
	@Column(name="ADDRESS2")
	private String address2;
	
	@Column(name="ADDRESS3")
	private String address3;
	
	@Column(name="CITY")
	private String city;
	
	@Column(name="STATE")
	private String state;
	
	@Column(name="COUNTRY")
	private String country;
	
	@Column(name="ZIPCODE")
	private String zipcode;
	
	@Column(name="LASTCREATE")
	private Date lastCreate;
	
	@Column(name="OPTCOUNTER")
	private int optCounter;
	
	@Column(name="FIELD1")
	private String field1;
	
	@Column(name="FIELD2")
	private String field2;
	
	@Column(name="FIELD3")
	private String field3;
	
	
	
}
