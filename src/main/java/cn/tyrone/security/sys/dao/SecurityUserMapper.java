package cn.tyrone.security.sys.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.tyrone.security.sys.bean.SecurityUser;

public interface SecurityUserMapper {
    int deleteByPrimaryKey(String userId);

    int insert(SecurityUser record);

    int insertSelective(SecurityUser record);

    SecurityUser selectByPrimaryKey(String userId);

    int updateByPrimaryKeySelective(SecurityUser record);

    int updateByPrimaryKey(SecurityUser record);

    /**
     * 根据用户名获取用户信息
     * @author Tyrone.Shang
     * @date 2016-03-18
     * @param username 
     * @return
     */
	SecurityUser getSysUserByUsername(@Param(value = "username") String username);

	List<SecurityUser> getDataList(SecurityUser securityUser);

	/**
	 * 根据用户ID获取用户所有角色
	 * @author Tyrone.Shang
	 * @date 2016-03-18
	 * @param securityUserId
	 * @return
	 */
	SecurityUser getSecurityRoleById(String securityUserId);

	/**
	 * 根据用户ID获取用户所有权限
	 * @author Tyrone.Shang
	 * @date 2016-03-18
	 * @param securityUserId
	 * @return
	 */
	SecurityUser getSecurityPermissionById(String securityUserId);
}