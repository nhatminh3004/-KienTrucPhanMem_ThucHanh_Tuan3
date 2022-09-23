package com.example.spring_boot_api_jwt_ad.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.spring_boot_api_jwt_ad.entity.Role;
import com.example.spring_boot_api_jwt_ad.repository.RoleRepository;

@Service
public class RoleServiceImpl implements RoleService{
	@Autowired
	private RoleRepository roleRepository;

	@Override
	public void addRole(Role role) {
		roleRepository.save(role);
		
	}

	@Override
	public Role findRoleByRoleName(String roleName) {
		// TODO Auto-generated method stub
		return roleRepository.findRoleByRoleName(roleName);
	}
}
