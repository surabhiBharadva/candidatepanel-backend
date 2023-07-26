package com.example.candidatepanelbackend.Model;

import java.sql.Date;


import jakarta.persistence.Entity;
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
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private Integer acardNum;
	private String firstName;
	private String lname;
	private String email;
	private Integer phone;	
	private Date jDate;
	private String country;
	private String state;
	private String city;
	private Date dob; 
	private String adadharcard;
	private String pancard;
	private String marksheet;
	
	

	public String getAdadharcard() {
		return adadharcard;
	}

	public void setAdadharcard(String adadharcard) {
		this.adadharcard = adadharcard;
	}

	public String getPancard() {
		return pancard;
	}

	public void setPancard(String pancard) {
		this.pancard = pancard;
	}

	public String getMarksheet() {
		return marksheet;
	}

	public void setMarksheet(String marksheet) {
		this.marksheet = marksheet;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
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
	public Date getjDate() {
		return jDate;
	}
	public void setjDate(Date jDate) {
		this.jDate = jDate;
	}

	public Integer getAcardNum() {
		return acardNum;
	}

	public void setAcardNum(Integer acardNum) {
		this.acardNum = acardNum;
	}
	
	

}
