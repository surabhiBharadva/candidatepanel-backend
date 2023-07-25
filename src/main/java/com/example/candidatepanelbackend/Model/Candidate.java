package com.example.candidatepanelbackend.Model;

import java.sql.Date;

import com.example.candidatepanelbackend.Enum.PositionEnum;

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
public class Candidate {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String firstName;
	private String lname;
	
	@Enumerated(EnumType.STRING)
	@Basic(optional = false)
	private PositionEnum position;
	
	private String email;
	private Integer phone;
	private String skills;
	private String fileUpload;
	
	
	
	private Date jDate;
	private String comment;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	@Column(name ="first_Name")
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	@Column(name ="lName")
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Integer getPhone() {
		return phone;
	}
	public void setPhone(Integer phone) {
		this.phone = phone;
	}
	
	@Column(name ="file_upload")
	public String getFileUpload() {
		return fileUpload;
	}
	public void setFileUpload(String fileUpload) {
		this.fileUpload = fileUpload;
	}
	
	@Column(name ="j_Date")
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
	public String getSkills() {
		return skills;
	}
	public void setSkills(String skills) {
		this.skills = skills;
	}
	
	@Column(name = "position", unique = true)
	public PositionEnum getPosition() {
		return position;
	}
	public void setPosition(PositionEnum position) {
		this.position = position;
	}
	
	
	
	
	
	
	
	
	
}
