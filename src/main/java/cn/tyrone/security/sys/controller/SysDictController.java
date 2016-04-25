package cn.tyrone.security.sys.controller;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.druid.support.json.JSONUtils;
import com.google.gson.JsonArray;

import cn.tyrone.security.core.bean.ResponseBean;
import cn.tyrone.security.core.util.JSONUtil;
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
	
	@RequestMapping("/saveDict")
	public String saveDict(SysDict sysDict){
		ResponseBean responseBean = null;
		try {
			sysDictService.saveDict(sysDict);
			responseBean = new ResponseBean("0", "操作成功");
		} catch (Exception e) {
			e.printStackTrace();
			responseBean = new ResponseBean("1", "操作失败");
		}
		return JSONUtil.getJson(responseBean);
	}
	
}
