package com.example.spring_boot_api_jwt_ad.entity;

public class RoleLayTuTenUser {
	private String userName;
	private String roleName;
	private String roleKey;

	public RoleLayTuTenUser() {
		super();
	}

	public RoleLayTuTenUser(String userName, String roleName, String roleKey) {
		super();
		this.userName = userName;
		this.roleName = roleName;
		this.roleKey = roleKey;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getRoleKey() {
		return roleKey;
	}

	public void setRoleKey(String roleKey) {
		this.roleKey = roleKey;
	}

}
