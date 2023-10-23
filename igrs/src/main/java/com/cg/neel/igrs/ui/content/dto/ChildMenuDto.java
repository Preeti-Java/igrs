/**
 * 
 */
package com.cg.neel.igrs.ui.content.dto;

import java.io.Serializable;

import lombok.Data;

/**
 * @author Preeti
 *
 */
@Data
public class ChildMenuDto  implements Serializable{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int id;
	
	private String labelEn;

	private String labelHi;
	
	private String url;
}
