/**
 * 
 */
package com.cg.neel.igrs.searchdata;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.MappedSuperclass;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import lombok.Getter;
import lombok.Setter;

/**
 * @author User
 *
 */
@MappedSuperclass
@Getter
@Setter
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@JsonTypeInfo(use=JsonTypeInfo.Id.NAME,
        include=JsonTypeInfo.As.EXISTING_PROPERTY,
        property="type")
@JsonSubTypes({
	  @JsonSubTypes.Type(value = DistrictAccessBean.class, name = "district"),
	  @JsonSubTypes.Type(value = TehsilAccessBean.class, name = "tehsil")
	  })
public abstract  class AbstractMappedType {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
	
	@Column(name = "description")
    private String description;
	
	@Column(name = "hindi")
    private String hindi;
	
	@Column(name = "english")
    private String english;
	
	
	

}
