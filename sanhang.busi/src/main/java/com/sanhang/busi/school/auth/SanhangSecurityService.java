package com.sanhang.busi.school.auth;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sanhang.shiro.SecurityService;
import com.sanhang.shiro.SystemRole;
import com.sanhang.shiro.SystemUser;

@Service
public class SanhangSecurityService implements SecurityService {
	
	@Autowired
	UserMapper userMapper;

	@Override
	public SystemUser findByName(String loginName) {
		SystemUser systemUser = new SystemUser();
		User user = userMapper.selectUserRole(loginName);
		if(user!=null){
			systemUser.setId(user.getId());
			systemUser.setUsername(user.getUsername());
			systemUser.setPassword(user.getPassword());
			List<Role> roles = user.getRoles();
			Set<String> rolesName = new HashSet<String>();
			List<SystemRole> systemRoles = new ArrayList<SystemRole>(roles.size());
			for(Role role:roles){
				rolesName.add(role.getRolename());
				SystemRole sr = new SystemRole();
				sr.setId(role.getId());
				sr.setName(role.getRolename());
				List<Permission> perms = role.getPermissions();
				if(perms!=null&&perms.size()>0){
					List<String> permList = new ArrayList<String>(perms.size());
					for(Permission perm:perms){
						permList.add(perm.getPermname());
					}
					sr.setPermissionsName(permList);
				}else{
					sr.setPermissionsName(new ArrayList<String>());
				}
				systemRoles.add(sr);
			}
			systemUser.setRoleList(systemRoles);
			systemUser.setRolesName(rolesName);
		}
		return systemUser;
	}

}
