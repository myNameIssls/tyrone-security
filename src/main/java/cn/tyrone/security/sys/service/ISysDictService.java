package cn.tyrone.security.sys.service;

import java.util.List;

import cn.tyrone.security.sys.bean.SysDict;

public interface ISysDictService {

	List<SysDict> getDictList(SysDict sysDict);

	void saveDict(SysDict sysDict);
	
}
