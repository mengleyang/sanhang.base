package com.sanhang.shiro;

import java.util.List;
import java.util.Set;

public class SystemUser {
	
	private int id;
	private String username;
	private String password;
	private Set<String> rolesName;
	private List<SystemRole> roleList;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public Set<String> getRolesName() {
		return rolesName;
	}
	public void setRolesName(Set<String> rolesName) {
		this.rolesName = rolesName;
	}
	public List<SystemRole> getRoleList() {
		return roleList;
	}
	public void setRoleList(List<SystemRole> roleList) {
		this.roleList = roleList;
	}
}
