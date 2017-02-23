package com.sanhang.mongo;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

@Component
public class MongoBean {
	
	@Autowired
	MongoTemplate mongoTemplate;
	
	public void insert(){
		Map<String,String> map = new HashMap<String,String>();
		map.put("tom", "123");
		mongoTemplate.insert(map);
	}

}
