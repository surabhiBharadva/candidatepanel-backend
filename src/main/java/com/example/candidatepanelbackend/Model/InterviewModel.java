package com.example.candidatepanelbackend.Model;

import java.time.LocalDateTime;

import org.springframework.stereotype.Component;

import com.example.candidatepanelbackend.Enum.StatusEnum;

@Component
public class InterviewModel {

	private Long id;
	
	private LocalDateTime schduleDateTime;
	
	private Employee employee;
	
	private String status;
	private String modifiedBy;
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	private CandidateModel candidate;
	
	public CandidateModel getCandidate() {
		return candidate;
	}

	public void setCandidate(CandidateModel candidate) {
		this.candidate = candidate;
	}

	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	public LocalDateTime  getSchduleDateTime() {
		return schduleDateTime;
	}

	public void setSchduleDateTime(LocalDateTime schduleDateTime) {
		this.schduleDateTime = schduleDateTime;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public String getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	
	
}
