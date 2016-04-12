package cn.tyrone.security.sys.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SysController {
	
	@RequestMapping(value = "/login")
	public String login(HttpServletRequest request) throws Exception{
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
	
	@ResponseBody
	@RequestMapping("/getJson")
	public String getJson(){
		String json = "[{\"id\":\"1\",\"text\":\"系统管理\",\"children\":[{\"id\":\"11\",\"text\":\"用户管理\"},{\"id\":\"12\",\"text\":\"角色管理\"},{\"id\":\"13\",\"text\":\"权限管理\"},{\"id\":\"14\",\"text\":\"菜单管理\"},{\"id\":\"15\",\"text\":\"数据字典维护\"}]}]";
		return json;
	}
	
}
