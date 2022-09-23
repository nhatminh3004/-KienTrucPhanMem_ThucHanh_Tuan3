package com.example.spring_boot_api_jwt_ad.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "t_user")
@Getter
@Setter
public class User extends BaseEntity {

	private String username;

	private String password;

	@OneToMany(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
	@JoinTable(name = "t_user_role", joinColumns = { @JoinColumn(name = "user_id") }, inverseJoinColumns = {
			@JoinColumn(name = "role_id") })

	private Set<Role> roles = new HashSet<>();
	// get set

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

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
	// constructor

	public User(Long id, String deleted, Date createdAt, Date updatedAt, Long createdBy, Long updatedBy,
			String username, String password, Set<Role> roles) {
		super(id, deleted, createdAt, updatedAt, createdBy, updatedBy);
		this.username = username;
		this.password = password;
		this.roles = roles;
	}

	public User(String username, String password, Set<Role> roles) {
		super();
		this.username = username;
		this.password = password;
		this.roles = roles;
	}

	public User() {
		super();
	}

}
