/**
 * 
 */
package com.cg.neel.igrs.core.shared.service;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.cg.neel.igrs.ui.content.MenuAccessBean;
import com.cg.neel.igrs.users.RolesAccessBean;

/**
 * @author Preeti
 *
 */
public interface HeaderService {

	/**
	 * @return menu
	 * 
	 */
	Map<String,Object> getDefaultMenu();

	/**
	 * @param roleName
	 * @return menu
	 */
	Map<String, Object> getMenuByRole(String roleName);

	/**
	 * @return all roles list
	 */
	List<Object[]> findAllRoles();

	/**
	 * @param roleId
	 * @param data
	 * @return 
	 * @return
	 */
	 void saveMenu(Long roleId, Set<MenuAccessBean> data);

	/**
	 * @param roleId
	 * @return
	 */
	RolesAccessBean getByRoleId(Long roleId);

	/**
	 * @param menuId
	 */
	void deleteByMenuId(Long menuId);

	/**
	 * @param menuAccessBean
	 * @return
	 */
	MenuAccessBean updateMenu(MenuAccessBean menuAccessBean);

	/**
	 * @param menudId
	 * @return
	 */
	Map<String, Object> getByOwnerMenu(Long menudId);


	/**
	 * @return For All List
	 */
	Set<Object> getDataList(Long menuId) throws IllegalAccessException,NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException ;

	/**
	 * @param map key: menuId , value: menuValue(this menuId is a dependency of main menuId which data is required)
	 * @param menuId -> Data required
	 * @param ch -> table data
	 * @return
	 */
	Set<Object> getDataListByMenuValue(Map<String, String> map, Long menuId, String ch) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException;

}
