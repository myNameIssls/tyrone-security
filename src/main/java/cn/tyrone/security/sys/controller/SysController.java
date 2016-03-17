package cn.tyrone.security.sys.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SysController {
	
	@RequestMapping(value = "/login")
	public String login(HttpServletRequest request) throws Exception{
		System.out.println("**********************8");
		//如果登陆失败从request中获取认证异常信息，shiroLoginFailure就是shiro异常类的全限定名
		String exceptionClassName = (String) request.getAttribute("shiroLoginFailure");
		
		//根据shiro返回的异常类路径判断，抛出指定异常信息
		if(exceptionClassName!=null){
			if (UnknownAccountException.class.getName().equals(exceptionClassName)) {
				//最终会抛给异常处理器
				throw new RuntimeException("账号不存在");
			} else if (IncorrectCredentialsException.class.getName().equals(
					exceptionClassName)) {
				throw new RuntimeException("用户名/密码错误");
			} else if("randomCodeError".equals(exceptionClassName)){
				throw new RuntimeException("验证码错误 ");
			}else {
				throw new Exception();//最终在异常处理器生成未知错误
			}
		}
		//此方法不处理登陆成功（认证成功），shiro认证成功会自动跳转到上一个请求路径
		//登陆失败还到login页面
		
		return "index";
	}
	
	
//	@RequestMapping(value = "/login", method = RequestMethod.POST)
//	public String login(SecurityUser sysUser){
//		
//		String path = "home";
//		
//		String username = sysUser.getUsername();
//		String password = sysUser.getPassword();
//		
//		AuthenticationToken token = new UsernamePasswordToken(username, password);
//		
//		Subject subject = SecurityUtils.getSubject();
//		
//		
//		try {
//			subject.login(token);
//			Session session = subject.getSession();
//			Object principal = subject.getPrincipal();
//			System.out.println(principal);
//		} catch (UnknownAccountException uae){
//			uae.printStackTrace();
//		} catch (AuthenticationException e) {
//			e.printStackTrace();
//		}
//		
//		return path;
//	}
	
}
