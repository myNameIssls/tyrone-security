package cn.tyrone.security.sys.bean;

import java.io.Serializable;

public class SecurityPermission implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1478678722067403599L;

	private String id;

	private String permissionName;

	private String permissionCode;

	private String available;

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

	public String getAvailable() {
		return available;
	}

	public void setAvailable(String available) {
		this.available = available;
	}

}
