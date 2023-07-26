package com.example.candidatepanelbackend.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.candidatepanelbackend.Model.Employee;
import com.example.candidatepanelbackend.Model.Interview;
import com.example.candidatepanelbackend.Repo.EmployeeRepo;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeRepo employeeRepo;

	public Employee addInterview(Employee employee, MultipartFile file) {
		
		return employeeRepo.save(employee);
	}

	public List<Employee> getEmployeeName() {
		List<Employee> list  = employeeRepo.findAll();
		return list;
	}
	
	
	
}
