package com.example.candidatepanelbackend.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.candidatepanelbackend.Enum.CandidateStatus;
import com.example.candidatepanelbackend.Enum.PositionEnum;
import com.example.candidatepanelbackend.Model.Candidate;
import com.example.candidatepanelbackend.Model.CandidateModel;
import com.example.candidatepanelbackend.Model.DocumentDetails;
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
		Candidate candidateObject = candidateRepo.save(candidate);
		if(file != null) {
			documentService.saveDocument(file,candidateObject.getId().intValue());
		}
		return candidateObject;
	}

	public List<CandidateModel> getCandidate() {
		
		List<Candidate> list = candidateRepo.findAll();
		List<CandidateModel> getList = new ArrayList<CandidateModel>();
		for (Candidate l : list) {
			CandidateModel candidate = new CandidateModel();
			if (l.getId() != null) {
				DocumentDetilsModel documentDetails = documentService.getFile(l.getId().intValue());
				candidate.setDocumentDetails(documentDetails);
			}

			candidate.setLname(l.getLname());
			candidate.setFirstName(l.getFirstName());
			candidate.setComment(l.getComment());
			candidate.setjDate(l.getjDate());
			candidate.setPhone(l.getPhone());
			candidate.setId(l.getId());
			candidate.setEmail(l.getEmail());
			candidate.setPosition(l.getPosition());
			candidate.setStatus(l.getStatus());
			getList.add(candidate);
		}

		return getList;
		
	}

	public Candidate updateCandidate(Long id, Candidate candidate) {
		Candidate candidateSet = candidateRepo.findById(id).get();
		
		candidateSet.setEmail(candidate.getEmail());
		candidateSet.setLname(candidate.getLname());
		candidateSet.setFirstName(candidate.getFirstName());
		candidateSet.setPhone(candidate.getPhone());
		candidateSet.setComment(candidate.getComment());
		candidateSet.setjDate(candidate.getjDate());
		candidateSet.setPosition(candidate.getPosition());
		candidateSet.setFileUpload(candidate.getFileUpload());
		candidateSet.setStatus(candidate.getStatus());
		candidateSet.setSkills(candidate.getSkills());
        final Candidate candidateUpdate = candidateRepo.save(candidateSet);
		return candidateUpdate;
	}

	public Candidate getByIdCandidate(Long id) {
		Candidate candidate = candidateRepo.findById(id).get();
		return candidate;
	}

}
