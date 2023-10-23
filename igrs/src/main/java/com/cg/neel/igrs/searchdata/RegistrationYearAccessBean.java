package com.cg.neel.igrs.searchdata;


import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="registrationyear")
public class RegistrationYearAccessBean extends AbstractMappedType{
	
	public static RegistrationYearAccessBean of(String english,String hindi, String description) {
		RegistrationYearAccessBean registrationAccessBean = new RegistrationYearAccessBean();
		registrationAccessBean.setEnglish(english);
		registrationAccessBean.setHindi(hindi);
		registrationAccessBean.setDescription(description);
		return registrationAccessBean;
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
