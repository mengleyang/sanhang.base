package com.sanhang.shiro;

import java.util.List;

public class SystemRole {
	
	private int id;
	private String name;
	private List<String> permissionsName;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<String> getPermissionsName() {
		return permissionsName;
	}
	public void setPermissionsName(List<String> permissionsName) {
		this.permissionsName = permissionsName;
	}
}
