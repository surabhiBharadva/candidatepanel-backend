package com.example.candidatepanelbackend.service;

import java.util.ArrayList;


import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.candidatepanelbackend.constants.Constants;
import com.example.candidatepanelbackend.constants.ResponseStatus;
import com.example.candidatepanelbackend.entity.Candidate;
import com.example.candidatepanelbackend.entity.Employee;
import com.example.candidatepanelbackend.entity.Interview;
import com.example.candidatepanelbackend.repo.InterviewRepo;
import com.example.candidatepanelbackend.responseModels.CandidateModel;
import com.example.candidatepanelbackend.responseModels.DocumentDetilsModel;
import com.example.candidatepanelbackend.responseModels.InterviewModel;
import com.example.candidatepanelbackend.utils.ResponseBean;



public interface InterviewService {

	ResponseBean addInterview(Interview interview, Long candidateId, Long employeeId);

	ResponseBean updateInterviewResuchdule(Interview interview, Long candidateId, Long interviewId, Long employeeId);

	List<InterviewModel> getInterview();

	ResponseBean updateInterview(Long id, Interview interview);

	InterviewModel getByIdInterView(Long id);

	ResponseBean getInterviewBycandidateId(Long candidateId);

	List<InterviewModel> getAllInterviewList();

	List<InterviewModel> getTommorowInterviewList();

	List<InterviewModel> getPreviousInterviewList();

	Interview checkStatusSelected(Long id);

	Interview getInterviewBycandidateIdView(Long candidateId);
	
	
}
