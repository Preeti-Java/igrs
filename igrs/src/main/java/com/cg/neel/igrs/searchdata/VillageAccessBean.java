package com.cg.neel.igrs.searchdata;


import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="village")
public class VillageAccessBean extends AbstractMappedType{
	
	@ManyToOne
	@JoinColumn(name = "districtId")
	private  DistrictAccessBean districtAccessBean;
	
	public static VillageAccessBean of(String english,String hindi, String description,DistrictAccessBean districtAccessBean) {
		
		VillageAccessBean villageAccessBean = new VillageAccessBean();
		villageAccessBean.setEnglish(english);
		villageAccessBean.setHindi(hindi);
		villageAccessBean.setDescription(description);
		villageAccessBean.setDistrictAccessBean(districtAccessBean);
		return villageAccessBean;
		}


	/**
	 * @return the districtAccessBean
	 */
	public  DistrictAccessBean getDistrictAccessBean() {
		return districtAccessBean;
	}

	/**
	 * @param districtAccessBean the districtAccessBean to set
	 */
	public  void setDistrictAccessBean(DistrictAccessBean districtAccessBean) {
		this.districtAccessBean = districtAccessBean;
	}

	
	
	/*
	 * @Id
	 * 
	 * @GeneratedValue(strategy = GenerationType.AUTO) private int tehsilId;
	 * 
	 * @Column(name = "tehsil") private String tehsil;
	 * 
	 * @Column(name = "tehsilHi") private String tehsilHi;
	 * 
	 * @Column(name = "tehsilEn") private String tehsilEn;
	 */
	
}
