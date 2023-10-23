/**
 * 
 */
package com.cg.neel.igrs.searchdata.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.NoRepositoryBean;

import com.cg.neel.igrs.searchdata.AbstractMappedType;

/**
 * @author User
 *
 */
@NoRepositoryBean
public interface MappedTypeRepository<T extends AbstractMappedType> extends JpaRepository<T, Integer>{
	
	
	@Query("SELECT t FROM #{#entityName} t")
	public List<T> findAll();
	
	@Query("SELECT t FROM #{#entityName} t")
	public List<T> findByDistrictId();

	 

}
