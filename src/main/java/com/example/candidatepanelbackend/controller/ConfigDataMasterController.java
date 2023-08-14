package com.example.candidatepanelbackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.candidatepanelbackend.service.ConfigDataMasterService;
import com.example.candidatepanelbackend.utils.ResponseBean;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/")
public class ConfigDataMasterController {

	@Autowired
	private ConfigDataMasterService configDataMasterService;
	
	@GetMapping("/candidateStatus")
	private ResponseBean candidateStatus() {
		return configDataMasterService.candidateStatus();
	}
	
	
	
}
