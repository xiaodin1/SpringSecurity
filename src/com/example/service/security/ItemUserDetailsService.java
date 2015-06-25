/**
 * 软件著作权：学科网
 * 系统名称：xy360
 * 创建日期： 2015-01-09
 */
package com.example.service.security;

import java.io.Serializable;
import java.util.Collection;
import java.util.LinkedHashSet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.example.entity.Authority;
import com.example.entity.Role;
import com.example.entity.User;
import com.example.service.UserService;


/**
 * 登录验证
 * @version 1.0
 * @author LiaoGang
 */

@Component("userDetailsService")
public class ItemUserDetailsService implements UserDetailsService ,Serializable{
	private static final long serialVersionUID = 2735743264777125232L;
	
	@Autowired
	private UserService userService;
	
	@Override
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		
		User user = userService.getByUsername(username);
		if(user==null) {
			throw new UsernameNotFoundException("用戶名不存在!");
		}
		
		String password = user.getPassword();
		boolean enabled = user.getEnabled();
		boolean accountNonExpired = true;
		boolean credentialsNonExpired = true;
		boolean accountNonLocked = true;
		Collection<GrantedAuthority> authorities = new LinkedHashSet<>();
		
		//获取该用户所具有的所有权限,然后添加到springsecurity框架中
		for(Role role : user.getRoles()){
			for(Authority authority : role.getAuthoritys()) {
				authorities.add(new GrantedAuthorityImpl(authority.getName()));
			}
		}
		
		
		SecurityUser securityUser = new SecurityUser(username, password, enabled,
			accountNonExpired, credentialsNonExpired, accountNonLocked, authorities, user);
		
		return securityUser;
	}
	
	public class SecurityUser extends org.springframework.security.core.userdetails.User {
		private static final long serialVersionUID = 5031099308611338175L;
		private User user;
		public User getUser() {
			return user;
		}
		public SecurityUser(String userName, String password, boolean enabled,
			boolean accountNonExpired, boolean credentialsNonExpired,
			boolean accountNonLocked,
			Collection<? extends GrantedAuthority> authorities,
			User user) {
			
			super(userName, password, enabled, accountNonExpired, credentialsNonExpired,
					accountNonLocked, authorities);
			this.user = user;
		}
	}
}
