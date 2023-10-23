/**
 * 
 */
package com.cg.neel.igrs.users;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.cg.neel.igrs.users.utils.DateAudit;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * @author Preeti
 * @Description : This table contains all registered users login info
 *
 */

@Entity
@Table(name = "USERREG")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserRegAccessBean extends DateAudit  implements Serializable {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="USERS_ID") //Foreign key to the USERS table
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long userId;
	
	/*
	 * @OneToOne(mappedBy = "userRegAccessBean") private UsersAccessBean
	 * userAccessBean;
	 */
	
	/*
	 * @OneToOne(mappedBy = "userRegAccessBean") private UserDemoAccessBean
	 * userDemoAccessBean;
	 */
	/*
	 * @OneToOne(mappedBy = "userRegAccessBean") private AddressAccessBean
	 * addressAccessBean;
	 */
	
	/*
	 * @OneToMany(mappedBy = "userRegAccessBean") private List<MemberAccessBean>
	 * memberAccessBean;
	 */
	/*
	 * @OneToMany(mappedBy="userRegAccessBean", fetch = FetchType.LAZY, cascade =
	 * CascadeType.ALL) private List<RolesAccessBean> rolesAccessBeans;
	 */
	

	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name = "userreg_roles", joinColumns = @JoinColumn(name = "users_id"), inverseJoinColumns = @JoinColumn(name = "role_Id"))
	private Set<RolesAccessBean> rolesAccessBeans = new HashSet<>();

	//Define Authority also => Read , Write
	/*
	 * @JsonIgnore
	 * 
	 * @OneToMany(mappedBy="userRegAccessBean",fetch=FetchType.EAGER) private
	 * Set<AuthorityAccessBean> authorities;
	 */
	
	@Column(name="STATUS") //1=enabled 0=disabled
	private int status;
	
	@Column(name="LOGONID")
	private String logonId;
	
	@Column(name="MOBILENO")
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY) //Access by frontend but not change
	private String mobileNo;
	
	@Column(name="MOBILEVERIFIED")
	private Boolean mobileVerified;
	
	@Column(name="LOGONPASSWORD")
	private String logonPassword;
	
	@Column(name="PASSWORDEXPIRED") //1=expired 0=not expired 
	private int passwordExpired;
	
	@Column(name="PASSWORDCREATION") //The last time the password for the user was created or updated.
	private Date passwordCreation;
	
	
}

