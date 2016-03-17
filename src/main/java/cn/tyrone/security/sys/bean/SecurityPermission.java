package cn.tyrone.security.sys.bean;

import java.io.Serializable;

public class SecurityPermission implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1919465424381281494L;

	private String id;
	
	private String permissionName;
	
	private String permissionCode;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPermissionName() {
		return permissionName;
	}

	public void setPermissionName(String permissionName) {
		this.permissionName = permissionName;
	}

	public String getPermissionCode() {
		return permissionCode;
	}

	public void setPermissionCode(String permissionCode) {
		this.permissionCode = permissionCode;
	}
	
}
