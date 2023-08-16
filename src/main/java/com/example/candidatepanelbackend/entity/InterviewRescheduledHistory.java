package com.example.candidatepanelbackend.entity;

import java.time.LocalDateTime;
import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class InterviewRescheduledHistory {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	
	private Long interviewId;
	
	private LocalDateTime interviewSlot;
		
	private String interviewStatus;

	private String feedback;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "candidateId",unique=false)
	private Candidate candidate;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "employeeId",unique=false)
	private Employee employee;
	
	private Integer interviewCount;
	
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
	

	public LocalDateTime getInterviewSlot() {
		return interviewSlot;
	}
	public void setInterviewSlot(LocalDateTime interviewSlot) {
		this.interviewSlot = interviewSlot;
	}
	public String getInterviewStatus() {
		return interviewStatus;
	}
	public void setInterviewStatus(String interviewStatus) {
		this.interviewStatus = interviewStatus;
	}
	public String getFeedback() {
		return feedback;
	}
	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}
	public Candidate getCandidate() {
		return candidate;
	}
	public void setCandidate(Candidate candidate) {
		this.candidate = candidate;
	}
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	public Integer getInterviewCount() {
		return interviewCount;
	}
	public void setInterviewCount(Integer interviewCount) {
		this.interviewCount = interviewCount;
	}
	public Long getInterviewId() {
		return interviewId;
	}
	public void setInterviewId(Long interviewId) {
		this.interviewId = interviewId;
	}
	
	
}
