package com.sanhang.busi.school.auth;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {
	
	@Select("SELECT * FROM t_user WHERE username = #{name}")
    User findByName(@Param("name") String name);
	
	/** 查询用户及角色信息 */
    public User selectUserRole(@Param("name") String name);
	
}
