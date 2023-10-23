/**
 * 
 */
package com.cg.neel.igrs.ui.content;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

/**
 * @author Preeti
 * @Description : This table stores menu present in software with HIndi and English
 *   
 *
 */

@Entity
@Table(name="MENU")
public class MenuAccessBean implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="MENU_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long menuId;
	
	@OneToMany(mappedBy = "menuAccessBean",cascade=CascadeType.ALL)
	@Fetch(FetchMode.SELECT)
	@JsonIgnore
	private Set<ChildMenuAccessBean> childMenuAccessBean;
	
	@OneToMany(mappedBy = "menuAccessBean",cascade=CascadeType.ALL)
	@Fetch(FetchMode.SELECT)
	@JsonIgnore
	private Set<MenuRoleAccessBean> menuRoleAccessBeans;
	
	@Column(name="EN_LABEL")
	private String labelEn;

	@Column(name="HI_LABEL")
	private String labelHi;
	
	@Column(name="URL")
	private String url;
	
	@Column(name="TITLE")
	private String title;
	
	@Column(name="DESCRIPTION")
	private String descriptionEn;
	
	@Column(name="HI_DESCRIPTION")
	private String descriptionHi;
	
	@Column(name="STATUS")
	private Boolean status;
	
	@Column(name="TABLENAME")
	private String tableName;
	
	@Column(name="OPTCOUNTER")
	private int optCounter;

	/**
	 * @return the menuId
	 */
	public Long getMenuId() {
		return menuId;
	}

	/**
	 * @param menuId the menuId to set
	 */
	public void setMenuId(Long menuId) {
		this.menuId = menuId;
	}

	/**
	 * @return the childMenuAccessBean
	 */
	public Set<ChildMenuAccessBean> getChildMenuAccessBean() {
		return childMenuAccessBean;
	}

	/**
	 * @param childMenuAccessBean the childMenuAccessBean to set
	 */
	public void setChildMenuAccessBean(Set<ChildMenuAccessBean> childMenuAccessBean) {
		this.childMenuAccessBean = childMenuAccessBean;
	}

	/**
	 * @return the menuRoleAccessBeans
	 */
	public Set<MenuRoleAccessBean> getMenuRoleAccessBeans() {
		return menuRoleAccessBeans;
	}

	/**
	 * @param menuRoleAccessBeans the menuRoleAccessBeans to set
	 */
	public void setMenuRoleAccessBeans(Set<MenuRoleAccessBean> menuRoleAccessBeans) {
		this.menuRoleAccessBeans = menuRoleAccessBeans;
	}

	/**
	 * @return the labelEn
	 */
	public String getLabelEn() {
		return labelEn;
	}

	/**
	 * @param labelEn the labelEn to set
	 */
	public void setLabelEn(String labelEn) {
		this.labelEn = labelEn;
	}

	/**
	 * @return the labelHi
	 */
	public String getLabelHi() {
		return labelHi;
	}

	/**
	 * @param labelHi the labelHi to set
	 */
	public void setLabelHi(String labelHi) {
		this.labelHi = labelHi;
	}

	/**
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * @param url the url to set
	 */
	public void setUrl(String url) {
		this.url = url;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the descriptionEn
	 */
	public String getDescriptionEn() {
		return descriptionEn;
	}

	/**
	 * @param descriptionEn the descriptionEn to set
	 */
	public void setDescriptionEn(String descriptionEn) {
		this.descriptionEn = descriptionEn;
	}

	/**
	 * @return the descriptionHi
	 */
	public String getDescriptionHi() {
		return descriptionHi;
	}

	/**
	 * @param descriptionHi the descriptionHi to set
	 */
	public void setDescriptionHi(String descriptionHi) {
		this.descriptionHi = descriptionHi;
	}

	/**
	 * @return the status
	 */
	public boolean isStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(boolean status) {
		this.status = status;
	}

	/**
	 * @return the optCounter
	 */
	public int getOptCounter() {
		return optCounter;
	}

	/**
	 * @param optCounter the optCounter to set
	 */
	public void setOptCounter(int optCounter) {
		this.optCounter = optCounter;
	}

	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
}
