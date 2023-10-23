package com.cg.neel.igrs.users;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "authorities")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuthorityAccessBean {

	  @Id
	    @GeneratedValue(strategy= GenerationType.AUTO,generator="native")
	    @GenericGenerator(name = "native",strategy = "native")
	  @Column(name="authorities_id")
	    private Long authoritiesId;

	    private String name;

	/*
	 * @ManyToOne
	 * 
	 * @JoinColumn(name = "userId") private UserRegAccessBean userRegAccessBean;
	 */
}
