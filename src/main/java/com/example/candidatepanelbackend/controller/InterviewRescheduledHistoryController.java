package com.example.candidatepanelbackend.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.candidatepanelbackend.entity.InterviewRescheduledHistory;
import com.example.candidatepanelbackend.service.InterviewRescheduledHistoryService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/")
public class InterviewRescheduledHistoryController {
	
	@Autowired
	private InterviewRescheduledHistoryService interviewRescheduledHistoryService;
	
	@GetMapping("/interviewReschedule")
	private ResponseEntity<List<InterviewRescheduledHistory>> getInterview() {

		List<InterviewRescheduledHistory> interviewRescheduled = interviewRescheduledHistoryService.getInterview();
		return new ResponseEntity<>(interviewRescheduled, HttpStatus.OK);
	}
	
	@GetMapping("/interviewReschedule/{interviewId}")
	private ResponseEntity<List<InterviewRescheduledHistory>> getInterview(@PathVariable Long interviewId) {

		List<InterviewRescheduledHistory> interviewRescheduled = interviewRescheduledHistoryService.getInterviewbyId(interviewId);
		return new ResponseEntity<>(interviewRescheduled, HttpStatus.OK);
	}


}
