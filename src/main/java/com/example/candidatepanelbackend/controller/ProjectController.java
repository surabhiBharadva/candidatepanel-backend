package com.example.candidatepanelbackend.controller;


import org.slf4j.Logger;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.candidatepanelbackend.service.ProjectService;
import com.example.candidatepanelbackend.utils.ResponseBean;

@RestController
@RequestMapping("project")
@CrossOrigin(origins = "http://localhost:4200")
public class ProjectController {
	
	Logger logger = LoggerFactory.getLogger(ProjectController.class);
		
	@Autowired
	private ProjectService candidateService;
	
	@GetMapping("getProject")
	public ResponseBean getAllProjects() {
		logger.info("Fetching All Project Details...");
		return candidateService.getProduct();
	}
}
