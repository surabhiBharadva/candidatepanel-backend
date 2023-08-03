package com.example.candidatepanelbackend.Model;

import java.io.Serializable;
import java.time.LocalDateTime;

import com.example.candidatepanelbackend.Enum.StatusEnum;
import com.example.candidatepanelbackend.Model.Candidate;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Interview implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private LocalDateTime schduleDateTime;
	
	private String employeeName;
	
	private StatusEnum status;

	private String feedback;
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "candidateId",unique=false)
	private Candidate candidate;
	
	
	private Long employeeId;
	
	

	public Long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}

	public Candidate getCandidate() {
		return candidate;
	}

	public void setCandidate(Candidate candidate) {
		this.candidate = candidate;
	}

	public StatusEnum getStatus() {
		return status;
	}

	public void setStatus(StatusEnum status) {
		this.status = status;
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

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getFeedback() {
		return feedback;
	}

	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}
	
	
	
}
