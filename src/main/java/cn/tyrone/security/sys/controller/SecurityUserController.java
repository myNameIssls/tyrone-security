package cn.tyrone.security.sys.controller;

import java.util.List;

import javax.annotation.Resource;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.tyrone.security.sys.bean.SecurityUser;
import cn.tyrone.security.sys.service.ISecurityUserService;

@Controller @RequestMapping("/securityUser")
public class SecurityUserController {
	
	@Resource private ISecurityUserService securityUserService;
	
	@RequestMapping("/list")
	@RequiresPermissions(value = "securityUser:list")
	public String test(SecurityUser securityUser,Model model){
		List<SecurityUser> securityUsers = securityUserService.getDataList(securityUser);
		model.addAttribute("itemDataList", securityUsers);
		return "securityUser/list";
	}
	
}
