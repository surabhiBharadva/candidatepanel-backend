package com.example.candidatepanelbackend.service;

import java.util.ArrayList;
import java.util.Date;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.candidatepanelbackend.constants.Constants;
import com.example.candidatepanelbackend.entity.ConfigDataMasterValues;
import com.example.candidatepanelbackend.entity.Interview;
import com.example.candidatepanelbackend.entity.InterviewRescheduledHistory;
import com.example.candidatepanelbackend.repo.InterviewRescheduledHistoryRepo;
@Service
public class InterviewRescheduledHistoryService {
	
	@Autowired
	private InterviewRescheduledHistoryRepo  interviewRescheduledHistoryRepo;
	
	@Autowired
	private ConfigDataMasterValuesService configDataMasterValuesService;

	public InterviewRescheduledHistory saveResuduleInterview(Interview interview) {
		InterviewRescheduledHistory interviewRescheduledHistory = new InterviewRescheduledHistory();
		interviewRescheduledHistory.setCandidate(interview.getCandidate());
		interviewRescheduledHistory.setInterviewId(interview.getId());
		interviewRescheduledHistory.setEmployee(interview.getEmployee());
		interviewRescheduledHistory.setCreatedBy(Constants.Admin);
		interviewRescheduledHistory.setModifiedBy(Constants.Admin);
		interviewRescheduledHistory.setCreatedDate(new Date());
		interviewRescheduledHistory.setModifiedDate(new Date());
		interviewRescheduledHistory.setInterviewSlot(interview.getInterviewSlot());
		interviewRescheduledHistory.setFeedback(interview.getFeedback());
		interviewRescheduledHistory.setInterviewStatus(interview.getInterviewStatus());
		List<InterviewRescheduledHistory> interviewRescheduledHistoryList = interviewRescheduledHistoryRepo
				.getInterviewReseduledDetails(interview.getId());
		if (interviewRescheduledHistoryList != null && !interviewRescheduledHistoryList.isEmpty()) {
			for (InterviewRescheduledHistory interviewRescheduledHistoryObject : interviewRescheduledHistoryList) {
				if (interviewRescheduledHistoryObject.getEmployee().equals(interview.getEmployee())) {
					Integer counter = interviewRescheduledHistoryObject.getInterviewCount();

					counter++;
					interviewRescheduledHistory.setInterviewCount(counter);

				} else {
					Integer counter = 0;
					counter++;
					interviewRescheduledHistory.setInterviewCount(counter);
				}
			}
		} else {
			Integer counter = 0;
			counter++;
			interviewRescheduledHistory.setInterviewCount(counter);
		}
		 return interviewRescheduledHistoryRepo.save(interviewRescheduledHistory);
 

	}

	public List<InterviewRescheduledHistory> getInterview() {
		return interviewRescheduledHistoryRepo.findAll();
	}

	public List<InterviewRescheduledHistory> getInterviewbyId(Long interviewId) {
		List<InterviewRescheduledHistory> interviewRescheduledHistoryList = interviewRescheduledHistoryRepo.getInterviewbyId(interviewId);
		List<InterviewRescheduledHistory> interviewRescheduledHistoryStore = new ArrayList<InterviewRescheduledHistory>();
		for(InterviewRescheduledHistory interviewRescheduledHistory : interviewRescheduledHistoryList) {
			
			InterviewRescheduledHistory interviewRescheduledHistoryObject = new InterviewRescheduledHistory();
			interviewRescheduledHistoryObject.setId(interviewRescheduledHistory.getId());
			interviewRescheduledHistoryObject.setCandidate(interviewRescheduledHistory.getCandidate());
			interviewRescheduledHistoryObject.setEmployee(interviewRescheduledHistory.getEmployee());
			interviewRescheduledHistoryObject.setFeedback(interviewRescheduledHistory.getFeedback());
			interviewRescheduledHistoryObject.setModifiedBy(interviewRescheduledHistory.getModifiedBy());
			interviewRescheduledHistoryObject.setInterviewSlot(interviewRescheduledHistory.getInterviewSlot());
			interviewRescheduledHistoryObject.setInterviewId(interviewRescheduledHistory.getInterviewId());
			ConfigDataMasterValues configDataMaster = configDataMasterValuesService.getValuebyKey(interviewRescheduledHistory.getInterviewStatus(),Constants.InterviewStatus);
			interviewRescheduledHistoryObject.setInterviewStatus(configDataMaster.getConfigValue());
			
			interviewRescheduledHistoryStore.add(interviewRescheduledHistoryObject);
		}
			
		return interviewRescheduledHistoryStore;
	}

}
