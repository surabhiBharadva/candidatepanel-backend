package com.example.candidatepanelbackend.Model;


import java.util.Date;

import org.springframework.stereotype.Component;

import com.example.candidatepanelbackend.Enum.CandidateStatus;
import com.example.candidatepanelbackend.Enum.PositionEnum;
import com.example.candidatepanelbackend.Enum.StatusActionEnum;

@Component
public class CandidateModel {
	
	private Long id;
	private String firstName;

	private String lastName;
	private String position;
	private String email;
	private Long phone;
	private String skills;

	private Date joiningDate;
	private String comment;
	private DocumentDetilsModel documentDetails;
	private String candidateStatus;
	
	private String joiningAvailability;
	
	private Date candidateDate;
	private String  status;
	
	
	
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
	
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Long getPhone() {
		return phone;
	}
	public void setPhone(Long phone) {
		this.phone = phone;
	}
	public String getSkills() {
		return skills;
	}
	public void setSkills(String skills) {
		this.skills = skills;
	}
	
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public DocumentDetilsModel getDocumentDetails() {
		return documentDetails;
	}
	public void setDocumentDetails(DocumentDetilsModel documentDetails) {
		this.documentDetails = documentDetails;
	}
	public Date getCandidateDate() {
		return candidateDate;
	}
	public void setCandidateDate(Date candidateDate) {
		this.candidateDate = candidateDate;
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
	
	
	
}
