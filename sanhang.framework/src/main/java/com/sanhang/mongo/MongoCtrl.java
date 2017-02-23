package com.sanhang.mongo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MongoCtrl {
	
	@Autowired
	MongoBean mongoBean;
	
	@RequestMapping("/mongo")
	public void mongo(){
		mongoBean.insert();
	}

}
