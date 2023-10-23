package com.cg.neel.igrs.searchdata;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="SubDistrict")
@Getter
@Setter
public class SubDistrictAccessBean {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int subDistrictId;
	
	@Column(name ="subDistrict")
	private String subDistrict;
	
	@Column(name ="subDistrictHi")
	private String subDistrictHi;
	
	/*
	 * @ManyToOne
	 * 
	 * @JoinColumn(name = "districtId", referencedColumnName = "districtId") private
	 * DistrictAccessBean districtAccessBean;
	 */
	 
	
}
