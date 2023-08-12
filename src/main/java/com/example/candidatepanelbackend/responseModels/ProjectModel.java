package com.example.candidatepanelbackend.responseModels;


import org.springframework.context.annotation.Configuration;

import org.springframework.stereotype.Component;

@Component
@Configuration
public class ProjectModel {
	
	Integer id;
	String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "ProjectModel [name=" + name + "]";
	}
}
