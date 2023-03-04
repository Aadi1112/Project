package com.EmployeeManagementSystem.controler;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.EmployeeManagementSystem.dao.EmployeeDao;
import com.EmployeeManagementSystem.model.Employee;
import com.EmployeeManagementSystem.serviceImpl.EmployeeServiceImpl;

@RestController
@RequestMapping("/emp")
public class Controler {

	@Autowired
	private EmployeeServiceImpl service;
	
	@PostMapping("/add")
	public ResponseEntity<String>addEmployee(@RequestBody Employee ee){
		
		service.addEmployee(ee);
		
		return new ResponseEntity<String>("Employee added success",HttpStatus.CREATED);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String>delete(@PathVariable int id){
		
		service.deleteEmployee(id);
		
		return new ResponseEntity<String>("Delete Success", HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/find/{id}")
	public ResponseEntity<Optional<Employee>>findById(@PathVariable int id){
		
		Optional<Employee> emp=service.findEmpById(id);
		
		return new ResponseEntity<Optional<Employee>>(emp,HttpStatus.OK);
		
	}
	
	@GetMapping("all")
	public  ResponseEntity<List<Employee>> list(){
		
		List<Employee>list=service.getAllEmployee();
		
		return new ResponseEntity<List<Employee>>(list,HttpStatus.ACCEPTED);
	}
	
	
	
}
