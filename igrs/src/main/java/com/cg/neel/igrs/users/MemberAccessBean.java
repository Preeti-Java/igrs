/**
 * 
 */
package com.cg.neel.igrs.users;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

/**
 * @author Preeti
 * @Description : Stores the list of members (participants) -
 *  A member is either a user, an organizational entity or a member group.
 *
 */

@Entity
@Table(name="MEMBER")
@Data
public class MemberAccessBean  implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="MEMBER_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long memberId;
	
	@ManyToOne
	@JoinColumn(name="userId")
	private UserRegAccessBean userRegAccessBean;
	
	@Column(name="TYPE") //The type of member as follows: O = OrgEntity U = User G = MemberGroup
	private char type;
	
	@Column(name="STATE") //The module approval status as follows: 0 = pending approval 1 = approved 2 = rejected 3 = pending
	private int state;
	
}
