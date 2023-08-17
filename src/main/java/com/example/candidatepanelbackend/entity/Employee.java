package com.example.candidatepanelbackend.entity;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
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

	@OneToOne(mappedBy = "employee")
	private OrganizationDetails organizationDetails;

	@OneToMany(mappedBy = "empId", cascade = CascadeType.ALL)
	private List<EducationDetails> educationDetails;

	@OneToMany(mappedBy = "empId", cascade = CascadeType.ALL)
	private List<WorkExperienceDetails> workExperienceDetails;

	@OneToMany(mappedBy = "empId", cascade = CascadeType.ALL)
	private List<Address> address;

	@OneToMany(mappedBy = "employeeId", cascade = CascadeType.ALL)
	private List<DocumentDetails> employeeDocuments;

	private Date createdDate;
	private String createdBy;
	private Date modifiedDate;
	private String modifiedBy;
	private String deleteFlag;
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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

//	public String getEmployeeStatus() {
//		return employeeStatus;
//	}
//	public void setEmployeeStatus(String employeeStatus) {
//		this.employeeStatus = employeeStatus;
//	}
	public List<WorkExperienceDetails> getWorkExperienceDetails() {
		return workExperienceDetails;
	}

	public void setWorkExperienceDetails(List<WorkExperienceDetails> workExperienceDetails) {
		this.workExperienceDetails = workExperienceDetails;
	}

	public List<EducationDetails> getEducationDetails() {
		return educationDetails;
	}

	public void setEducationDetails(List<EducationDetails> educationDetails) {
		this.educationDetails = educationDetails;
	}

	public OrganizationDetails getOrganizationDetails() {
		return organizationDetails;
	}

	public void setOrganizationDetails(OrganizationDetails organizationDetails) {
		this.organizationDetails = organizationDetails;
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

	public String getDocumentType() {
		return documentType;
	}

	public void setDocumentType(String documentType) {
		this.documentType = documentType;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Date getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public String getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public String getDeleteFlag() {
		return deleteFlag;
	}

	public void setDeleteFlag(String deleteFlag) {
		this.deleteFlag = deleteFlag;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", phoneNo=" + phoneNo + ", aadharCardNumber=" + aadharCardNumber + ", dateofBirth=" + dateofBirth
				+ ", organizationDetails=" + organizationDetails + ", educationDetails=" + educationDetails
				+ ", workExperienceDetails=" + workExperienceDetails + ", address=" + address + ", employeeDocuments="
				+ employeeDocuments + ", documentType=" + documentType + ", createdDate=" + createdDate + ", createdBy="
				+ createdBy + ", modifiedDate=" + modifiedDate + ", modifiedBy=" + modifiedBy + ", deleteFlag="
				+ deleteFlag + "]";
	}

}