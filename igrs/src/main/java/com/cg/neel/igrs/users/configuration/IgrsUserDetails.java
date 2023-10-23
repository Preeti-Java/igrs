/**
 * 
 */
package com.cg.neel.igrs.users.configuration;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.cg.neel.igrs.exceptions.TooManyRequestsException;
import com.cg.neel.igrs.exceptions.UnauthorizedException;
import com.cg.neel.igrs.users.PrivilegeAccessBean;
import com.cg.neel.igrs.users.RolesAccessBean;
import com.cg.neel.igrs.users.UserRegAccessBean;
import com.cg.neel.igrs.users.repository.UserRegRepository;

/**
 * @author Preeti
 *
 */

@Service("userDetailsService")
@Transactional

public class IgrsUserDetails implements UserDetailsService{
	
	//Exception
	private static final String USER_DETAILS_NOT_FOUND_EXCEPTION ="User details not found for the user : ";
	private static final String TOO_MANY_TRY_WITH_THIS_NUMBER_EXCEPTION = "Too Many try with this number : ";
	private static final String USER_ID_DISABLED_EXCEPTION = "User Id is disabled :";
	
	@Autowired
	private UserRegRepository userRegRepository;
	
	@Autowired
	private LoginAttemptService loginAttemptService;
	
	public IgrsUserDetails() {
		super();
	}

	@Override
	public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {
		
			UserRegAccessBean users= this.userRegRepository.findByMobileNo(username);
			if(users == null)
				throw new UsernameNotFoundException(USER_DETAILS_NOT_FOUND_EXCEPTION + username);
			
			//Check mobile is verified or not			
			 if (loginAttemptService.isBlocked()) { //Always return false because no code
				 throw new TooManyRequestsException(TOO_MANY_TRY_WITH_THIS_NUMBER_EXCEPTION + username);
			 }
			 
			
			
			//Check status is true => Means user id is enable
			boolean status=users.getStatus()==1;
			if(!status) {
				throw new UnauthorizedException(USER_ID_DISABLED_EXCEPTION + username);
			}
			
			return new org.springframework.security.core.userdetails.User(users.getMobileNo(), users.getLogonPassword(),
					status, true, true, true, getAuthorities(users.getRolesAccessBeans()));
			
	}
	
	private Collection<? extends GrantedAuthority> getAuthorities(Collection<RolesAccessBean> rolesAccessBeans) {
		  List<GrantedAuthority> authorities = new ArrayList<>();

	        // Extract list of permissions (name)
			/*
			 * this.employee.getPermissionList().forEach(p -> { GrantedAuthority authority =
			 * new SimpleGrantedAuthority(p); authorities.add(authority); });
			 */

	        // Extract list of roles (ROLE_name)
		  rolesAccessBeans.forEach(r -> {
	            GrantedAuthority authority = new SimpleGrantedAuthority(r.getName());
	            authorities.add(authority);
	        });

	        return authorities;
	        //Update in future
		//return getGrantedAuthority(getPrivileges(rolesAccessBeans)); 
	}

	private Collection<? extends GrantedAuthority> getGrantedAuthority(List<String> privileges) {
		List<GrantedAuthority> authorities = new ArrayList<>();
		for(String privilege : privileges)
			authorities.add(new SimpleGrantedAuthority(privilege));
		
		return authorities;
	}
	
	
	private List<String> getPrivileges(Collection<RolesAccessBean> roles) {
		
		List<String> privileges=new ArrayList<>();
		List<PrivilegeAccessBean> collections=new ArrayList<>();
		
		     for(RolesAccessBean role:roles) {
			  privileges.add(role.getName()); // For root => GHOST, For CHIPS => SUPERADMIN etc
			  //Update in future
			 // collections.addAll(role.getPrivilegeAccessBean());
		     }
		
		for(PrivilegeAccessBean items:collections)
			privileges.add(items.getName());
		return privileges;
		
	}

	/**
	 * @param password
	 * @param password2
	 * @return
	 */
	public boolean matchPassword(String providedPassword, String securedPassword) {
		PasswordEncoder passwordEncoder = new BCryptPasswordEncoder(); 
	    return !passwordEncoder.matches(providedPassword, securedPassword);
	}
}
