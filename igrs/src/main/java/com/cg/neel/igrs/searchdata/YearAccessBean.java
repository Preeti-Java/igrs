/**
 * 
 */
package com.cg.neel.igrs.searchdata;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author Preeti
 * @Des Year
 *
 */

@Entity
@Table(name = "Year")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class YearAccessBean {
	
	
	@Id
	@Column(name = "Sno")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long sno;
	
	
	@Column(name = "Year")
	private String year;

}
