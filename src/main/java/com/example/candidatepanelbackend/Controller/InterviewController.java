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

import com.example.candidatepanelbackend.Enum.ResponseStatus;
import com.example.candidatepanelbackend.Model.Candidate;
import com.example.candidatepanelbackend.Model.Employee;
import com.example.candidatepanelbackend.Model.Interview;
import com.example.candidatepanelbackend.Model.InterviewModel;
import com.example.candidatepanelbackend.Service.CandidateService;
import com.example.candidatepanelbackend.Service.EmployeeService;
import com.example.candidatepanelbackend.Service.InterviewService;
import com.example.candidatepanelbackend.Service.ResponseService;



@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/")
public class InterviewController {
	
	@Autowired 
	private InterviewService interviewService;
	
	@Autowired 
	private CandidateService candidateService;
	
	@Autowired 
	private EmployeeService employeeService;
	
	@Autowired
	private ResponseService responseService;
	
	@PostMapping("/interview/{candidateId}/{employeeId}")
	private ResponseEntity<Object> addInterview(@PathVariable Long candidateId,@RequestBody Interview interview,@PathVariable Long employeeId){
		Interview interviewSet = null;
		Candidate candidate = candidateService.getByIdCandidate(candidateId);
		interview.setCandidate(candidate);
		Employee employee = employeeService.getByIdEmployee(employeeId);
		interview.setEmployeeName(employee.getFirstName());
		interview.setEmployeeId(employeeId);
		try {
			interview.setStatus("Scheduled");
		interviewSet =  interviewService.addInterview(interview);
		 candidateService.updateStatus(candidate.getId());
		}catch(Exception e){
			return ResponseEntity.status(HttpStatus.ACCEPTED)
					.body(responseService.RespnseData("Interview Already Schedule",com.example.candidatepanelbackend.Enum.ResponseStatus.Error));
		}
		 return ResponseEntity.status(HttpStatus.ACCEPTED).body(responseService.RespnseData("Interview Schedule add Successfully", interviewSet,ResponseStatus.Success));
	}
	
	@GetMapping("/interview")
	private ResponseEntity<List<InterviewModel>> getInterview(){
		
		List<InterviewModel> interview = interviewService.getInterview();
		return new ResponseEntity<>(interview, HttpStatus.OK);
	}
	
	@PutMapping("/interview/{id}")
	private ResponseEntity<Object> updateInterview(@PathVariable Long id, @RequestBody Interview interview) {

		try {
			return interviewService.updateInterview(id, interview);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.ACCEPTED).body(responseService.RespnseData("data", e,
					com.example.candidatepanelbackend.Enum.ResponseStatus.Error));
		}

	}
	
	@GetMapping("/interview/{id}")
	private ResponseEntity<InterviewModel> getByIdCandidate(@PathVariable Long id) {
		InterviewModel candidateSave = interviewService.getByIdInterView(id);
		return new ResponseEntity<>(candidateSave, HttpStatus.CREATED);
	}
	
	@GetMapping("/interviewGet/{candidateId}")
	private ResponseEntity<Interview> getInterviewBycandidateId(@PathVariable Long candidateId) {
		Interview interviewget = interviewService.getInterviewBycandidateId(candidateId);
		return new ResponseEntity<>(interviewget, HttpStatus.CREATED);
	}
	
	
}
