package com.example.candidatepanelbackend.ResponseModels;

import java.util.Date;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
@Configuration
public class TimeSheetModel {
	
	private Integer id;
	private Integer project;
	private Integer task;
	private Integer hours;
	private Date date;
	private String employeeId;
	
	public String getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getProject() {
		return project;
	}
	public void setProject(Integer project) {
		this.project = project;
	}
	public Integer getTask() {
		return task;
	}
	public void setTask(Integer task) {
		this.task = task;
	}
	public Integer getHours() {
		return hours;
	}
	public void setHours(Integer hours) {
		this.hours = hours;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	@Override
	public String toString() {
		return "TimeSheetModel [id=" + id + ", project=" + project + ", task=" + task + ", hours=" + hours + ", date="
				+ date + ", employeeId=" + employeeId + "]";
	}
	
}
