package cn.tyrone.security.sys.controller;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.tyrone.security.sys.bean.SecurityUser;
import cn.tyrone.security.sys.service.ISecurityUserService;

@Controller @RequestMapping("/securityUser")
public class SecurityUserController {
	
	@Resource private ISecurityUserService securityUserService;
	
	@RequestMapping("/list")
	@RequiresPermissions(value = "securityUser:list")
	public String test(HttpServletRequest request){
		System.out.println("************************************");
		return "securityUser/list";
	}
	
	@ResponseBody
	@RequestMapping(value = "/getDataList",method = {RequestMethod.POST})
	@RequiresPermissions(value = "securityUser:list")
	public String getDataList(SecurityUser securityUser,HttpServletResponse response) throws IOException{
		
		List<SecurityUser> securityUserList = securityUserService.getDataList(securityUser);
		
		
		System.out.println("-----------------------");
		
		String json = "{\"total\":28,\"rows\":[{\"time\":\"2016-01-02\",\"type\":\"收入\",\"account-type\":\"工资\",\"money\":\"5000\",\"remark\":\"我的工资\"}]}";
		
		System.out.println(json);
		return json;
	}
	
}
