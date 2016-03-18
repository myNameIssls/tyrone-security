package cn.tyrone.security.sys.bean;

import java.io.Serializable;
import java.util.List;

public class SecurityUser implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6766587419812540063L;
	
	/**
	 * 用户编号
	 */
	private String userId;
	
	/**
	 * 用户名，唯一
	 */
	private String username;
	
	/**
	 * 用户密码
	 */
	private String password;
	
	/**
	 * 是否锁定
	 * 【0:示锁定 1:锁定】
	 */
	private String locked;
	
	/**
	 * 盐
	 */
	private String salt;
//	private String empId
	private List<SecurityRole> securityRoleList;
	
	private List<SecurityPermission> securityPermissionList;

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

	public String getLocked() {
		return locked;
	}

	public void setLocked(String locked) {
		this.locked = locked;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public List<SecurityRole> getSecurityRoleList() {
		return securityRoleList;
	}

	public void setSecurityRoleList(List<SecurityRole> securityRoleList) {
		this.securityRoleList = securityRoleList;
	}

	public List<SecurityPermission> getSecurityPermissionList() {
		return securityPermissionList;
	}

	public void setSecurityPermissionList(
			List<SecurityPermission> securityPermissionList) {
		this.securityPermissionList = securityPermissionList;
	}

}
