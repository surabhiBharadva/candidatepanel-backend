package com.example.candidatepanelbackend.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

@Service
public class InterviewServiceImpl implements InterviewService{
	@Autowired
	private InterviewRepo interviewRepo;
	
	@Autowired
	private CandidateService candidateService;
	
	@Autowired
	private DocumentService documentService;
	
	@Autowired 
	private EmployeeService employeeService;
	
	@Autowired
	private InterviewRescheduledHistoryService interviewRescheduledHistoryService;

	public ResponseBean addInterview(Interview interview, Long candidateId, Long employeeId) {
		try {
			Candidate candidate = candidateService.getByIdCandidate(candidateId);
			interview.setCandidate(candidate);
			Employee employee = employeeService.getByIdEmployee(employeeId);
			interview.setEmployee(employee);
			interview.setStatus(Constants.InterviewScheduled);
			interview.setCreatedDate(new Date());
			interview.setCreatedBy(Constants.Admin);
			interview.setModifiedDate(new Date());
			interview.setModifiedBy(Constants.Admin);
			Interview interviewSet = interviewRepo.save(interview);
			candidateService.updateStatus(candidate.getId());
			return ResponseBean.generateResponse(HttpStatus.ACCEPTED, ResponseStatus.Success, interviewSet,
					"Interview Schedule Add Successfully");
		} catch (Exception e) {
			return ResponseBean.generateResponse(HttpStatus.ACCEPTED, ResponseStatus.Error, "Something went to wrong");

		}
	}

	public List<InterviewModel> getInterview() {
		
	  
	   List<Interview> interviewList = interviewRepo.findTodayInterview();
	   List<InterviewModel> interviewAdd = getInterviewDetils(interviewList);
	  
		return interviewAdd;
	}

	private List<InterviewModel> getInterviewDetils(List<Interview> interviewList) {
		 List<InterviewModel> interviewAdd = new ArrayList<InterviewModel>();
			for(Interview interview : interviewList) {
				InterviewModel interviewModel = new InterviewModel();
				if(interview.getCandidate() != null && interview.getCandidate().getId() != null) {
				
				CandidateModel candidateModel = new CandidateModel(); 
				candidateModel.setFirstName(interview.getCandidate().getFirstName());
				candidateModel.setLastName(interview.getCandidate().getLastName());
				candidateModel.setPosition(interview.getCandidate().getPosition());
				candidateModel.setEmail(interview.getCandidate().getEmail());
				candidateModel.setPhoneNo(interview.getCandidate().getPhoneNo());
				candidateModel.setId(interview.getCandidate().getId());
				if (interview.getCandidate().getId() != null) {
					DocumentDetilsModel documentDetails = documentService.getFile(interview.getCandidate().getId());
					candidateModel.setDocumentDetails(documentDetails);
				}
				interviewModel.setCandidate(candidateModel);
			}
				interviewModel.setModifiedBy(interview.getModifiedBy());
				interviewModel.setStatus(interview.getStatus());
				interviewModel.setEmployee(interview.getEmployee());
				interviewModel.setSchduleDateTime(interview.getSchduleDateTime());
				interviewModel.setId(interview.getId());
				
				
				interviewAdd.add(interviewModel);
			}
			
			return interviewAdd;
		
	}

	public ResponseBean updateInterview(Long id, Interview interview) {
		try {
			Interview interviewSet = interviewRepo.findById(id).get();
			if (interview.getStatus().equals(Constants.InterviewSelected)) {
				candidateService.updateStatusCandidateSelected(interviewSet.getCandidate().getId(), true);
			}
			if (interview.getStatus().equals(Constants.InterviewRejected)) {
				candidateService.updateStatusCandidateSelected(interviewSet.getCandidate().getId(), false);
				interviewSet.setDeleteFlag(Constants.Y);
				
			}
			interviewSet.setModifiedDate(new Date());
			interviewSet.setModifiedBy(Constants.Admin);
		
			interviewSet.setStatus(interview.getStatus());
			interviewSet.setFeedback(interview.getFeedback());

			final Interview interviewUpdate = interviewRepo.save(interviewSet);
			return ResponseBean.generateResponse(HttpStatus.ACCEPTED, ResponseStatus.Success, interviewUpdate,
					"Interview Schedule Update Successfully");

		} catch (Exception e) {
			return ResponseBean.generateResponse(HttpStatus.ACCEPTED, ResponseStatus.Error, "Something went to wrong");

		}
		
	}

