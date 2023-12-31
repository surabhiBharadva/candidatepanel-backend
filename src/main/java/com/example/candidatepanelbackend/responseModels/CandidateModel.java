package com.example.candidatepanelbackend.responseModels;


import java.util.Date;

import org.springframework.stereotype.Component;



@Component
public class CandidateModel {
	
	private Long id;
	private String firstName;

	private String lastName;
	private String jobRequirement;
	private String email;
	private Long phoneNo;
	private String skills;

	private Date joiningDate;
	private String comments;
	private DocumentDetilsModel documentDetails;
	private String candidateStatus;
	
	private String joiningAvailability;
	
	private Date applicationDate;
	private String  status;
	
	private Date createdDate;
	private Date modifiedDate;
	
	private String createdBy;
	private String modifiedBy;
	
	public String getCandidateStatus() {
		return candidateStatus;
	}
	public void setCandidateStatus(String candidateStatus) {
		this.candidateStatus = candidateStatus;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	
	public String getJobRequirement() {
		return jobRequirement;
	}
	public void setJobRequirement(String jobRequirement) {
		this.jobRequirement = jobRequirement;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getSkills() {
		return skills;
	}
	public void setSkills(String skills) {
		this.skills = skills;
	}
	
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public DocumentDetilsModel getDocumentDetails() {
		return documentDetails;
	}
	public void setDocumentDetails(DocumentDetilsModel documentDetails) {
		this.documentDetails = documentDetails;
	}
	
	public Date getJoiningDate() {
		return joiningDate;
	}
	public void setJoiningDate(Date joiningDate) {
		this.joiningDate = joiningDate;
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
	public String getJoiningAvailability() {
		return joiningAvailability;
	}
	public void setJoiningAvailability(String joiningAvailability) {
		this.joiningAvailability = joiningAvailability;
	}
	public Date getApplicationDate() {
		return applicationDate;
	}
	public void setApplicationDate(Date applicationDate) {
		this.applicationDate = applicationDate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Long getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(Long phoneNo) {
		this.phoneNo = phoneNo;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public Date getModifiedDate() {
		return modifiedDate;
	}
	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public String getModifiedBy() {
		return modifiedBy;
	}
	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}
	
	
	
}
