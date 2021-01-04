package com.myapp.spring.service;

import java.util.List;


import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.myapp.spring.dao.EmployeeDAO;
import com.myapp.spring.model.Employee;




@Service //since it is a service
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	EmployeeDAO employeeDAO;
	
	
	
	@Override
	@Transactional//letus replace with javax if this didn't work out 
	public int save(Employee employee) {
		// TODO Auto-generated method stub
		//return 0;
		
		return employeeDAO.save(employee);
	}

	@Override
	@Transactional
	public Employee get(int id) {
		// TODO Auto-generated method stub
		return employeeDAO.get(id);
	}

	@Override
	@Transactional
	public List<Employee> list() {
		// TODO Auto-generated method stub
		return employeeDAO.list();
	}

	@Transactional
	@Override
	public void update(int id, Employee employee) {
		// TODO Auto-generated method stub
		employeeDAO.update(id, employee);
		
	}

	@Transactional
	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		employeeDAO.delete(id);
	}

	
	
}
