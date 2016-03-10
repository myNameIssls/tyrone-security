package cn.tyrone.security.sys.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

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

}
