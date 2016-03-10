package cn.tyrone.security.shiro;

import javax.annotation.Resource;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import cn.tyrone.security.sys.bean.SecurityUser;
import cn.tyrone.security.sys.service.ISecurityUserService;

/**
 * 自定义realm实现认证和授权
 * @author slsadmin
 *	
 */
public class SysAuthorizingRealm extends AuthorizingRealm {
	
	@Resource private ISecurityUserService sysUserService;
	
	/**
	 * 认证
	 * @author Tyrone
	 * @date 2016-03-09
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(
			AuthenticationToken token) throws AuthenticationException {
		UsernamePasswordToken UsernamePasswordToken = (UsernamePasswordToken)token;
		String principal = UsernamePasswordToken.getUsername();	// 获取身份信息，即用户名
		String credentials = new String(UsernamePasswordToken.getPassword()); // 获取凭证信息，即密码
		
		SimpleAuthenticationInfo simpleAuthenticationInfo = null;
		
		SecurityUser sysUser = sysUserService.getSysUserByUsername(principal);
		
		if(sysUser != null){
			if(credentials.equals(sysUser.getPassword())){
				simpleAuthenticationInfo = new SimpleAuthenticationInfo(sysUser,credentials,this.getName());
			}
		}
		
		return simpleAuthenticationInfo;
		
	}
	
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(
			PrincipalCollection principals) {
		
		SimpleAuthorizationInfo simpAuthorizationInfo = new SimpleAuthorizationInfo();
		
		simpAuthorizationInfo.addStringPermission("securityuser:list");
		return simpAuthorizationInfo;
	}

}
