package com.example.candidatepanelbackend.Controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.candidatepanelbackend.Model.Candidate;
import com.example.candidatepanelbackend.Model.Employee;
import com.example.candidatepanelbackend.Service.EmployeeService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/")
public class EmployeeController{
	
	@Autowired
	private EmployeeService empoService;
	
	@Autowired
	ObjectMapper mapper;
	
	@PostMapping("/employee")
	private ResponseEntity<Employee> saveCandidate(@RequestParam("employee") String employee,@RequestParam("file") List<MultipartFile> file) throws JsonMappingException, JsonProcessingException {
		Employee employeeObj = mapper.readValue(employee, Employee.class);
		Employee employeeData =  null;
		 
		return new ResponseEntity<>(employeeData, HttpStatus.CREATED);
	}
	
	
	
	@GetMapping("/employee")
	private ResponseEntity<List<Employee>> getEmplyeeName(){
		
		List<Employee> list = empoService.getEmployeeName();
		return new ResponseEntity<>(list, HttpStatus.CREATED);
	}
	
	
}