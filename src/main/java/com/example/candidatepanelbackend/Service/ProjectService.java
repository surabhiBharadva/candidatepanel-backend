package com.example.candidatepanelbackend.Service;


import com.example.candidatepanelbackend.entity.Project;
import com.example.candidatepanelbackend.utils.ResponseBean;

public interface ProjectService {

	ResponseBean getProduct();
	
	Project getProjectById(Integer productId);
	
}