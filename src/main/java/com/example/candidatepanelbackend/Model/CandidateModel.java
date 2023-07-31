package com.example.candidatepanelbackend.Model;


import java.util.Date;

import org.springframework.stereotype.Component;

import com.example.candidatepanelbackend.Enum.CandidateStatus;
import com.example.candidatepanelbackend.Enum.PositionEnum;
import com.example.candidatepanelbackend.Enum.StatusActionEnum;

@Component
public class CandidateModel {
	
	private Long id;
	private String candidateName;
	
	private PositionEnum position;
	private String email;
	private Long phone;
	private String skills;

	private Date jDate;
	private String comment;
	private DocumentDetilsModel documentDetails;
	private CandidateStatus candidateStatus;
	
	private CandidateAvailabilityEnum candidateAvailability;
	
	private Date candidateDate;
	private StatusActionEnum  status;
	
	
	public String getCandidateName() {
		return candidateName;
	}
	public void setCandidateName(String candidateName) {
		this.candidateName = candidateName;
	}
	public CandidateStatus getCandidateStatus() {
		return candidateStatus;
	}
	public void setCandidateStatus(CandidateStatus candidateStatus) {
		this.candidateStatus = candidateStatus;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public PositionEnum getPosition() {
		return position;
	}
	public void setPosition(PositionEnum position) {
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
	public Date getjDate() {
		return jDate;
	}
	public void setjDate(Date jDate) {
		this.jDate = jDate;
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
	public CandidateAvailabilityEnum getCandidateAvailability() {
		return candidateAvailability;
	}
	public void setCandidateAvailability(CandidateAvailabilityEnum candidateAvailability) {
		this.candidateAvailability = candidateAvailability;
	}
	public StatusActionEnum isStatus() {
		return status;
	}
	public void setStatus(StatusActionEnum inanctive) {
		this.status = inanctive;
	}
	
	
	
}
