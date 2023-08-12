package com.example.candidatepanelbackend.controller;


import org.slf4j.Logger;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.candidatepanelbackend.service.TaskService;
import com.example.candidatepanelbackend.utils.ResponseBean;

@RestController
@RequestMapping("task")
@CrossOrigin(origins = "http://localhost:4200")
public class TaskController {
	
	Logger logger = LoggerFactory.getLogger(TaskController.class);
		
	@Autowired
	private TaskService taskService;
	
	@GetMapping("getTasks/{projectId}")
	public ResponseBean getTasksByProjectId(@PathVariable Integer projectId) {
		logger.info("Fetching All Products Details...");
		return taskService.getTaskByProjectId(projectId);
	}
}
