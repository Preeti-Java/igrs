/**
 * 
 */
package com.cg.neel.igrs.ui.content;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.cg.neel.igrs.users.RolesAccessBean;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author Preeti
 * @Description :  This table show relation between menu bar and roles software with HIndi and English
 *   
 *
 */

@Entity
@Table(name="MENUROLE")
public class MenuRoleAccessBean implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="MENUROLE_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long menuRoleId;
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name ="roleId")
	private RolesAccessBean rolesAccessBean;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name ="menuId")
	private MenuAccessBean menuAccessBean;

	/**
	 * @return the menuRoleId
	 */
	public Long getMenuRoleId() {
		return menuRoleId;
	}

	/**
	 * @param menuRoleId the menuRoleId to set
	 */
	public void setMenuRoleId(Long menuRoleId) {
		this.menuRoleId = menuRoleId;
	}

	/**
	 * @return the rolesAccessBean
	 */
	public RolesAccessBean getRolesAccessBean() {
		return rolesAccessBean;
	}

	/**
	 * @param rolesAccessBean the rolesAccessBean to set
	 */
	public void setRolesAccessBean(RolesAccessBean rolesAccessBean) {
		this.rolesAccessBean = rolesAccessBean;
	}

	/**
	 * @return the menuAccessBean
	 */
	public MenuAccessBean getMenuAccessBean() {
		return menuAccessBean;
	}

	/**
	 * @param menuAccessBean the menuAccessBean to set
	 */
	public void setMenuAccessBean(MenuAccessBean menuAccessBean) {
		this.menuAccessBean = menuAccessBean;
	}
	
	
	    
}
