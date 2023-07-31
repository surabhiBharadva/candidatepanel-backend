package com.example.candidatepanelbackend.Service;

import java.util.ArrayList;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

	public Interview addInterview(Interview interview) {
		return interviewRepo.save(interview);
		
	}

	public List<InterviewModel> getInterview() {
	   List<Interview> interviewList = interviewRepo.findAll();
	   List<InterviewModel> interviewAdd = new ArrayList<InterviewModel>();
		for(Interview interview : interviewList) {
			InterviewModel interviewModel = new InterviewModel();
			if(interview.getCandidate() != null && interview.getCandidate().getId() != null) {
			Candidate candidate = candidateService.getByIdCandidate(interview.getCandidate().getId());
			CandidateModel candidateModel = new CandidateModel(); 
			candidateModel.setCandidateName(candidate.getCandidateName());
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

	public Interview updateInterview(Integer id, Interview interview) {
		
		Interview interviewSet = interviewRepo.findById(id).get();
		interviewSet.setStatus(interview.getStatus());
		interviewSet.setFeedback(interview.getFeedback());
		interviewSet.setCandidate(interview.getCandidate());
		final Interview interviewUpdate = interviewRepo.save(interviewSet);
		return interviewUpdate;
		
	}
	
}
