package com.sanhang.busi.school;

import java.util.List;

import com.sanhang.support.DataTablesResult;

public interface StudentService {
	
	List<Student> findAll();
	
	DataTablesResult<Student> queryByPage(StudentQuery studentQuery);
	
	void insertToMongo();
	
	void jms();

}
