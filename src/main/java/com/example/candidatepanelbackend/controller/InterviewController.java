package com.example.candidatepanelbackend.controller;

import java.util.List;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.candidatepanelbackend.constants.ResponseStatus;
import com.example.candidatepanelbackend.entity.Interview;
import com.example.candidatepanelbackend.responseModels.InterviewModel;
import com.example.candidatepanelbackend.service.InterviewService;
import com.example.candidatepanelbackend.utils.ResponseBean;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/")
public class InterviewController {

	@Autowired
	private InterviewService interviewService;

	@PostMapping("/interview/{candidateId}/{employeeId}")
	private ResponseBean addInterview(@PathVariable Long candidateId, @RequestBody Interview interview,
			@PathVariable Long employeeId) {

		try {
			
			return interviewService.addInterview(interview, candidateId, employeeId);

		} catch (Exception e) {
			return ResponseBean.generateResponse(HttpStatus.ACCEPTED, ResponseStatus.Error,
					"Interview Already Schedule");

		}

	}

	@PutMapping("/interview/{interviewId}/{candidateId}/{employeeId}")
	private ResponseBean updateInterviewResuchdule(@PathVariable Long candidateId, @RequestBody Interview interview,
			@PathVariable Long employeeId, @PathVariable Long interviewId) {

		try {

			return interviewService.updateInterviewResuchdule(interview, candidateId, interviewId, employeeId);

		} catch (Exception e) {
			return ResponseBean.generateResponse(HttpStatus.ACCEPTED, ResponseStatus.Error, "Something want wrong");

		}

	}

	@GetMapping("/interview")
	private ResponseEntity<List<InterviewModel>> getInterview() {

		List<InterviewModel> interview = interviewService.getInterview();
		return new ResponseEntity<>(interview, HttpStatus.OK);
	}

	@PutMapping("/interview/{id}")
	private ResponseBean updateInterview(@PathVariable Long id, @RequestBody Interview interview) {

		try {
			return interviewService.updateInterview(id, interview);
		} catch (Exception e) {
			return ResponseBean.generateResponse(HttpStatus.ACCEPTED, ResponseStatus.Error, "data",
					ResponseStatus.Error);

		}

	}

	@GetMapping("/interview/{id}")
	private ResponseEntity<InterviewModel> getByIdCandidate(@PathVariable Long id) {
		InterviewModel candidateSave = interviewService.getByIdInterView(id);
		return new ResponseEntity<>(candidateSave, HttpStatus.CREATED);
	}

	@GetMapping("/interviewGet/{candidateId}")
	private ResponseBean getInterviewBycandidateId(@PathVariable Long candidateId) {
		return interviewService.getInterviewBycandidateId(candidateId);
		
	}
	
	@GetMapping("/interview/allInterviewList")
	private ResponseEntity<List<InterviewModel>> getAllInterviewList() {

		List<InterviewModel> interview = interviewService.getAllInterviewList();
		return new ResponseEntity<>(interview, HttpStatus.OK);
	}
	
	@GetMapping("/interview/tommorowInterviewList")
	private ResponseEntity<List<InterviewModel>> getTommorowInterviewList() {

		List<InterviewModel> interview = interviewService.getTommorowInterviewList();
		return new ResponseEntity<>(interview, HttpStatus.OK);
	}
	
	@GetMapping("/interview/previousInterviewList")
	private ResponseEntity<List<InterviewModel>> getPreviousInterviewList() {

		List<InterviewModel> interview = interviewService.getPreviousInterviewList();
		return new ResponseEntity<>(interview, HttpStatus.OK);
	}
	
	@GetMapping("/interviewView/{candidateId}")
	private ResponseEntity<Interview> getInterviewBycandidateIdView(@PathVariable Long candidateId) {
		Interview interviewget = interviewService.getInterviewBycandidateIdView(candidateId);
		return new ResponseEntity<>(interviewget, HttpStatus.CREATED);
	}
	
	
}
