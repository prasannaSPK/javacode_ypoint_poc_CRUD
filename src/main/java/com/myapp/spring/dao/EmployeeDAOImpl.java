package com.myapp.spring.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.myapp.spring.model.Employee;
import com.myapp.spring.model.EmployeeMapper;


@Component
public class EmployeeDAOImpl implements EmployeeDAO{
	
	
	JdbcTemplate jdbcTemplate;
	

	//our table name is employee it is in 'firstdb'  database
	private final String SQL_FIND = "select * from employee where id = ?";
	private final String SQL_DELETE = "delete from employee where id = ?";
	private final String SQL_UPDATE = "update employee set name = ?, age = ?, gender  = ?,salary = ?  where id = ?";
	private final String SQL_GET_ALL = "select * from employee";
	private final String SQL_INSERT = "insert into employee(id, name, age, gender,salary) values(?,?,?,?,?)";
	
	
	@Autowired
	public EmployeeDAOImpl(DataSource dataSource) {
			jdbcTemplate = new JdbcTemplate(dataSource);
		}
	
	
	@Override
	public int save(Employee employee) {
		// TODO Auto-generated method stub
		//return 0;
		
		jdbcTemplate.update(SQL_INSERT,employee.getId(),employee.getName(),employee.getAge(),employee.getGender(),employee.getSalary() );
		
		return employee.getId();
	}

	@Override
	public Employee get(int id) {
	
	
		return jdbcTemplate.queryForObject(SQL_FIND, new Object[] { id }, new EmployeeMapper());
		
	}

	@Override
	public List<Employee> list() {
		
		return jdbcTemplate.query(SQL_GET_ALL, new EmployeeMapper());
		
		
	}

	@Override
	public void update(int id, Employee employee) {
		
		 jdbcTemplate.update(SQL_UPDATE,employee.getName(), employee.getAge(),employee.getGender(),employee.getSalary(),
				 employee.getId());
		
		
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		 jdbcTemplate.update(SQL_DELETE, id);
		
	}

}
