package cn.tyrone.security.sys.service;

import cn.tyrone.security.sys.bean.SysUser;

public interface ISysUserService {
	
	/**
	 * 根据用户名获取用户信息
	 * @author tyrone
	 * @date 2016-03-09
	 * @param principal
	 * @return 用户信息
	 */
	SysUser getSysUserByUsername(String username);

}
