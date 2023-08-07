package com.example.candidatepanelbackend.Service;

import java.util.ArrayList;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.candidatepanelbackend.Constants.Constants;
import com.example.candidatepanelbackend.Enum.ResponseStatus;
import com.example.candidatepanelbackend.Model.Candidate;
import com.example.candidatepanelbackend.Model.CandidateModel;
import com.example.candidatepanelbackend.Model.DocumentDetilsModel;
import com.example.candidatepanelbackend.Model.Employee;
import com.example.candidatepanelbackend.Model.Interview;
import com.example.candidatepanelbackend.Repo.CandidateRepo;
import com.example.candidatepanelbackend.utils.ValidationsUtilsString;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CandidateService {
	
	@Autowired 
	private CandidateRepo candidateRepo;
	
	@Autowired 
	private DocumentService documentService;
	
	@Autowired 
	private EmployeeService employeeService;
	
	@Autowired
	private ValidationsUtilsString validationUtils;
	
	@Autowired 
	private ResponseService responseService;
	
	@Autowired
	private InterviewService interviewService;
	
	

	public ResponseEntity<Object> saveCandidate(Candidate candidate, MultipartFile file) {
		
		String error  = validateCheck(candidate);
		candidate.setCandidateStatus(Constants.UnderScreening);
		candidate.setCreateDate(new Date());
		candidate.setCreateBy("Admin");
		candidate.setModifiedBy("Admin");
		candidate.setModifiedDate(new Date());
		candidate.setApplicationDate(new Date());
	
		Candidate candidateObject = candidateRepo.save(candidate);
		if(file != null) {
			documentService.saveDocument(file,candidateObject.getId().intValue());
		}
		if(!error.isEmpty()) {
			 return ResponseEntity.status(HttpStatus.ACCEPTED).body(responseService.RespnseData(error,ResponseStatus.Error));
		}
		 return ResponseEntity.status(HttpStatus.ACCEPTED).body(responseService.RespnseData("Candidate add Successfully", candidateObject,ResponseStatus.Success));
	}

	private String validateCheck(Candidate candidate) {
		String error = "";
		Boolean value2 = validationUtils.checkVeladationString(candidate.getFirstName());
		if (value2) {
			error += "Candidate Name is missing," + " ";
		}
		if (validationUtils.checkVeladationString(candidate.getSkills())) {
			error += "Candidate Skills is missing," + " ";
		}

		if (validationUtils.checkVeladationLong(candidate.getPhoneNo())) {
			error += "Candidate Phone Number is missing," + " ";
		}
		Boolean value = validationUtils.checkVeladationString(candidate.getEmail());
		if (value) {
			error += "Candidate Email is missing," + " ";
		}

		if (validationUtils.checkVeladationString(candidate.getResume())) {
			error += "Candidate File Upload is missing," + " ";
		}

		return error;
	}

	public List<CandidateModel> getCandidate() {
		//List<Candidate> list = candidateRepo.findAll();
		List<Candidate> list = candidateRepo.findCandidate();
		List<CandidateModel> getList = new ArrayList<CandidateModel>();
		for (Candidate l : list) {
			CandidateModel candidate = new CandidateModel();
			if (l.getId() != null) {
				DocumentDetilsModel documentDetails = documentService.getFile(l.getId().intValue());
				candidate.setDocumentDetails(documentDetails);
			}
			candidate.setFirstName(l.getFirstName());
			candidate.setLastName(l.getLastName());
			candidate.setComment(l.getComment());
			candidate.setJoiningDate(l.getJoiningDate());
			candidate.setPhoneNo(l.getPhoneNo());
			candidate.setId(l.getId());
			candidate.setEmail(l.getEmail());
			candidate.setPosition(l.getPosition());
			candidate.setCandidateStatus(l.getCandidateStatus());
			candidate.setSkills(l.getSkills());
			candidate.setApplicationDate(l.getApplicationDate());
			candidate.setJoiningAvailability(l.getJoiningAvailability());
			getList.add(candidate);
		}

		return getList;
		
	}

	public ResponseEntity<Object> updateCandidate(Long id, Candidate candidate) {
		String error = validateCheck(candidate);
		if(!error.isEmpty()) {
			 return ResponseEntity.status(HttpStatus.ACCEPTED).body(responseService.RespnseData(error,ResponseStatus.Error));
		}
		
		Candidate candidateSet = candidateRepo.findById(id).get();
		
		candidateSet.setEmail(candidate.getEmail());
		candidateSet.setFirstName(candidate.getFirstName());
		candidateSet.setLastName(candidate.getLastName());
		candidateSet.setPhoneNo(candidate.getPhoneNo());
		candidateSet.setComment(candidate.getComment());
		candidateSet.setJoiningDate(candidate.getJoiningDate());
		candidateSet.setModifiedBy("Admin");
		candidateSet.setPosition(candidate.getPosition());
		candidateSet.setResume(candidate.getResume());
		candidateSet.setCandidateStatus(candidate.getCandidateStatus());
		if(candidateSet.getCandidateStatus().equals(Constants.Rejected) || (candidateSet.getCandidateStatus().equals(Constants.OfferRejected))) {
			candidateSet.setDeleteFlag("Y");
		}
		if (candidateSet.getCandidateStatus().equals(Constants.OfferAccepted)) {
		Interview interview = interviewService.checkStatusSelected(candidate.getId());
			if (interview != null) {

				Employee employee = new Employee();
				employee.setFirstName(candidate.getFirstName());
				employee.setLastName(candidate.getLastName());
				employee.setJoiningDate(candidate.getJoiningDate());
				employee.setCreateDate(new Date());
				employee.setModifiedDate(new Date());
				employee.setPhone(candidate.getPhoneNo());
				employee.setEmail(candidate.getEmail());
				employeeService.addEmployee(employee, null);
			}else {
				 return ResponseEntity.status(HttpStatus.ACCEPTED).body(responseService.RespnseData("Interviewer Status in Selected",ResponseStatus.Error));
			}

		}
		candidateSet.setSkills(candidate.getSkills());
		candidateSet.setModifiedDate(new Date());
		candidateSet.setJoiningAvailability(candidate.getJoiningAvailability());
		
		final Candidate candidateUpdate = candidateRepo.save(candidateSet);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(
				responseService.RespnseData("Candidate Update Successfully", candidateUpdate, ResponseStatus.Success));
	}

	public Candidate getByIdCandidate(Long id) {
		Candidate candidate = candidateRepo.findById(id).get();
		return candidate;
	}

	public List<CandidateModel> getCandidatePendingInterview() {
		List<Candidate> list = candidateRepo.getCandidatePendingInterview();
		List<CandidateModel> getList = new ArrayList<CandidateModel>();
		for (Candidate l : list) {
			CandidateModel candidate = new CandidateModel();
			candidate.setFirstName(l.getFirstName());
			candidate.setLastName(l.getLastName());
			candidate.setId(l.getId());
			getList.add(candidate);
		}
		return getList;
	}

	public void updateStatus(Long id) {
		candidateRepo.updateStatus(id);
		
	}

	public void updateStatusCandidateSelected(Long id, boolean update) {
		if (update) {
			candidateRepo.updateStatusCandidateSelected(id);
		} else {
			candidateRepo.updateStatusCandidateRejected(id);
		}
	}

}
