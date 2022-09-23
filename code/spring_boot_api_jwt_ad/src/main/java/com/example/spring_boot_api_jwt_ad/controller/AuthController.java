package com.example.spring_boot_api_jwt_ad.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.spring_boot_api_jwt_ad.authen.UserPrincipal;
import com.example.spring_boot_api_jwt_ad.entity.Token;
import com.example.spring_boot_api_jwt_ad.entity.User;
import com.example.spring_boot_api_jwt_ad.service.TokenService;
import com.example.spring_boot_api_jwt_ad.service.UserService;
import com.example.spring_boot_api_jwt_ad.util.JwtUtil;

@RestController
public class AuthController {

	@Autowired
	private UserService userService;

	
	@Autowired
	private JwtUtil jwtUtil;

	@Autowired
	private TokenService tokenService;

	@PostMapping("/register")
	public User register(@RequestBody User user) {
		user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));

		return userService.createUser(user);
	}

	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody User user) {

		UserPrincipal userPrincipal = userService.findByUsername(user.getUsername());

		if (null == user || !new BCryptPasswordEncoder().matches(user.getPassword(), userPrincipal.getPassword())) {

			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Mật khẩu hoặc tài khoản không hợp lệ!");
		}

		Token token = new Token();
		token.setToken(jwtUtil.generateToken(userPrincipal));

		token.setTokenExpDate(jwtUtil.generateExpirationDate());
		token.setCreatedBy(userPrincipal.getUserId());
		tokenService.createToken(token);

		return ResponseEntity.ok(token.getToken());
	}

//	@PostMapping("/addRole")
//	public ResponseEntity<?> addRole(@RequestBody List<RoleLayTuTenUser> roleFromUser) {
//		List<User> listUser = new ArrayList<>();
//		for (RoleLayTuTenUser roleUser : roleFromUser) {
//			User user = userService.layUserBangUserName(roleUser.getUserName());
//			if (user != null) {
//				Set<Role> roles = user.getRoles();
//				roleService.addRole(new Role(user.getId(), user.getDeleted(), user.getCreatedAt(), user.getUpdatedAt(),
//						user.getCreatedBy(), user.getUpdatedBy(), roleUser.getRoleName(), roleUser.getRoleKey(), null));
//				roles.add(roleService.timRoleBangRoleName(roleUser.getRoleName()));
//				user.setRoles(roles);
//				listUser.add(userService.createUser(user));
//			}
//		}
//		return ResponseEntity.ok(listUser);
//
//	}
	

	@GetMapping("/hello")
	@PreAuthorize("hasAnyAuthority('USER_READ')")
	public ResponseEntity hello() {
		return ResponseEntity.ok("hello");
	}

//    Object principal = SecurityContextHolder
//            .getContext().getAuthentication().getPrincipal();
//
//        if (principal instanceof UserDetails) {
//        UserPrincipal userPrincipal = (UserPrincipal) principal;
//    }

}
