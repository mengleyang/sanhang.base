package com.sanhang.busi.school;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.sanhang.support.DataTablesResult;

@Controller
@RequestMapping("/stu")
@SessionAttributes(StudentCtrl.SESSION_ATTR_QUERY)
public class StudentCtrl {
	
	public static final String SESSION_ATTR_QUERY = "student_query";
	
	@Autowired
	StudentService studentService;
	
	@RequestMapping("/findAll")
	@ResponseBody
	public List<Student> findAll(){
		return studentService.findAll();
	}
	
	@RequestMapping("/list")
	public String list(Model model, HttpSession session){
		StudentQuery query = (StudentQuery) session.getAttribute(SESSION_ATTR_QUERY);
		if (null == query) {
			query = new StudentQuery();
			model.addAttribute(SESSION_ATTR_QUERY, query);
		}
		return "student/list";
	}
	
	@RequestMapping("/page")
	@ResponseBody
	public DataTablesResult<Student> page(@ModelAttribute(SESSION_ATTR_QUERY) StudentQuery query){
		return studentService.queryByPage(query);
	}

}
