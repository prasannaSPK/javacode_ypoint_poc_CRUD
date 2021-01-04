package com.myapp.spring.dao;

import java.util.List;

import com.myapp.spring.model.Employee;



public interface EmployeeDAO {
		
	int save(Employee employee);
	
	Employee get(int id);
	
	List<Employee> list();
	
	void update(int id,Employee employee);
	
	void delete(int id);
	
}
