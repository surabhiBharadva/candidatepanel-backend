package com.example.candidatepanelbackend.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.candidatepanelbackend.Enum.CandidateStatus;
import com.example.candidatepanelbackend.Enum.StatusActionEnum;
import com.example.candidatepanelbackend.Model.Candidate;
import com.example.candidatepanelbackend.Model.CandidateModel;
import com.example.candidatepanelbackend.Model.DocumentDetilsModel;
import com.example.candidatepanelbackend.Repo.CandidateRepo;


import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CandidateService {
	
	@Autowired 
	private CandidateRepo candidateRepo;
	
	@Autowired 
	private DocumentService documentService;

	public Candidate saveCandidate(Candidate candidate, MultipartFile file) {
		
		if(candidate.getPosition() != null) {
		candidate.setPosition(candidate.getPosition());
		
		}
		candidate.setCreateDate(new Date());
		candidate.setCandidateDate(new Date());
		Candidate candidateObject = candidateRepo.save(candidate);
		if(file != null) {
			documentService.saveDocument(file,candidateObject.getId().intValue());
		}
		return candidateObject;
	}

	public List<CandidateModel> getCandidate() {
		List<Candidate> list = candidateRepo.findAll();
		//List<Candidate> list = candidateRepo.findCandidate();
		List<CandidateModel> getList = new ArrayList<CandidateModel>();
		for (Candidate l : list) {
			CandidateModel candidate = new CandidateModel();
			if (l.getId() != null) {
				DocumentDetilsModel documentDetails = documentService.getFile(l.getId().intValue());
				candidate.setDocumentDetails(documentDetails);
			}

			candidate.setCandidateName(l.getCandidateName());
			candidate.setComment(l.getComment());
			candidate.setjDate(l.getjDate());
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

	public Candidate updateCandidate(Long id, Candidate candidate) {
		Candidate candidateSet = candidateRepo.findById(id).get();
		
		candidateSet.setEmail(candidate.getEmail());
		candidateSet.setCandidateName(candidate.getCandidateName());
		candidateSet.setPhone(candidate.getPhone());
		candidateSet.setComment(candidate.getComment());
		candidateSet.setjDate(candidate.getjDate());
		candidateSet.setPosition(candidate.getPosition());
		candidateSet.setFileUpload(candidate.getFileUpload());
		candidateSet.setCandidateStatus(candidate.getCandidateStatus());
		if(candidateSet.getCandidateStatus().equals(CandidateStatus.offerRejected) || (candidateSet.getCandidateStatus().equals(CandidateStatus.InterviewRejected))) {
			candidateSet.setStatus(StatusActionEnum.InAnctive);
		}
		candidateSet.setSkills(candidate.getSkills());
		candidateSet.setModifiedDate(new Date());
		candidateSet.setCandidateAvailability(candidate.getCandidateAvailability());
        final Candidate candidateUpdate = candidateRepo.save(candidateSet);
		return candidateUpdate;
	}

	public Candidate getByIdCandidate(Long id) {
		Candidate candidate = candidateRepo.findById(id).get();
		return candidate;
	}

}
