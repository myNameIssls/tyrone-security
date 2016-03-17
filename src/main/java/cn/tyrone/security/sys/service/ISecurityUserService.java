package cn.tyrone.security.sys.service;

import java.util.List;

import cn.tyrone.security.sys.bean.SecurityUser;

public interface ISecurityUserService {
	
	/**
	 * 根据用户名获取用户信息
	 * @author tyrone
	 * @date 2016-03-09
	 * @param principal
	 * @return 用户信息
	 */
	SecurityUser getSysUserByUsername(String username);

	List<SecurityUser> getDataList(SecurityUser securityUser);

}
