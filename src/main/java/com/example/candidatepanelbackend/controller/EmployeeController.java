package com.example.candidatepanelbackend.controller;

import java.util.List;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.candidatepanelbackend.entity.Employee;
import com.example.candidatepanelbackend.responseModels.EmployeeModel;
import com.example.candidatepanelbackend.service.EmployeeService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("api/v1/employee")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@Autowired
	ObjectMapper mapper;

	Map<String, String> map;

	@PostMapping("/save")
	public ResponseEntity<Object> saveEmployee(@RequestParam("files") MultipartFile[] files,
			@RequestParam("employee") String model) {

//		EmployeeModel data = new EmployeeModel();
//		Map<String, String> employee = null;

		try {
			EmployeeModel data = mapper.readValue(model, EmployeeModel.class);
			map = employeeService.addEmployee(data, files);

		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}

		return ResponseEntity.status(HttpStatus.CREATED).body(map);
	}

	@GetMapping("/getAll")
	private ResponseEntity<List<Employee>> getEmplyeeName() {

		List<Employee> list = employeeService.getEmployeeName();
		return new ResponseEntity<>(list, HttpStatus.CREATED);
	}

	@GetMapping("/getById/{id}")
	private ResponseEntity<Employee> getByIdEmployee(@PathVariable Long id) {
		Employee employeeObj = employeeService.getByIdEmployee(id);
		return new ResponseEntity<>(employeeObj, HttpStatus.CREATED);
	}

//	@PutMapping("/employee/{id}")
//	private ResponseEntity<Employee> updateCandidate(@PathVariable Long id,@RequestBody Employee employee){
//		Employee employeeUpdate = empoService.updateCandidate(id ,employee);
//		return new ResponseEntity<>(employeeUpdate, HttpStatus.CREATED);
//	}

}