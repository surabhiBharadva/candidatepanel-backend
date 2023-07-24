package com.example.candidatepanelbackend.Model;

import java.sql.Date;

import com.example.candidatepanelbackend.Enum.PositionEnum;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Candidate {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	private String lname;
	
	@Column(name ="firstName")
	private String firstName;
	
	private String email;
	private Integer phone;
	private String skill;
	private PositionEnum position;
	
	@Column(name ="fileUpload")
	private String fileUpload;
	
	@Column(name ="jDate")
	private Date jDate;
	private String comment;
	private boolean activeAndInactive; 
}
