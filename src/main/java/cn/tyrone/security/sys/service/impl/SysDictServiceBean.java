package cn.tyrone.security.sys.service.impl;

import java.util.Arrays;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import cn.tyrone.security.core.bean.SysConstant;
import cn.tyrone.security.core.util.StringUtil;
import cn.tyrone.security.sys.bean.SysDict;
import cn.tyrone.security.sys.dao.SysDictMapper;
import cn.tyrone.security.sys.service.ISysDictService;

@Service
public class SysDictServiceBean implements ISysDictService {

	Logger logger = Logger.getLogger(this.getClass());
	
	@Resource private SysDictMapper sysDictMapper;
	
	public List<SysDict> getDictList(SysDict sysDict) {
		List<SysDict> dictList = sysDictMapper.getDictList(sysDict);
		return dictList;
	}

	public void saveDict(SysDict sysDict) {
		
		String dictType = sysDict.getDictType();
		
		List<String> dictKeys = sysDictMapper.getDictKeys(sysDict);
		
		if(StringUtil.isNotEmpty(dictType,SysConstant.ZERO)){
			/*
			 * dictType = 0 表明添加的是字典组
			 * 1. 从数据库里查询出所以字典组的字典码集合
			 * 2. 随机生成一个不在此集合的的码
			 */
			String randomCode = StringUtil.getRandomCode(dictKeys, 3);
			sysDict.setDictKey(randomCode);
			
		}else{
			/*
			 * dictType = 1 表明添加的是字典类型
			 * 1. 获取字典组key
			 * 2. 根据字典组key从数据库里查询出该组下的所在字典码
			 * 3. 随机生成一个不在此集合的的码
			 */
			String dictGroupKey = sysDict.getDictGroupKey(); // 获取字典组key
			String randomCode = StringUtil.getRandomCode(dictKeys, dictGroupKey, 3);
			sysDict.setDictKey(randomCode);
		}
		
		sysDict.setId(StringUtil.getUUID());
		
		sysDictMapper.insertSelective(sysDict);
		
	}
	
}
