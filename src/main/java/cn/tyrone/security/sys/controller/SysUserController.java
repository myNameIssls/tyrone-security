package cn.tyrone.security.sys.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller @RequestMapping("/sysuser")
public class SysUserController {
	@RequestMapping("/test")
	public void test(){
		System.out.println("test successful!!!!");
	}
}
