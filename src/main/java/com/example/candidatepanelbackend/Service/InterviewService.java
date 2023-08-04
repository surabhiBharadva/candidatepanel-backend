package com.example.candidatepanelbackend.Service;

import java.util.ArrayList;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.candidatepanelbackend.Enum.ResponseStatus;
import com.example.candidatepanelbackend.Enum.StatusEnum;
import com.example.candidatepanelbackend.Model.Candidate;
import com.example.candidatepanelbackend.Model.CandidateModel;
import com.example.candidatepanelbackend.Model.Interview;
import com.example.candidatepanelbackend.Model.InterviewModel;
import com.example.candidatepanelbackend.Repo.InterviewRepo;



@Service
public class InterviewService {
	
	@Autowired
	private InterviewRepo interviewRepo;
	
	@Autowired
	private CandidateService candidateService;
	
	@Autowired
	private ResponseService responseService;

	public Interview addInterview(Interview interview) {
		return interviewRepo.save(interview);
		
	}

	public List<InterviewModel> getInterview() {
		
	  
	   List<Interview> interviewList = interviewRepo.findTodayInterview();
	   List<InterviewModel> interviewAdd = new ArrayList<InterviewModel>();
		for(Interview interview : interviewList) {
			InterviewModel interviewModel = new InterviewModel();
			if(interview.getCandidate() != null && interview.getCandidate().getId() != null) {
			Candidate candidate = candidateService.getByIdCandidate(interview.getCandidate().getId());
			CandidateModel candidateModel = new CandidateModel(); 
			candidateModel.setFirstName(candidate.getFirstName());
			candidateModel.setLastName(candidate.getLastName());
			candidateModel.setPosition(candidate.getPosition());
			interviewModel.setCandidate(candidateModel);
		}
			interviewModel.setStatus(interview.getStatus());
			interviewModel.setEmployeeName(interview.getEmployeeName());
			interviewModel.setSchduleDateTime(interview.getSchduleDateTime());
			interviewModel.setId(interview.getId());
			
			
			interviewAdd.add(interviewModel);
		}
		return interviewAdd;
	}

	public ResponseEntity<Object> updateInterview(Long id, Interview interview) {
		try {
		Interview interviewSet = interviewRepo.findById(id).get();
		if(interview.getStatus().equals("Selected")) {
			candidateService.updateStatusCandidateSelected(interviewSet.getCandidate().getId(),true);
		}
		if(interview.getStatus().equals("Rejected")) {
			candidateService.updateStatusCandidateSelected(interviewSet.getCandidate().getId(),false);
		}
	
		interviewSet.setStatus(interview.getStatus());
		interviewSet.setFeedback(interview.getFeedback());
		
		//interviewSet.setCandidate(interviewSet.getCandidate());
		final Interview interviewUpdate = interviewRepo.save(interviewSet);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(responseService
				.RespnseData("Interview Schedule Update Successfully", interviewUpdate, ResponseStatus.Success));
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.ACCEPTED).body(responseService
					.RespnseData("data" ,e, ResponseStatus.Error));
		}
		
	}

	public InterviewModel getByIdInterView(Long id) {
		Interview interview = interviewRepo.findById(id).get();
		Candidate candidate = candidateService.getByIdCandidate(interview.getCandidate().getId());
		CandidateModel candidateModel = new CandidateModel();
		InterviewModel interviewModel = new InterviewModel();
		candidateModel.setFirstName(candidate.getFirstName());
		candidateModel.setLastName(candidate.getLastName());
		interviewModel.setId(interview.getId());
		interviewModel.setStatus(interview.getStatus());
		interviewModel.setCandidate(candidateModel);
		return interviewModel;
	}
	public Interview getById(Long id) {
		Interview interview = interviewRepo.findById(id).get();
		return interview;
	}

	public boolean checkStatusSelected(Long cadidateId) {
		
	return interviewRepo.checkStatusSelected(cadidateId);
	}

	
}
