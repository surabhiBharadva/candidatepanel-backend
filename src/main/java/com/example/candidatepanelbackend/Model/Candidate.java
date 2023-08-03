package com.example.candidatepanelbackend.Model;


import java.util.Date;

import com.example.candidatepanelbackend.Enum.CandidateStatus;
import com.example.candidatepanelbackend.Enum.PositionEnum;
import com.example.candidatepanelbackend.Enum.StatusActionEnum;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Candidate  {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String candidateName;
	
	@Enumerated(EnumType.STRING)
	@Basic(optional = false)
	private PositionEnum position;
	
	private Date candidateDate;
	private String email;
	private Long phone;
	private String skills;
	private String fileUpload;
	
	@Enumerated(EnumType.STRING)
	private CandidateStatus candidateStatus; 
	
	private Date joiningDate;
	private String comment;
	
	
	@Enumerated(EnumType.STRING)
	private CandidateAvailabilityEnum candidateAvailability;
	
	private Date createDate;
	private Date modifiedDate;
	
	private String deleteFlag;
	
	private String createBy;
	private String modifiedBy;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	@Column(nullable = false , unique = false)
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	@Column(nullable = false, unique = false)
	public Long getPhone() {
		return phone;
	}
	public void setPhone(Long phone) {
		this.phone = phone;
	}

	@Column(nullable = false)
	public String getFileUpload() {
		return fileUpload;
	}
	public void setFileUpload(String fileUpload) {
		this.fileUpload = fileUpload;
	}
	

	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	
	@Column(nullable = false)
	public String getSkills() {
		return skills;
	}
	public void setSkills(String skills) {
		this.skills = skills;
	}
	
	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	public PositionEnum getPosition() {
		return position;
	}
	public void setPosition(PositionEnum position) {
		this.position = position;
	}
	
	@Column(nullable = false)
	public String getCandidateName() {
		return candidateName;
	}
	public void setCandidateName(String candidateName) {
		this.candidateName = candidateName;
	}
	
	@Enumerated(EnumType.STRING)
	public CandidateStatus getCandidateStatus() {
		return candidateStatus;
	}
	public void setCandidateStatus(CandidateStatus candidateStatus) {
		this.candidateStatus = candidateStatus;
	}
	
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	
	public Date getModifiedDate() {
		return modifiedDate;
	}
	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}
	
	public Date getCandidateDate() {
		return candidateDate;
	}
	public void setCandidateDate(Date candidateDate) {
		this.candidateDate = candidateDate;
	}
	
	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	public CandidateAvailabilityEnum getCandidateAvailability() {
		return candidateAvailability;
	}
	public void setCandidateAvailability(CandidateAvailabilityEnum candidateAvailability) {
		this.candidateAvailability = candidateAvailability;
	}
	public String getDeleteFlag() {
		return deleteFlag;
	}
	public void setDeleteFlag(String deleteFlag) {
		this.deleteFlag = deleteFlag;
	}
	public Date getJoiningDate() {
		return joiningDate;
	}
	public void setJoiningDate(Date joiningDate) {
		this.joiningDate = joiningDate;
	}
	public String getCreateBy() {
		return createBy;
	}
	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}
	public String getModifiedBy() {
		return modifiedBy;
	}
	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}
	
	
	
	
}
