/**
 * 
 */
package com.cg.neel.igrs.ui.content;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author Preeti
 * @Description : This table stores child menu of menu bar for UI with Hindi and English
 *
 */

@Entity
@Table(name="CHILDMENU")
public class ChildMenuAccessBean  implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="CHILDMENU_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long childMenuId;
	
    @ManyToOne
    @JoinColumn(name="menuId") 
    private MenuAccessBean menuAccessBean;
    
    @OneToMany(mappedBy = "childMenuAccessBean")
    private Set<ChildMenuRoleAccessBean> childMenuRoleAccessBeans;
    
	@Column(name="EN_LABEL")
	private String labelEn;

	@Column(name="HI_LABEL")
	private String labelHi;
	
	@Column(name="URL")
	private String url;
	
	@Column(name="DESCRIPTION")
	private String description;
	
	@Column(name="EN_DESCRIPTION")
	private String descriptionEn;
	
	@Column(name ="STATUS")
	private boolean status;
	
	@Column(name="OPTCOUNTER")
	private int optCounter;
	
	@Column(name="PAGEID")
	private Long pageId;
	
	@Column(name="NEXTPAGEID")
	private Long nextPageId;
	
	@Column(name="TABLENAME")
	private String tableName;

	@Column(name="SEQ")
	private int sequence;

	
	/**
	 * @return the childMenuId
	 */
	public Long getChildMenuId() {
		return childMenuId;
	}

	/**
	 * @param childMenuId the childMenuId to set
	 */
	public void setChildMenuId(Long childMenuId) {
		this.childMenuId = childMenuId;
	}

	/**
	 * @return the menuAccessBean
	 */
	public MenuAccessBean getMenuAccessBean() {
		return menuAccessBean;
	}

	/**
	 * @param menuAccessBean the menuAccessBean to set
	 */
	public void setMenuAccessBean(MenuAccessBean menuAccessBean) {
		this.menuAccessBean = menuAccessBean;
	}

	/**
	 * @return the childMenuRoleAccessBeans
	 */
	public Set<ChildMenuRoleAccessBean> getChildMenuRoleAccessBeans() {
		return childMenuRoleAccessBeans;
	}

	/**
	 * @param childMenuRoleAccessBeans the childMenuRoleAccessBeans to set
	 */
	public void setChildMenuRoleAccessBeans(Set<ChildMenuRoleAccessBean> childMenuRoleAccessBeans) {
		this.childMenuRoleAccessBeans = childMenuRoleAccessBeans;
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
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
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
	 * @return the pageId
	 */
	public Long getPageId() {
		return pageId;
	}

	/**
	 * @param pageId the pageId to set
	 */
	public void setPageId(Long pageId) {
		this.pageId = pageId;
	}

	/**
	 * @return the nextPageId
	 */
	public Long getNextPageId() {
		return nextPageId;
	}

	/**
	 * @param nextPageId the nextPageId to set
	 */
	public void setNextPageId(Long nextPageId) {
		this.nextPageId = nextPageId;
	}

	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	/**
	 * @return the tableName
	 */
	public String getTableName() {
		return tableName;
	}

	/**
	 * @param tableName the tableName to set
	 */
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	/**
	 * @return the sequence
	 */
	public int getSequence() {
		return sequence;
	}

	/**
	 * @param sequence the sequence to set
	 */
	public void setSequence(int sequence) {
		this.sequence = sequence;
	}
	
	
	
}
