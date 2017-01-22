package com.sanhang.busi.school;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sanhang.support.DataTablesResult;
import com.sanhang.support.PageParameter;

@Service
public class StudentServiceImpl implements StudentService {
	
	@Autowired
	private StudentMapper mapper;

	@Override
	public List<Student> findAll() {
		return mapper.findAll();
	}
	
	@Override
	public DataTablesResult<Student> queryByPage(final StudentQuery studentQuery) {
		PageParameter pp = studentQuery.getPage();
		int draw = pp.getDraw();
		int start = pp.getStart();
		int pageSize = pp.getLength();
		int pageNo = start/pageSize + 1;
		String keyword = studentQuery.getKeyword();
	    PageHelper.startPage(pageNo, pageSize);
	    List<Student> list = mapper.findByKeyword(keyword);
	    //用PageInfo对结果进行包装
	    PageInfo<Student> page = new PageInfo<Student>(list);
	    DataTablesResult<Student> result = new DataTablesResult<Student>(draw,page);
	    return result;
	}

}
