package com.myapp.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.myapp.spring.model.Employee;
import com.myapp.spring.service.EmployeeService;



@CrossOrigin(origins = "*")// to connect to angular(localost:4200)
@RestController
public class EmployeeController {

	@Autowired// spring container itself creates object for this 
	private EmployeeService employeeService;
	
	//we need http get request
	/*get list of employees*/
	@GetMapping("/api/employee")
	public ResponseEntity<List<Employee>> list(){
				List<Employee>list=employeeService.list();
				
				return ResponseEntity.ok().body(list);
				
	}
	
	/*adding new employee*/
	@PostMapping("/api/employee")
   public ResponseEntity<?> save(@RequestBody Employee employee) {
	  System.out.println("the json value of employee is :::::: "+employee);
      int id = employeeService.save(employee);
      return ResponseEntity.ok().body("New employee has been saved with ID:" + id);
   }
	
	
	
	
	/*get only one entry*/
	
	@GetMapping("/api/employee/{id}")
	   public ResponseEntity<Employee> get(@PathVariable("id") String id) {
			int id1 = Integer.parseInt(id);
	      Employee employee = employeeService.get(id1);
	      return ResponseEntity.ok().body(employee);
	   }
	
	/* update  record*/
	
	 @PutMapping("/api/employee/{id}")
	   public ResponseEntity<?> update(@PathVariable("id") String id, @RequestBody Employee employee) {
		 int id1 = Integer.parseInt(id);
		 employeeService.update(id1, employee);
		 
	      return ResponseEntity.ok().body("Employee details has been updated successfully.");
	   }
	 
	 @DeleteMapping("/api/employee/{id}")
	   public ResponseEntity<?> delete(@PathVariable("id") String id) {
		 System.out.println("delete");
		 int id1 = Integer.parseInt(id);
		 employeeService.delete(id1);
	      return ResponseEntity.ok().body("Employee has been deleted successfully.");
	   }
	 
//	 ' url:'http://localhost:8080/crud_jdbc/api/employee''[our tomcat server url]
	 
}
