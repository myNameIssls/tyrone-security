package cn.tyrone.security.shiro;

import java.util.List;

import javax.annotation.Resource;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

import cn.tyrone.security.sys.bean.SecurityPermission;
import cn.tyrone.security.sys.bean.SecurityUser;
import cn.tyrone.security.sys.service.ISecurityUserService;

/**
 * 自定义realm实现认证和授权
 * @author slsadmin
 *	
 */
public class SysAuthorizingRealm extends AuthorizingRealm {
	
	@Resource private ISecurityUserService securityUserService;
	
	/**
	 * 认证
	 * @author Tyrone
	 * @date 2016-03-09
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(
			AuthenticationToken token) throws AuthenticationException {
		
		String username = (String)token.getPrincipal();	// 获取身份信息，即用户名
		
		SimpleAuthenticationInfo simpleAuthenticationInfo = null;
		
		SecurityUser securityUser = securityUserService.getSysUserByUsername(username);
		if(securityUser != null){
			String securityUserId = securityUser.getUserId();
			String password = securityUser.getPassword();
			String salt = securityUser.getSalt();
			simpleAuthenticationInfo = new SimpleAuthenticationInfo(securityUser,password,ByteSource.Util.bytes(salt) ,this.getName());
		}
		
		return simpleAuthenticationInfo;
		
	}
	
	/**
	 * 授权
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(
			PrincipalCollection principals) {
		
		SecurityUser securityUser = (SecurityUser) principals.getPrimaryPrincipal();
		String securityUserId = securityUser.getUserId();
		
		SimpleAuthorizationInfo simpleAuthorizationInfo = getSimpleAuthorizationInfo(securityUserId);
		
		return simpleAuthorizationInfo;
	}
	
	private SimpleAuthorizationInfo getSimpleAuthorizationInfo(String securityUserId){
		SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
		
		SecurityUser securityUser = securityUserService.getSecurityPermissionById(securityUserId);
		if(securityUser != null){
			
			List<SecurityPermission> securityPermissionList = securityUser.getSecurityPermissionList();
			
			if(securityPermissionList != null && securityPermissionList.size() > 0){
				
				for(SecurityPermission permission : securityPermissionList){
					simpleAuthorizationInfo.addStringPermission(permission.getPermissionCode());
				}
				
			}
			
		}
		
		return simpleAuthorizationInfo;
		
	}
	
}
