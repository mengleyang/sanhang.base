package com.sanhang.busi.school;

import java.util.List;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sanhang.support.DataTablesResult;
import com.sanhang.support.PageParameter;

@Service
public class StudentServiceImpl implements StudentService {
	
	@Autowired
	private StudentMapper mapper;
	
	@Autowired
	private MongoTemplate mongoTemplate;
	
	@Autowired
	private JmsTemplate jmsTemplate;

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
	
	@Override
	public void insertToMongo(){
		Student student = new Student();
		student.setId(1);
		student.setName("tom");
		mongoTemplate.insert(student);
		//Student student = mongoTemplate.findById(1, Student.class);
		//System.out.println(student.getName());
		//Object obj = JSON.parse("{x:30}");
	}
	
	@Override
	public void jms(){
		jmsTemplate.send(new MessageCreator() {
			@Override
			public Message createMessage(Session session) throws JMSException {
				return session.createTextMessage("Hello");
			}

		});
	}

}
