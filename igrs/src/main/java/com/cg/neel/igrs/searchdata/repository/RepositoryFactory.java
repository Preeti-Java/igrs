/**
 * 
 */
package com.cg.neel.igrs.searchdata.repository;

import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;

/**
 * @author User
 *
 */

@Component
@RequiredArgsConstructor
public class RepositoryFactory {
	
	 
	    private final  DistrictRepository districtRepository;

	  
	    private final TehsilRepository tehsilRepository;
	    
	
	    private final VillageRepository villageRepository;
	    
	   
	    private final RegistrationYearRepository registrationYearRepository;


	    public MappedTypeRepository<?> getRepository(String type) {
	        switch (type) {
	            case "DistrictRepository":
	                return districtRepository;
	            case "TehsilRepository":
	                return tehsilRepository;
	            case "VillageRepository":
	            	return villageRepository;
	            case "RegistrationYearRepository":
	            	return registrationYearRepository;
	            default:
	                throw new IllegalArgumentException("Invalid repository type: " + type);
	        }
	    }

}
