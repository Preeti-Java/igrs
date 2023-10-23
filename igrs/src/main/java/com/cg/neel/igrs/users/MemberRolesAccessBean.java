/**
 * 
 */
package com.cg.neel.igrs.users;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

/**
 * @author Preeti
 *@Description : This table contains member connect with roles name, Each member can play one or more roles
 *
 */

@Entity
@Table(name="MBRROLE")
@Data
public class MemberRolesAccessBean {
	
	@Id
	@Column(name="MBRROLE_ID")
	private Long mbroleId;
	
	@OneToOne(cascade =CascadeType.ALL)
	@JoinColumn(name = "userId", insertable = false, updatable = false)
	private UserRegAccessBean userRegAccessBean;
	
	@OneToOne(cascade =CascadeType.ALL)
	@JoinColumn(name = "memberId")
	private MemberAccessBean memberAccessBean;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "roleId")
	private RolesAccessBean rolesAccessBean;
	
	@Column(name="OPTCOUNTER")
	private int optCounter;
	
	

}
