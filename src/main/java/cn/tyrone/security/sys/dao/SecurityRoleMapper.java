package cn.tyrone.security.sys.dao;

import cn.tyrone.security.sys.bean.SecurityRole;

public interface SecurityRoleMapper {
    int deleteByPrimaryKey(String id);

    int insert(SecurityRole record);

    int insertSelective(SecurityRole record);

    SecurityRole selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(SecurityRole record);

    int updateByPrimaryKey(SecurityRole record);
}