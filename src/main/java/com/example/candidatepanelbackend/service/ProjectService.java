package com.example.candidatepanelbackend.service;


import com.example.candidatepanelbackend.entity.Project;
import com.example.candidatepanelbackend.utils.ResponseBean;

public interface ProjectService {

	ResponseBean getProduct();
	
	Project getProjectById(Integer productId);
	
}