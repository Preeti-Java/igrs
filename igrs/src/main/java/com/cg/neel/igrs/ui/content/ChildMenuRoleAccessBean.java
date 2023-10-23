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
import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author Preeti
 * @Description : This table show relation between child menu of menu bar and roles for UI with Hindi and English
 *
 */

@Entity
@Table(name="CHILDMENUROLE")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ChildMenuRoleAccessBean  implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="CHILDMENUROLE_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long childMenuRoleId;
    
	@ManyToOne
	@JoinColumn(name ="roleId")
	@JsonBackReference
	private RolesAccessBean rolesAccessBean;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name ="childMenuId")
	private ChildMenuAccessBean childMenuAccessBean;
    
	
}
