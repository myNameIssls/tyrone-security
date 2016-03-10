package cn.tyrone.security.sys.dao;

import org.apache.ibatis.annotations.Param;

import cn.tyrone.security.sys.bean.SecurityUser;

public interface SecurityUserMapper {
    int deleteByPrimaryKey(String userId);

    int insert(SecurityUser record);

    int insertSelective(SecurityUser record);

    SecurityUser selectByPrimaryKey(String userId);

    int updateByPrimaryKeySelective(SecurityUser record);

    int updateByPrimaryKey(SecurityUser record);

	SecurityUser getSysUserByUsername(@Param(value = "username") String username);
}