package com.sanhang.busi.school;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface StudentMapper {
	
	@Select("SELECT * FROM student")
	List<Student> findAll();
	
	@Select("SELECT * FROM student WHERE name = #{name}")
    Student findByName(@Param("name") String name);
	
	@Select("SELECT * FROM student WHERE name LIKE '%${name}%'")
    List<Student> findByKeyword(@Param("name") String name);

}
