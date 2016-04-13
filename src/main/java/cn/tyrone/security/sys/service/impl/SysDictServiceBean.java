package cn.tyrone.security.sys.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.tyrone.security.sys.bean.SysDict;
import cn.tyrone.security.sys.dao.SysDictMapper;
import cn.tyrone.security.sys.service.ISysDictService;

@Service
public class SysDictServiceBean implements ISysDictService {

	@Resource private SysDictMapper sysDictMapper;
	
	public List<SysDict> getDictList(SysDict sysDict) {
		List<SysDict> dictList = sysDictMapper.getDictList(sysDict);
		return dictList;
	}
	
}
