/**
 * 
 */
package com.cg.neel.igrs.users.configuration;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

/**
 * 
 */
public class IgrsUser extends User{

	private Long userId;
	
	/**
	 * @param username
	 * @param password
	 * @param enabled
	 * @param accountNonExpired
	 * @param credentialsNonExpired
	 * @param accountNonLocked
	 * @param authorities
	 */
	
	public IgrsUser(String username, String password, boolean enabled, boolean accountNonExpired,
			boolean credentialsNonExpired, boolean accountNonLocked,
			Collection<? extends GrantedAuthority> authorities) {
		super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
		
	}

	/**
	 * @param mobileNo
	 * @param logonPassword
	 * @param enabled
	 * @param accountNonExpired
	 * @param credentialsNonExpired
	 * @param authorities
	 * @param userId
	 */
	public IgrsUser(String mobileNo, String logonPassword, boolean enabled, boolean accountNonExpired,
			boolean credentialsNonExpired, Collection<? extends GrantedAuthority> authorities, Long userId) {
		super(mobileNo, logonPassword, enabled, accountNonExpired, credentialsNonExpired,  credentialsNonExpired, authorities);
		this.userId = userId;
	}

	@Override
	public Collection<GrantedAuthority> getAuthorities() {
		return super.getAuthorities();
	}

	@Override
	public String getPassword() {
		return super.getPassword();
	}

	@Override
	public String getUsername() {
		return super.getUsername();
	}

	@Override
	public boolean isEnabled() {
		return super.isEnabled();
	}

	@Override
	public boolean isAccountNonExpired() {
		return super.isAccountNonExpired();
	}

	@Override
	public boolean isAccountNonLocked() {
		return super.isAccountNonLocked();
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return super.isCredentialsNonExpired();
	}

	@Override
	public void eraseCredentials() {
		super.eraseCredentials();
	}

	@Override
	public boolean equals(Object obj) {
		return super.equals(obj);
	}

	@Override
	public int hashCode() {
		return super.hashCode();
	}

	@Override
	public String toString() {
		return super.toString();
	}

	/**
	 * @return the userId
	 */
	public Long getUserId() {
		return userId;
	}

	/**
	 * @param userId the userId to set
	 */
	public void setUserId(Long userId) {
		this.userId = userId;
	}

	
	
}
