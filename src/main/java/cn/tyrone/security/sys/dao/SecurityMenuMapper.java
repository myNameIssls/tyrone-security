package cn.tyrone.security.sys.dao;

import cn.tyrone.security.sys.bean.SecurityMenu;

public interface SecurityMenuMapper {
    int deleteByPrimaryKey(String id);

    int insert(SecurityMenu record);

    int insertSelective(SecurityMenu record);

    SecurityMenu selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(SecurityMenu record);

    int updateByPrimaryKey(SecurityMenu record);
}