package cn.tyrone.security.sys.bean;

public class SecurityRole {
	
	/**
	 * 角色编号
	 */
    private String id;

    /**
     * 角色名称
     */
    private String roleName;

    /**
     * 角色编码
     */
    private String roleCode;

    /**
     * 角色组
     */
    private String roleGroup;

    /**
     * 是否可用
     * 【0:可用 1:不可用】
     */
    private String available;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }

    public String getRoleGroup() {
        return roleGroup;
    }

    public void setRoleGroup(String roleGroup) {
        this.roleGroup = roleGroup;
    }

    public String getAvailable() {
        return available;
    }

    public void setAvailable(String available) {
        this.available = available;
    }
}