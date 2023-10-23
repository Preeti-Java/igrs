/**
 * 
 */
package com.cg.neel.igrs.users;

import java.util.Date;

import lombok.Data;

/**
 * @author Preeti
 * @Description : This table contains all user contact related info.
 */

@Data 
public class AddressAccessBeanDto {

	private Long addressId;
	
	private char addressType;
	
	private char status;
	
	private String phone1; 
	
	private String phone2;
	
	private String email1;
	
	private String email2;
	
	private String address1;
	
	private String address2;
	
	private String address3;
	
	private String city;
	
	private String state;
	
	private String country;
	
	private String zipcode;
	
	private Date lastCreate;
	
	private int optCounter;
	
	private String field1;
	
	private String field2;
	
	private String field3;
	
}
