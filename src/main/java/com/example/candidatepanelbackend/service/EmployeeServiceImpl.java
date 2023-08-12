package com.example.candidatepanelbackend.service;

import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.candidatepanelbackend.constants.Constants;
import com.example.candidatepanelbackend.entity.Employee;
import com.example.candidatepanelbackend.repo.EmployeeRepo;
import com.example.candidatepanelbackend.responseModels.EmployeeModel;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	private EmployeeRepo employeeRepository;
	
	@Autowired
	private DocumentService documentsService;

	public Map<String, String> addEmployee(EmployeeModel employeeRequest, MultipartFile[] files) {
		Employee e = new Employee();

		e.setFirstName(employeeRequest.getFirstName());
		e.setLastName(employeeRequest.getLastName());
		e.setEmail(employeeRequest.getEmail());
		e.setDateofBirth(employeeRequest.getDateofBirth());
		e.setPhoneNo(employeeRequest.getPhoneNo());
		e.setAadharCardNumber(employeeRequest.getAadharCardNumber());
				
		e.setOrganizationDetails(employeeRequest.addOrganizationDetails(employeeRequest, e));
		
//		Arrays.asList(employeeRequest.addEducationDetails(employeeRequest ,e)).stream().forEach(eachEducation ->{
//			e.setEducationDetails(employeeRequest.getEducationDetails());
//		});
//		
//		Arrays.asList(employeeRequest.addWorkExperienceDetails(employeeRequest, e)).stream().forEach(eachExperience ->{
//			e.setWorkExperienceDetails(employeeRequest.getWorkExperienceDetails());
//		});
				
//		Arrays.asList(employeeRequest.addAddressDetails(employeeRequest, e)).stream().forEach(eachAddress ->{
//			e.setAddress(employeeRequest.getAddress());
//		});
		
		e.setEducationDetails(employeeRequest.addEducationDetails(employeeRequest, e));
		e.setWorkExperienceDetails(employeeRequest.addWorkExperienceDetails(employeeRequest, e));
		e.setAddress(employeeRequest.addAddressDetails(employeeRequest, e));
		
		e.setCreatedBy(Constants.Admin);	//*
		e.setCreatedDate(new Date()); 		
		e.setModifiedBy(Constants.Admin);  //*
		e.setModifiedDate(new Date());
		e.setDeleteFlag(null);

		Map<String, String> response = new HashMap<>();

//		if (employee.getAadharCardNumber() != null) {
			Optional<Employee> cardNo = employeeRepository.findByAadharCardNumber(employeeRequest.getAadharCardNumber());
			if (!cardNo.isPresent()) {
				Employee save = employeeRepository.save(e);

				Arrays.asList(files).stream().forEach(each -> {
					if (files != null) {
						
//						documentsService.saveDocument(each, save);
					}
				});

				response.put("response", "Employee is Registered..");
			} else {
				response.put("response", "Aadhar Card is Already Registered...");
			}
//		} else {
//			response.put("response", "Aadhar is null");
//		}

//		Employee em = new Employee(e);
//		em.setId(e.getId());
		
		return response;
	}

	
	public List<Employee> getEmployeeName() {
		List<Employee> list = employeeRepository.findAll();
		return list;
	}

	public Employee getByIdEmployee(Long id) {
		Employee employee = employeeRepository.findById(id).get();
		return employee;
	}

//	public Employee updateCandidate(Long id, Employee employee) {
//		Employee employeeSet = employeeRepo.findById(id).get();
//
//		employeeSet.setDob(employee.getDob());
//		employeeSet.setEmail(employee.getEmail());
//		employeeSet.setFirstName(employee.getFirstName());
//		employeeSet.setLastName(employee.getLastName());
//		employeeSet.setStatus(employee.getStatus());
//		employeeSet.setModifiedDate(new Date());
//		employeeSet.setAddress(employee.getAddress());
//		final Employee updatedEmployee = employeeRepo.save(employeeSet);
//		return updatedEmployee;
//
//	}
}
