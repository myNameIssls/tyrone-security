package cn.tyrone.security.sys.controller;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.tyrone.security.sys.bean.SysDict;
import cn.tyrone.security.sys.service.ISysDictService;

/**
 * 数据字典
 * @author Tyrone.Shang
 *
 */
@Controller @RequestMapping("/sysDict")
public class SysDictController {
	
	Logger logger = Logger.getLogger(this.getClass());
	
	@Resource private ISysDictService sysDictService;
	
	@RequestMapping("/dictList")
	public String dictList(SysDict sysDict,Model model){
		List<SysDict> dictList = sysDictService.getDictList(sysDict);
		model.addAttribute("itemDataList", dictList);
		return "sysDict/dictList";
	}
	
}
