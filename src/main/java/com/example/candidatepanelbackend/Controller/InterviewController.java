package com.example.candidatepanelbackend.Controller;

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

import com.example.candidatepanelbackend.Model.Candidate;
import com.example.candidatepanelbackend.Model.Interview;
import com.example.candidatepanelbackend.Model.InterviewModel;
import com.example.candidatepanelbackend.Service.CandidateService;
import com.example.candidatepanelbackend.Service.InterviewService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/")
public class InterviewController {
	
	@Autowired 
	private InterviewService interviewService;
	
	@Autowired 
	private CandidateService candidateService;
	
	@PostMapping("/interview/{candidateId}")
	private ResponseEntity<Interview> addInterview(@PathVariable Long candidateId,@RequestBody Interview interview){
		Candidate candidate =	candidateService.getByIdCandidate(candidateId);
		interview.setCandidate(candidate);
		
		Interview interview2 =  interviewService.addInterview(interview);
		return new ResponseEntity<>(interview2, HttpStatus.CREATED);
	}
	
	@GetMapping("/interview")
	private ResponseEntity<List<InterviewModel>> getInterview(){
		
		List<InterviewModel> interview = interviewService.getInterview();
		return new ResponseEntity<>(interview, HttpStatus.OK);
	}
	
	@PutMapping("/interview/{id}")
	private ResponseEntity<Interview> updateInterview(@PathVariable Integer id,@RequestBody Interview interview){
		
		Interview interview2 =  interviewService.updateInterview(id,interview);
		return new ResponseEntity<>(interview2, HttpStatus.CREATED);
	}
	
	
}
