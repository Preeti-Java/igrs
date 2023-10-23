/**
 * 
 */
package com.cg.neel.igrs.users;

import java.io.Serializable;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * @author Preeti
 *
 */
public class SecurityUsers implements UserDetails, Serializable{
	
	private static final long serialVersionUID = -6690946490872875352L;
	
	private final UserRegAccessBean userRegAccessBean;
	
	public SecurityUsers(UserRegAccessBean userRegAccessBean) {
		this.userRegAccessBean=userRegAccessBean;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return null;
	}
	
	
	@Override
	public String getPassword() {
		return userRegAccessBean.getLogonPassword();
	}

	@Override
	public String getUsername() {
		return userRegAccessBean.getLogonId();
	}

	@Override
	public boolean isAccountNonExpired() {
		return userRegAccessBean.getPasswordExpired()==1;
	}

	@Override
	public boolean isAccountNonLocked() {
		return  userRegAccessBean.getStatus()==1;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return userRegAccessBean.getPasswordExpired()==1;
	}

	@Override
	public boolean isEnabled() {
		return  userRegAccessBean.getStatus()==1;
	}

}
