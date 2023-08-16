package com.example.candidatepanelbackend.responseModels;

import java.time.LocalDateTime;


import java.util.List;

import org.springframework.stereotype.Component;

import com.example.candidatepanelbackend.entity.Employee;
import com.example.candidatepanelbackend.entity.InterviewRescheduledHistory;


@Component
public class InterviewModel {

	private Long id;
	
	private LocalDateTime interviewSlot;
	
	private Employee employee;
	
	private String interviewStatus;
	private String modifiedBy;
	
	private List<InterviewRescheduledHistory> interviewRescheduledHistory;
	

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

	public List<InterviewRescheduledHistory> getInterviewRescheduledHistory() {
		return interviewRescheduledHistory;
	}

	public void setInterviewRescheduledHistory(List<InterviewRescheduledHistory> interviewRescheduledHistory) {
		this.interviewRescheduledHistory = interviewRescheduledHistory;
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

	
	
}
