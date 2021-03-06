package cn.tyrone.security.sys.dao;

import java.util.List;

import cn.tyrone.security.sys.bean.SysDict;

public interface SysDictMapper {
    int deleteByPrimaryKey(String id);

    int insert(SysDict record);

    int insertSelective(SysDict record);

    SysDict selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(SysDict record);

    int updateByPrimaryKey(SysDict record);

	List<SysDict> getDictList(SysDict sysDict);

	/**
	 * 获取字典码
	 * @author Tyrone.Shang
	 * @date 2016-04-15
	 * @param sysDict
	 * @return
	 */
	List<String> getDictKeys(SysDict sysDict);
}