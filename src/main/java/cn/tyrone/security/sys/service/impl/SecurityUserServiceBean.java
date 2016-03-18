package cn.tyrone.security.sys.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.tyrone.security.core.util.StringUtil;
import cn.tyrone.security.sys.bean.SecurityUser;
import cn.tyrone.security.sys.dao.SecurityUserMapper;
import cn.tyrone.security.sys.service.ISecurityUserService;

@Service
public class SecurityUserServiceBean implements ISecurityUserService {
	
	@Resource private SecurityUserMapper securityUserMapper;
	
	/**
	 * 根据用户名获取用户信息
	 * @author tyrone
	 * @date 2016-03-09
	 * @param principal
	 * @return 用户信息
	 */
	public SecurityUser getSysUserByUsername(String username) {
		if(username != null && !"".equals(username)){
			SecurityUser securityUser = securityUserMapper.getSysUserByUsername(username);
			return securityUser;
		}
		return null;
	}

	public List<SecurityUser> getDataList(SecurityUser securityUser) {
		
		return securityUserMapper.getDataList(securityUser);
	}

	/**
	 * 根据用户ID获取用户所有角色
	 * @author Tyrone.Shang
	 * @date 2016-03-18
	 * @param securityUserId
	 * @return
	 */
	public SecurityUser getSecurityRoleById(String securityUserId) {
		if(StringUtil.isNotEmpty(securityUserId)){
			return securityUserMapper.getSecurityRoleById(securityUserId);
		}
		return null;
	}
	
	/**
	 * 根据用户ID获取用户所有权限
	 * @author Tyrone.Shang
	 * @date 2016-03-18
	 * @param securityUserId
	 * @return
	 */
	public SecurityUser getSecurityPermissionById(String securityUserId) {
		if(StringUtil.isNotEmpty(securityUserId)){
			return securityUserMapper.getSecurityPermissionById(securityUserId);
		}
		return null;
	}

}
