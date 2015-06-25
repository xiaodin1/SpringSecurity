package com.example.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table
public class User extends SuperEntity {
	private static final long serialVersionUID = 6587804352897768224L;

	@Column(name="username", unique=true, length=30)
	private String username;
	
	@Column(name="password", length=128)
	private String password;
	
	@Column(name="email", length=100)
	private String email;
	
	@Column(name="phone", length=20)
	private String phone;
	
	@Column(name="enabled", columnDefinition="bit default 1")
	private Boolean enabled;
	
	@ManyToMany
	@JoinTable(
		name="user_role",
		joinColumns={@JoinColumn(name="user_id")},
		inverseJoinColumns={@JoinColumn(name="role_id")}
	)
	private Set<Role> roles = new HashSet<>();;
	
	
	public User() {
		super();
	}

	public User(String username, String password, String email, String phone) {
		super();
		this.username = username;
		this.password = password;
		this.email = email;
		this.phone = phone;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password
				+ ", email=" + email + ", phone=" + phone + ", id=" + id + "]";
	}
	
}
