package com.techprimers.springbatchexample1.batch;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import com.techprimers.springbatchexample1.model.User;

@Component
public class processor implements ItemProcessor<User, User>{

	private static final Map<String, String> deptName = new HashMap<>();
	
	public processor() {
	
		deptName.put("001", "technologies");
		deptName.put("002", "Accounting");
		deptName.put("003", "Finance");
	}
	
	@Override
	public User process(User user) throws Exception {
		String deptCode = user.getDept();
		String dept = deptName.get(deptCode);
		user.setDept(dept);
		user.setTime(new Date());
		System.out.println("converted dept to depcode : " + dept);
		return user;
	}

	
}
