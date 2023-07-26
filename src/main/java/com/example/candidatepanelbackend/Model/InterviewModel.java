package com.example.candidatepanelbackend.Model;

import java.time.LocalDateTime;

import org.springframework.stereotype.Component;

import com.example.candidatepanelbackend.Enum.StatusEnum;

@Component
public class InterviewModel {

	private Integer id;
	
	private LocalDateTime schduleDateTime;
	
	private String employeeName;
	
	private StatusEnum status;

	public StatusEnum getStatus() {
		return status;
	}

	public void setStatus(StatusEnum status) {
		this.status = status;
	}

	private CandidateModel candidate;
	
	public CandidateModel getCandidate() {
		return candidate;
	}

	public void setCandidate(CandidateModel candidate) {
		this.candidate = candidate;
	}

	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	public LocalDateTime  getSchduleDateTime() {
		return schduleDateTime;
	}

	public void setSchduleDateTime(LocalDateTime schduleDateTime) {
		this.schduleDateTime = schduleDateTime;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	
}
