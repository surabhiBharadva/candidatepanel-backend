package com.example.candidatepanelbackend.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.candidatepanelbackend.Model.Candidate;
import com.example.candidatepanelbackend.Service.CandidateService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/")
public class CandidateController {
	
	@Autowired private CandidateService candidateService;
	
	@PostMapping("/candidate")
	private ResponseEntity<Candidate> saveCandidate(@RequestBody Candidate candidate) {
		Candidate candidateSave = candidateService.saveCandidate(candidate);
		return new ResponseEntity<>(candidateSave, HttpStatus.CREATED);
	}
	
	@GetMapping("/getCandidate")
	private ResponseEntity<List<Candidate>> getCandidate(){
		  List<Candidate> candidateList = candidateService.getCandidate();
	        return new ResponseEntity<>(candidateList, HttpStatus.OK);		
	}
	
	
}
