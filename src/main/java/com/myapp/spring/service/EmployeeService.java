package com.myapp.spring.service;

import java.util.List;

import com.myapp.spring.model.Employee;



public interface EmployeeService {
	
			int save(Employee employee);
			
			Employee get(int id);
			
			List<Employee> list();
			
			void update(int id,Employee employee);
			
			void delete(int id);
}
