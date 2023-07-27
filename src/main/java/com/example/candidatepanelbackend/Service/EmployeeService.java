package com.example.candidatepanelbackend.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.candidatepanelbackend.Model.Candidate;
import com.example.candidatepanelbackend.Model.Employee;
import com.example.candidatepanelbackend.Model.Interview;
import com.example.candidatepanelbackend.Repo.EmployeeRepo;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeRepo employeeRepo;

	public Employee addEmployee(Employee employee, MultipartFile file) {
		
		return employeeRepo.save(employee);
	}

	public List<Employee> getEmployeeName() {
		List<Employee> list  = employeeRepo.findAll();
		return list;
	}
	
	public Employee getByIdEmployee(Long id) {
		Employee employee = employeeRepo.findById(id).get();
		return employee;
	}

	public Employee updateCandidate(Long id, Employee employee) {
		Employee employeeSet = employeeRepo.findById(id).get();
		employeeSet.setAcardNum(employee.getAcardNum());
		employeeSet.setCity(employee.getCity());
		employeeSet.setCountry(employee.getCountry());
		employeeSet.setDob(employee.getDob());
		employeeSet.setEmail(employee.getEmail());
		employeeSet.setFirstName(employee.getFirstName());
		employeeSet.setLname(employee.getLname());
		employeeSet.setPancard(employee.getPancard());
		employeeSet.setState(employee.getState());
		employeeSet.setStatus(employee.getStatus());
		final Employee updatedEmployee = employeeRepo.save(employeeSet);
		return updatedEmployee;
		
	}
	
}
