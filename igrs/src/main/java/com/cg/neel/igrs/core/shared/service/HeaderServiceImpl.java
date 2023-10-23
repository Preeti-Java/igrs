/**
 * 
 */
package com.cg.neel.igrs.core.shared.service;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.data.repository.Repository;
import org.springframework.stereotype.Service;

import com.cg.neel.igrs.exceptions.SearchingCredentialException;
import com.cg.neel.igrs.searchdata.AbstractMappedType;
import com.cg.neel.igrs.searchdata.repository.RepositoryFactory;
import com.cg.neel.igrs.ui.content.ChildMenuAccessBean;
import com.cg.neel.igrs.ui.content.MenuAccessBean;
import com.cg.neel.igrs.ui.content.MenuRoleAccessBean;
import com.cg.neel.igrs.ui.content.repository.ChildMenuRepository;
import com.cg.neel.igrs.ui.content.repository.MenuRepository;
import com.cg.neel.igrs.ui.content.repository.MenuRoleRepository;
import com.cg.neel.igrs.users.RolesAccessBean;
import com.cg.neel.igrs.users.repository.RolesRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * @author Preeti
 *
 */
@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class HeaderServiceImpl implements HeaderService{

	private final RolesRepository roleRepository;
	private final MenuRoleRepository menuRoleRepository;
	private final MenuRepository menuRepository;
	private final ChildMenuRepository childMenuRepository;
	private final RepositoryFactory repositoryFactory;
	
	private static final String MENU_MODEL = "MenuModel";
	private static final String LABEL_ENGLISH = "labelEn";
	private static final String LABEL_HINDI = "labelHi";
	private static final String URL = "url";
	private static final String CHILD_MENU_SET = "childMenuSet";
	private static final String ID = "id";
	private static final String SEQ = "seq";
	private static final String DATA_ID = "dataId";
	private static final String REPOSITORY = "Repository";
	private static final String ACCESS_BEAN = "AccessBean";
	
	//Path
	private static final String ACCESS_BEAN_PATH = "com.cg.neel.igrs.searchdata.";
	
	//Method name
	private static final String FIND_ALL = "findAll";
	private static final String FIND_BY = "findBy";
	
	//Exception 
	private static final String SOMETHING_MISSING = "Something missing";
   

	@Override
	public Map<String,Object> getDefaultMenu() {
		Map<String,Object> menuSets=new HashMap<>();
		//Default Menu for every guest User
		// Guest User Id : 5
		
		log.debug("Getting Roles From Roles Table");
		RolesAccessBean role=roleRepository.getByRoleId(5L);
		 
		if (role != null) {
			log.debug("fetching menuSet and childMenu from role object");
			//fetching menuSet and childMenu from role object
			Set<MenuRoleAccessBean> menuRoleSets = role.getMenuRoleAccessBeans();
					
			//Create a menuSet with childMenu
			Set<Object> menuSet = menuSet(menuRoleSets);
			menuSets.put(MENU_MODEL,menuSet);	
			return menuSets;
		}
		return null;
	}

	/**
	 * @param menuRoleSet
	 * @param childMenuRoleSet 
	 * @return menu Set
	 */
	private Set<Object> menuSet(Set<MenuRoleAccessBean> menuRoleSet) {
		Set<Object> menuSet = new HashSet<>();
				
				for(MenuRoleAccessBean menuRole : menuRoleSet) {
					 MenuAccessBean menuData = menuRole.getMenuAccessBean();
					//Set menu with childMenu
					Map<String,Object> menu=new HashMap<>();
					
					menu.put(LABEL_ENGLISH,menuData.getLabelEn());
					menu.put(LABEL_HINDI,menuData.getLabelHi());
					menu.put(URL,menuData.getUrl());
					menuSet.add(menu);			
				}
				
				return menuSet;
	}

	@Override
	public Map<String, Object> getMenuByRole(String roleName) {
		Map<String,Object> menuSets=new HashMap<>();
		//Default Menu for every guest User
		
		RolesAccessBean roleAccessBean=roleRepository.getByName(roleName);
		
		//Fetching MenuRole data 
		//List<MenuRoleAccessBean> menuRoleSets = menuRoleRepository.findAllByRole(roleAccessBean.getRoleId()); 
		
		//fetching menuSet and childMenu from role object
		Set<MenuRoleAccessBean> menuRoleSet = roleAccessBean.getMenuRoleAccessBeans();
		
		//Create a menuSet with childMenu
		Set<Object> menuSet = menuSet(menuRoleSet);
		
		menuSets.put(MENU_MODEL,menuSet);	
		
		return menuSets;
	}

	@Override
	public  List<Object[]> findAllRoles() {
		return roleRepository.findRoles();
	}

	@Override
	public RolesAccessBean getByRoleId(Long roleId) {
		return roleRepository.getByRoleId(roleId);
	}

	@Override
	public void saveMenu(Long roleId, Set<MenuAccessBean> data) {
		
		RolesAccessBean roleAccessBean =  roleRepository.getByRoleId(roleId);
		 
		for(MenuAccessBean menu : data) {
			MenuRoleAccessBean menuRoleAccessBean = new MenuRoleAccessBean();
			menuRoleAccessBean.setRolesAccessBean(roleAccessBean);
			menuRoleAccessBean.setMenuAccessBean(menu);
			menuRoleRepository.save(menuRoleAccessBean);
		}
	}

	@Override
	public void deleteByMenuId(Long menuId) {
		menuRepository.deleteMenuAndMenuRoleByMenuId(menuId);
	}

	@Override
	public MenuAccessBean updateMenu(MenuAccessBean menuAccessBean) {
		return menuRepository.save(menuAccessBean);
	}

	@Override
	public Map<String, Object> getByOwnerMenu(Long menuId) {
		Map<String,Object> menuSets=new HashMap<>();
		
		MenuAccessBean menuAccessBean = menuRepository.findByMenuId(menuId);
		//Return Child Menu Labels
		Set<ChildMenuAccessBean> childMenuAccessBeans = menuAccessBean.getChildMenuAccessBean();
		//Set SubMenu List
		 Set<Object> childMenuSet = childMenuSet(childMenuAccessBeans);
		 
		menuSets.put(CHILD_MENU_SET,childMenuSet);	
		
		return menuSets;
	}
	

	/**
	 * @param childMenuList
	 * @param childMenuRoleSet 
	 * @return menu Set
	 */
	private Set<Object> childMenuSet(Set<ChildMenuAccessBean> childMenuList) {
		Set<Object> childMenuSet = new LinkedHashSet<>();
		
		List<ChildMenuAccessBean> childMenuListSorted= new ArrayList<>(childMenuList);
		 // Sort the list based on the "seq" parameter using a custom comparator
		Collections.sort(childMenuListSorted, Comparator.comparingInt(ChildMenuAccessBean::getSequence));
		
				for(ChildMenuAccessBean childMenuData : childMenuListSorted) {
					//Set menu with childMenu
					Map<String,Object> childMenu=new HashMap<>();
					
					
					childMenu.put(LABEL_ENGLISH,childMenuData.getLabelEn());
					childMenu.put(LABEL_HINDI,childMenuData.getLabelHi());
					childMenu.put(ID,childMenuData.getChildMenuId());
					childMenu.put(SEQ,childMenuData.getSequence());
					childMenuSet.add(childMenu);			
				}
				
				return childMenuSet;
	}


	@Override
	public Set<Object> getDataList(Long menuId) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
		
		List<?> list = getDataListByMenuId(menuId);
		//Now set in object
		return dataSet(list);
	}

	/**
	 * @return 
	 * @return
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 * @throws SecurityException 
	 * @throws NoSuchMethodException 
	 * @throws InvocationTargetException 
	 * @throws IllegalArgumentException 
	 */
	private  List<?> getDataListByMenuId(Long menuId) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
				
		List<?> result = null ;
		String tableName = getTableName(menuId);

		try {
			
		    // Get the repository bean using the repository factory
		    Repository<?, ?> repository = repositoryFactory.getRepository(tableName + REPOSITORY);

		    // Find the correct method "findAll()" in the repository class
		    Method m = repository.getClass().getMethod(FIND_ALL);

		    // Invoke the method on the repository instance (not on the repository class)
		     result = (List<?>) m.invoke(repository);

		    // Handle the result as needed
		} catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
		    e.printStackTrace();
		}    
				        
				        return result;
				
	}

	/**
	 * @param menuId
	 * @return tableName in database
	 */
	private String getTableName(Long menuId) {
		//Find menu name => ChildMenuId
		ChildMenuAccessBean childMenuAccessBean = childMenuRepository.findTableNameByChildMenuId(menuId);
				
		return childMenuAccessBean.getTableName().trim();
	}

	/**
	 * @param tehsilList
	 * @return
	 */
	private Set<Object> dataSet(List<?> list) {
      Set<Object> dataSet = new LinkedHashSet<>();
		
		for(Object obj : list) {
			 // Assuming MyMappedTypeBean extends AbstractMappedTypeBean
		    if (obj instanceof AbstractMappedType) {
				//Set Required data from Tehsil
				Map<String,Object> data = new HashMap<>();
				
				  data.put(DATA_ID, obj);
				  dataSet.add(data);
		    }
		}
		
		return dataSet;
	}

	@Override
	public Set<Object> getDataListByMenuValue(Map<String, String> map, Long menuId, String ch) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
	
		List<?> result = null ;
		
		//Get Key and Value
	    Long key = 0L;
	    Long value = 0L;
	    		
		 // Iterate over the map entries
        for (Map.Entry<String, String> entry : map.entrySet()) {
        	try {
             key = Long.parseLong(entry.getKey());
             value = Long.parseLong(entry.getValue());
        	}
        	catch(Exception e) {
        		System.out.println(e);
        	}
        }
		
		//get tableName in database
		String tableName = getTableName(menuId);
		
	    // Get the repository bean using the repository factory
	    Repository<?, ?> repository = repositoryFactory.getRepository(tableName + REPOSITORY);

	    Method m;
	    // Find the correct method "findAll()/findBy/..." in the repository class
	    if(map.size() <= 3)
	    {
	      m = repository.getClass().getMethod(FIND_ALL);
	   // Invoke the method on the repository instance (not on the repository class)
	      result = (List<?>) m.invoke(repository);
	    }
	    else {
	    	
	    	//Major Condition for dependency
	    	//e.g. village table has dependency with District table
	    	//Check
	    	
	    	//get tableName in database
			String keytableName = getTableName(key);
	    	
	    	boolean isDependencyExist = checkDependencyInBothTable(tableName,keytableName);
	    	if(!isDependencyExist)
	    		throw new SearchingCredentialException(SOMETHING_MISSING);
	    	
	    
			
	    	// Build the method name dynamically (e.g., findByDistrictId, findByVillageId, findBySubdistrictId)
            String methodName = FIND_BY + keytableName.substring(0, 1).toUpperCase() + keytableName.substring(1)+ ID;
            
            m = repository.getClass().getMethod(methodName,Integer.class);

            // Invoke the method on the repository instance (not on the repository class)
		  Object   result1 =  m.invoke(repository,value.intValue());
		  result = (List<?>) result1;

	    }
	    
	  
	    // Handle the result as needed
		return dataSet(result);
	}

	/**
	 * @param tableName - primary table
	 * @param keytableName - for column check
	 * @return
	 */
	private boolean checkDependencyInBothTable(String tableName, String keytableName) {
		try {
		//Create AccessBean with TableName
	      String className = ACCESS_BEAN_PATH + tableName + ACCESS_BEAN; 
		Class<?> someClass = Class.forName(className);
		
		String varName = capitaliseFirstLetter(keytableName);
		Field someField = someClass.getDeclaredField(varName + ACCESS_BEAN);
		
		}
		catch(Exception e) {
			return false;
		}
		return true;
	}

		 String capitaliseFirstLetter(String name){
		      return name.substring(0, 1).toLowerCase() + name.substring(1);
		}
		 
}
