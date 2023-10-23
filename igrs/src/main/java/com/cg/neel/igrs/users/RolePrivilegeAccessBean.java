/**
 * 
 */
package com.cg.neel.igrs.users;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

/**
 * @author Preeti
 * @Description Roles have many Privilege, such as ADMIN Role have READ, WRITE and many more...
 *
 */
@Entity
@Table(name="ROLEPRIVILEGE")
@Data
public class RolePrivilegeAccessBean {

	@Id
	@Column(name="ROLEPRIVILEGE_ID")
	private Long rolePrivilegeId;
	
	@ManyToOne
	@JoinColumn(name="privilegeId")
	private PrivilegeAccessBean privilegeAccessBean;
	
	@ManyToOne
	@JoinColumn(name="roleId")
	private RolesAccessBean rolesAccessBean;
	

	
}
