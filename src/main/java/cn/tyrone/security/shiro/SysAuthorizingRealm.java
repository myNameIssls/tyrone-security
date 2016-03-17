package cn.tyrone.security.shiro;

import java.util.ArrayList;
import java.util.List;

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
		String salt = "1";
		if(sysUser != null){
			if(credentials.equals(sysUser.getPassword())){
				simpleAuthenticationInfo = new SimpleAuthenticationInfo(sysUser,credentials,ByteSource.Util.bytes(salt) ,this.getName());
			}
		}
		
		return simpleAuthenticationInfo;
		
	}
	
	/**
	 * 授权
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(
			PrincipalCollection principals) {
		SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
		
//		SecurityUser securityUser = (SecurityUser) principals.getPrimaryPrincipal();
		
		SecurityPermission sp = new SecurityPermission();
		sp.setId("123456");
		sp.setPermissionName("用户列表查询");
		sp.setPermissionCode("securityuser:list");
		
		List<SecurityPermission> securityPermissionList = new ArrayList<SecurityPermission>();
		
		securityPermissionList.add(sp);
		
		for(SecurityPermission securityPermission : securityPermissionList){
			simpleAuthorizationInfo.addStringPermission(securityPermission.getPermissionCode());
		}
		
		
		return simpleAuthorizationInfo;
	}

}