	public InterviewModel getByIdInterView(Long id) {
		Interview interview = interviewRepo.findById(id).get();
		
		CandidateModel candidateModel = new CandidateModel();
		InterviewModel interviewModel = new InterviewModel();
		candidateModel.setFirstName(interview.getCandidate().getFirstName());
		candidateModel.setLastName(interview.getCandidate().getLastName());
		candidateModel.setPosition(interview.getCandidate().getPosition());
		candidateModel.setEmail(interview.getCandidate().getEmail());
		candidateModel.setPhoneNo(interview.getCandidate().getPhoneNo());
		interviewModel.setId(interview.getId());
		interviewModel.setStatus(interview.getStatus());
		interviewModel.setCandidate(candidateModel);
		return interviewModel;
	}

	public Interview getById(Long id) {
		Interview interview = interviewRepo.findById(id).get();
		return interview;
	}

	public Interview checkStatusSelected(Long cadidateId) {

		return interviewRepo.checkStatusSelected(cadidateId);
	}

	public Interview getInterviewBycandidateId(Long candidateId) {
		Interview interview = interviewRepo.getInterviewBycandidateId(candidateId);
		return interview;
	}

	public ResponseBean updateInterviewResuchdule(Interview interviewget, Long candidateId, Long interviewId,
			Long employeeId) {
		try {
			Interview interview = getById(interviewId);
			boolean message = true;
			Candidate candidate = candidateService.getByIdCandidate(candidateId);
			interview.setCandidate(candidate);
			Employee employee = employeeService.getByIdEmployee(employeeId);
			interview.setEmployee(employee);
			
			interview.setStatus(interviewget.getStatus());
			interview.setFeedback(interviewget.getFeedback());
			interview.setSchduleDateTime(interviewget.getSchduleDateTime());
			interview.setModifiedDate(new Date());
			if (interviewget.getStatus().equals(Constants.InterviewSelected)) {
				candidateService.updateStatusCandidateSelected(interview.getCandidate().getId(), true);
				message = true;
			}
			if (interviewget.getStatus().equals(Constants.InterviewRejected)) {
				candidateService.updateStatusCandidateSelected(interview.getCandidate().getId(), false);
				interview.setDeleteFlag(Constants.Y);
				message = true;
			}
			if (interviewget.getStatus().equals(Constants.InterviewRescheduled)) {
				Integer conuter = interview.getInterviewCount();
				if (conuter == null) {
					conuter = 0;
					conuter++;
					interview.setInterviewCount(conuter);
				} else {

					conuter++;
					interview.setInterviewCount(conuter);

				}
			}
			final Interview interviewUpdate = interviewRepo.save(interview);
			if(interviewUpdate.getStatus().equals(Constants.InterviewRescheduled)) {
				candidateService.updateStatusCandidateReschduleInerview(interviewUpdate.getCandidate().getId(),true);
				interviewRescheduledHistoryService.saveResuduleInterview(interviewUpdate);
				message = false;
			}
			if (message) {
				return ResponseBean.generateResponse(HttpStatus.ACCEPTED, ResponseStatus.Success, interviewUpdate,
						"Interview Schedule Update Successfully");
			} else {
				return ResponseBean.generateResponse(HttpStatus.ACCEPTED, ResponseStatus.Success, interviewUpdate,
						"Interview ReScheduled Successfully");
			}
			
		} catch (Exception e) {
			return ResponseBean.generateResponse(HttpStatus.ACCEPTED, ResponseStatus.Error, "Something went to wrong");

		}
	}

	public List<InterviewModel> getAllInterviewList() {
		List<Interview> interviewList = interviewRepo.findAll();
		List<InterviewModel> interviewAdd = getInterviewDetils(interviewList);
		return interviewAdd;
	}

	public List<InterviewModel> getTommorowInterviewList() {
		List<Interview> interviewList = interviewRepo.getTommorowInterviewList();
		List<InterviewModel> interviewAdd = getInterviewDetils(interviewList);
		return interviewAdd;
	}

	public List<InterviewModel> getPreviousInterviewList() {
		List<Interview> interviewList = interviewRepo.getPreviousInterviewList();
		List<InterviewModel> interviewAdd = getInterviewDetils(interviewList);
		return interviewAdd;
	}

}