package com.example.candidatepanelbackend.responseModels;

import java.util.ArrayList;


import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Transient;

import com.example.candidatepanelbackend.constants.Constants;
import com.example.candidatepanelbackend.entity.Address;
import com.example.candidatepanelbackend.entity.DocumentDetails;
import com.example.candidatepanelbackend.entity.EducationDetails;
import com.example.candidatepanelbackend.entity.Employee;
import com.example.candidatepanelbackend.entity.OrganizationDetails;
import com.example.candidatepanelbackend.entity.WorkExperienceDetails;

@Component
public class EmployeeModel {

	private String firstName;
	private String lastName;
	private String email;
	private Long phoneNo;
	private Long aadharCardNumber;
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date dateofBirth;

//	private String employeeStatus;

	@Transient
	private String documentType;

	private OrganizationDetails organizationDetails;

	private List<EducationDetails> educationDetails;

	private List<WorkExperienceDetails> workExperienceDetails;

	private List<Address> address;

	private List<DocumentDetails> employeeDocuments;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(Long phoneNo) {
		this.phoneNo = phoneNo;
	}

	public Long getAadharCardNumber() {
		return aadharCardNumber;
	}

	public void setAadharCardNumber(Long aadharCardNumber) {
		this.aadharCardNumber = aadharCardNumber;
	}

	public Date getDateofBirth() {
		return dateofBirth;
	}

	public void setDateofBirth(Date dateofBirth) {
		this.dateofBirth = dateofBirth;
	}

	public String getDocumentType() {
		return documentType;
	}

	public void setDocumentType(String documentType) {
		this.documentType = documentType;
	}

	public OrganizationDetails getOrganizationDetails() {
		return organizationDetails;
	}

	public void setOrganizationDetails(OrganizationDetails organizationDetails) {
		this.organizationDetails = organizationDetails;
	}

	public List<EducationDetails> getEducationDetails() {
		return educationDetails;
	}

	public void setEducationDetails(List<EducationDetails> educationDetails) {
		this.educationDetails = educationDetails;
	}

	public List<WorkExperienceDetails> getWorkExperienceDetails() {
		return workExperienceDetails;
	}

	public void setWorkExperienceDetails(List<WorkExperienceDetails> workExperienceDetails) {
		this.workExperienceDetails = workExperienceDetails;
	}

	public List<Address> getAddress() {
		return address;
	}

	public void setAddress(List<Address> address) {
		this.address = address;
	}

	public List<DocumentDetails> getEmployeeDocuments() {
		return employeeDocuments;
	}

	public void setEmployeeDocuments(List<DocumentDetails> employeeDocuments) {
		this.employeeDocuments = employeeDocuments;
	}

	public OrganizationDetails addOrganizationDetails(EmployeeModel employeeRequest, Employee e) {
		OrganizationDetails org = new OrganizationDetails();
		
		org.setDesignation(employeeRequest.getOrganizationDetails().getDesignation());
		org.setRole(employeeRequest.getOrganizationDetails().getRole());
		org.setJoiningDate(employeeRequest.getOrganizationDetails().getJoiningDate());
		org.setJoiningStatus(employeeRequest.getOrganizationDetails().getJoiningStatus());
		org.setCompanyEmail(employeeRequest.getOrganizationDetails().getCompanyEmail());
		org.setCompanyUserLogin(employeeRequest.getOrganizationDetails().getCompanyUserLogin());
		org.setReportingTo(employeeRequest.getOrganizationDetails().getReportingTo());

		org.setEmployee(e);
		org.setCreatedBy(Constants.Admin);
		org.setCreatedDate(new Date());
		org.setModifiedBy(Constants.Admin);
		org.setModifiedDate(new Date());
		org.setDeleteFlag(null);

		return org;
	}

	public List<EducationDetails> addEducationDetails(EmployeeModel employeeRequest, Employee emp) {
		List<EducationDetails> lists = new ArrayList<>();

		for (EducationDetails educ : employeeRequest.getEducationDetails()) {
			EducationDetails edu = new EducationDetails();
			
			edu.setUniversityName(educ.getUniversityName());
			edu.setCourseName(educ.getCourseName());
			edu.setBranch(educ.getBranch());
			edu.setCGPAOrPercentage(educ.getCGPAOrPercentage());
			edu.setPassingYear(educ.getPassingYear());

			edu.setEmpId(emp);
			edu.setCreatedBy(Constants.Admin);
			edu.setCreatedDate(new Date());
			edu.setModifiedBy(Constants.Admin);
			edu.setModifiedDate(new Date());
			edu.setDeleteFlag(null);

			lists.add(edu);
		}

		return lists;
	}

	public List<WorkExperienceDetails> addWorkExperienceDetails(EmployeeModel employeeRequest, Employee emp) {
		List<WorkExperienceDetails> lists = new ArrayList<>();

		for (WorkExperienceDetails expd : employeeRequest.getWorkExperienceDetails()) {
			WorkExperienceDetails exp = new WorkExperienceDetails();

			exp.setCompanyName(expd.getCompanyName());
			exp.setNumberOfYearsWorked(expd.getNumberOfYearsWorked());
			exp.setDesignation(expd.getDesignation());
			exp.setDescription(expd.getDescription());

			exp.setEmpId(emp);
			exp.setCreatedBy(Constants.Admin);
			exp.setCreatedDate(new Date());
			exp.setModifiedBy(Constants.Admin);
			exp.setModifiedDate(new Date());
			exp.setDeleteFlag(null);
			
			lists.add(exp);
		}

		return lists;
	}

	public List<Address> addAddressDetails(EmployeeModel employeeRequest, Employee emp) {
		List<Address> lists = new ArrayList<>();

		for (Address addrs : employeeRequest.getAddress()) {
			Address addr = new Address();

			addr.setStreetLine1(addrs.getStreetLine1());
			addr.setStreetLine2(addrs.getStreetLine2());
			addr.setCity(addrs.getCity());
			addr.setState(addrs.getState());
			addr.setPinCode(addrs.getPinCode());
			addr.setAddressType(addrs.getAddressType());
			
			addr.setEmpId(emp);
			addr.setCreatedBy(Constants.Admin);
			addr.setCreatedDate(new Date());
			addr.setModifiedBy(Constants.Admin);
			addr.setModifiedDate(new Date());
			addr.setDeleteFlag(null);

			lists.add(addr);
		}

		return lists;
	}

}
