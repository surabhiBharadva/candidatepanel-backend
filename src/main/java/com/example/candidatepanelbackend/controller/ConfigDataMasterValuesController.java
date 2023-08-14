package com.example.candidatepanelbackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.candidatepanelbackend.service.ConfigDataMasterService;
import com.example.candidatepanelbackend.service.ConfigDataMasterValuesService;
import com.example.candidatepanelbackend.utils.ResponseBean;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class ConfigDataMasterValuesController {
	
	@Autowired
	private ConfigDataMasterValuesService configDataMasterValuesService;
	
	@GetMapping("/candidateStatusValue")
	private ResponseBean candidateStatus() {
		return configDataMasterValuesService.getCandidateStatus();
	}
	
	
	@GetMapping("/interviewStatusValue")
	private ResponseBean interviewStatus() {
		return configDataMasterValuesService.interviewStatus();
	}
}
