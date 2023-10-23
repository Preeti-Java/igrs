package com.cg.neel.igrs.searchdata;


import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="District")
public class DistrictAccessBean extends AbstractMappedType{
	
	@OneToMany(mappedBy = "districtAccessBean", cascade = CascadeType.ALL)
	@Fetch(FetchMode.SELECT)
	@JsonIgnore
	private Set<VillageAccessBean> villageAccessBeans;
	

	public static DistrictAccessBean of(String english,String hindi,String description) {
		DistrictAccessBean districtAccessBean = new DistrictAccessBean();
		districtAccessBean.setEnglish(english);
		districtAccessBean.setHindi(hindi);
		districtAccessBean.setDescription(description);
		return districtAccessBean;
	}
	

	/**
	 * @return the villageAccessBeans
	 */
	public Set<VillageAccessBean> getVillageAccessBeans() {
		return villageAccessBeans;
	}



	/**
	 * @param villageAccessBeans the villageAccessBeans to set
	 */
	public void setVillageAccessBeans(Set<VillageAccessBean> villageAccessBeans) {
		this.villageAccessBeans = villageAccessBeans;
	}

	/*
	 * @Id
	 * 
	 * @GeneratedValue(strategy = GenerationType.AUTO) 
	 * private int districtId;
	 * 
	 * @Column(name = "district") 
	 * private String district;
	 * 
	 * @Column(name = "districtHi") 
	 * private String districtHi;
	 * 
	 * @Column(name = "districtEn") 
	 * private String districtEn;
	 * 
	 * @OneToMany(mappedBy = "districtAccessBean", cascade = CascadeType.ALL)
	 * @Fetch(value = FetchMode.SELECT)
	 * @JsonIgnore 
	 * private Set<SubDistrictAccessBean> subDistricts = new HashSet<>();
	 */
	
	
}
