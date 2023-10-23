package com.cg.neel.igrs.searchdata;


import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="Tehsil")
public class TehsilAccessBean extends AbstractMappedType{
	
	public static TehsilAccessBean of(String english,String hindi, String description) {
		TehsilAccessBean tehsilAccessBean = new TehsilAccessBean();
		tehsilAccessBean.setEnglish(english);
		tehsilAccessBean.setHindi(hindi);
		tehsilAccessBean.setDescription(description);
		return tehsilAccessBean;
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
