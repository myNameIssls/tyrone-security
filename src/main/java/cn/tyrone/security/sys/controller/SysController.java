package cn.tyrone.security.sys.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.tyrone.security.sys.bean.SecurityUser;

@Controller @RequestMapping("/sys")
public class SysController {
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(SecurityUser sysUser){
		
		String path = "home";
		
		String username = sysUser.getUsername();
		String password = sysUser.getPassword();
		
		AuthenticationToken token = new UsernamePasswordToken(username, password);
		
		Subject subject = SecurityUtils.getSubject();
		
		
		try {
			subject.login(token);
		} catch (UnknownAccountException uae){
			uae.printStackTrace();
		} catch (AuthenticationException e) {
			e.printStackTrace();
		}
		
		return path;
	}
	
}
