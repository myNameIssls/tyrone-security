package cn.tyrone.security.sys.dao;

import cn.tyrone.security.sys.bean.SecurityPermission;

public interface SecurityPermissionMapper {
    int deleteByPrimaryKey(String id);

    int insert(SecurityPermission record);

    int insertSelective(SecurityPermission record);

    SecurityPermission selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(SecurityPermission record);

    int updateByPrimaryKey(SecurityPermission record);
}