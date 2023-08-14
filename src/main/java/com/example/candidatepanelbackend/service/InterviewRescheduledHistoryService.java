package com.example.candidatepanelbackend.service;

import java.util.Date;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.candidatepanelbackend.constants.Constants;
import com.example.candidatepanelbackend.entity.Interview;
import com.example.candidatepanelbackend.entity.InterviewRescheduledHistory;
import com.example.candidatepanelbackend.repo.InterviewRescheduledHistoryRepo;
@Service
public class InterviewRescheduledHistoryService {
	
	@Autowired
	private InterviewRescheduledHistoryRepo  interviewRescheduledHistoryRepo;

	public InterviewRescheduledHistory saveResuduleInterview(Interview interview) {
		InterviewRescheduledHistory interviewRescheduledHistory = new InterviewRescheduledHistory();
		interviewRescheduledHistory.setCandidate(interview.getCandidate());
		interviewRescheduledHistory.setInterviewId(interview.getId());
		interviewRescheduledHistory.setEmployee(interview.getEmployee());
		interviewRescheduledHistory.setCreatedBy(Constants.Admin);
		interviewRescheduledHistory.setModifiedBy(Constants.Admin);
		interviewRescheduledHistory.setCreatedDate(new Date());
		interviewRescheduledHistory.setModifiedDate(new Date());
		interviewRescheduledHistory.setSchduleDateTime(interview.getSchduleDateTime());
		interviewRescheduledHistory.setFeedback(interview.getFeedback());
		interviewRescheduledHistory.setStatus(interview.getStatus());
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
		return interviewRescheduledHistoryRepo.getInterviewbyId(interviewId);
	}

}
