/**
 * 
 */
package com.cg.neel.igrs.users;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedAttributeNode;
import javax.persistence.NamedEntityGraph;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.cg.neel.igrs.ui.content.ChildMenuRoleAccessBean;
import com.cg.neel.igrs.ui.content.MenuRoleAccessBean;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author Preeti
 * @Description : This table stores the roles defined, Once a role is created, you cannot change the
 *  name or description of a role 
 *
 */

@NamedEntityGraph(
        name = "roles-entity-graph",
        attributeNodes = {
                @NamedAttributeNode("name"),
                @NamedAttributeNode("description"),
        }
)
@Entity
@Table(name="ROLES")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RolesAccessBean  implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ROLE_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long roleId;
	

	/*
	 * @OneToMany(mappedBy = "rolesAccessBean",fetch = FetchType.EAGER) private
	 * List<PrivilegeAccessBean> privilegeAccessBean;
	 */
    
    @OneToMany(mappedBy = "rolesAccessBean",cascade = CascadeType.ALL)
    private Set<MenuRoleAccessBean> menuRoleAccessBeans;
    
    
    @OneToMany(mappedBy = "rolesAccessBean",cascade = CascadeType.ALL)
    private Set<ChildMenuRoleAccessBean> childMenuRoleAccessBeans;
	
	@Column(name="NAME")
	private String name;
	
	@Column(name="DESCRIPTION")
	private String description;
	
	@Column(name="OPTCOUNTER")
	private int optCounter;
	
}
