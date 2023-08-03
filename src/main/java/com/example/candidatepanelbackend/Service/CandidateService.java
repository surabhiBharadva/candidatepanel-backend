package com.example.candidatepanelbackend.Service;

import java.util.ArrayList;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.candidatepanelbackend.Enum.CandidateStatus;
import com.example.candidatepanelbackend.Enum.PositionEnum;
import com.example.candidatepanelbackend.Enum.ResponseStatus;
import com.example.candidatepanelbackend.Enum.StatusActionEnum;
import com.example.candidatepanelbackend.Model.Candidate;
import com.example.candidatepanelbackend.Model.CandidateModel;
import com.example.candidatepanelbackend.Model.DocumentDetilsModel;
import com.example.candidatepanelbackend.Model.Employee;
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
	
	

	public ResponseEntity<Object> saveCandidate(Candidate candidate, MultipartFile file) {
		
		String error  = validateCheck(candidate);
		candidate.setCreateDate(new Date());
		candidate.setCandidateDate(new Date());
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
		Boolean value2 = validationUtils.checkVeladationString(candidate.getCandidateName());
		if (value2) {
			error += "Candidate Name is missing," + " ";
		}
		if (validationUtils.checkVeladationString(candidate.getSkills())) {
			error += "Candidate Skills is missing," + " ";
		}

		if (validationUtils.checkVeladationLong(candidate.getPhone())) {
			error += "Candidate Phone Number is missing," + " ";
		}
		Boolean value = validationUtils.checkVeladationString(candidate.getEmail());
		if (value) {
			error += "Candidate Email is missing," + " ";
		}

		if (validationUtils.checkVeladationString(candidate.getFileUpload())) {
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

			candidate.setCandidateName(l.getCandidateName());
			candidate.setComment(l.getComment());
			candidate.setJoiningDate(l.getJoiningDate());
			candidate.setPhone(l.getPhone());
			candidate.setId(l.getId());
			candidate.setEmail(l.getEmail());
			candidate.setPosition(l.getPosition());
			candidate.setCandidateStatus(l.getCandidateStatus());
			candidate.setSkills(l.getSkills());
			candidate.setCandidateDate(l.getCandidateDate());
			candidate.setCandidateAvailability(l.getCandidateAvailability());
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
		candidateSet.setCandidateName(candidate.getCandidateName());
		candidateSet.setPhone(candidate.getPhone());
		candidateSet.setComment(candidate.getComment());
		candidateSet.setJoiningDate(candidate.getJoiningDate());
		candidateSet.setPosition(candidate.getPosition());
		candidateSet.setFileUpload(candidate.getFileUpload());
		candidateSet.setCandidateStatus(candidate.getCandidateStatus());
		if(candidateSet.getCandidateStatus().equals(CandidateStatus.OFFERREJECTED) || (candidateSet.getCandidateStatus().equals(CandidateStatus.INTERVIEWREJECTED))) {
			candidateSet.setDeleteFlag("Y");
		}
		if(candidateSet.getCandidateStatus().equals(CandidateStatus.OFFERACCEPTED)) {
			Employee employee = new Employee();
			employee.setFirstName(candidate.getCandidateName());
			employee.setjDate(candidate.getJoiningDate());
			employee.setPhone(candidate.getPhone());
			employee.setEmail(candidate.getEmail());
			employeeService.addEmployee(employee, null);
		}
		candidateSet.setSkills(candidate.getSkills());
		candidateSet.setModifiedDate(new Date());
		candidateSet.setCandidateAvailability(candidate.getCandidateAvailability());
        final Candidate candidateUpdate = candidateRepo.save(candidateSet);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(responseService.RespnseData("Candidate Update Successfully", candidateUpdate,ResponseStatus.Success));
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
			candidate.setCandidateName(l.getCandidateName());
			candidate.setId(l.getId());
			getList.add(candidate);
		}
		return getList;
	}

	public void updateStatus(Long id) {
		candidateRepo.updateStatus(id);
		
	}

}
