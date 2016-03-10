package cn.tyrone.security.sys.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller @RequestMapping("/sysuser")
public class SecurityUserController {
	@RequestMapping("/test")
	public void test(HttpServletRequest request){
//		System.out.println("test successful!!!!");
//		String username = request.getParameter("username");
//		String password = request.getParameter("pwd");
//		
//		Subject subject = SecurityUtils.getSubject();
//		UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(username, password);
//		
//		subject.login(usernamePasswordToken);
		
		
	}
}
