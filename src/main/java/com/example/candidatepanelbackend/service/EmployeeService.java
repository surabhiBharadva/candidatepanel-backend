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

public interface EmployeeService {

	Map<String, String> addEmployee(EmployeeModel data, MultipartFile[] files);

	Employee getByIdEmployee(Long employeeId);

	List<Employee> getEmployeeName();



}
