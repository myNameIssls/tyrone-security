package cn.tyrone.security.sys.bean;

import java.io.Serializable;
import java.util.List;

public class SecurityUser implements Serializable {
	private String userId;
	private String username;
	private String password;
	private String status;
	
	private List<SecurityPermission> securityPermissionList;
	
	public List<SecurityPermission> getSecurityPermissionList() {
		return securityPermissionList;
	}

	public void setSecurityPermissionList(
			List<SecurityPermission> securityPermissionList) {
		this.securityPermissionList = securityPermissionList;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
