/**
 * 
 */
package com.cg.neel.igrs.users;

import java.util.Date;

import lombok.Data;

/**
 * @author Preeti
 * @Description : This dto stores demographics information for users.
 */

@Data
public class UserDemoAccessBeanDto {

	private Long userId;

	private UsersAccessBean userAccessBean;

	private char gender;

	private char age;

	private String companyName;

	private Date dateOfBirth;

	private String filed1;

	private String filed2;

	private String filed3;

	private String filed4;

	private String filed5;

	private int optCounter;

}
