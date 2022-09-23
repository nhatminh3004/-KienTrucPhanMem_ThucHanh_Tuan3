package com.example.spring_boot_api_jwt_ad.service;

import com.example.spring_boot_api_jwt_ad.entity.Role;

public interface RoleService {
	void addRole(Role role);
	Role findRoleByRoleName(String roleName);
}	
