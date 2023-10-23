/**
 * 
 */
package com.cg.neel.igrs.ui.content.dto;

import java.io.Serializable;

import lombok.Data;

/**
 * @author Preeti
 * @Description : This dto stores menu and child menu behalf of role present in software with HIndi and English
 *   
 *
 */

@Data
public class MenuDto implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long menuId;
	
	private String labelEn;

	private String labelHi;
	
	private String url;
	
	private String descriptionEn;
	
	private String descriptionHi;
	
	private boolean status;


	
}
