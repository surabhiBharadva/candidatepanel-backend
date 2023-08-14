package com.example.candidatepanelbackend.service;



import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.example.candidatepanelbackend.entity.Candidate;
import com.example.candidatepanelbackend.responseModels.CandidateModel;
import com.example.candidatepanelbackend.utils.ResponseBean;

import lombok.AllArgsConstructor;


public interface CandidateService {

	ResponseBean updateCandidate(Long id, Candidate candidateObject, MultipartFile file);

	ResponseBean saveCandidate(Candidate candidateObject, MultipartFile file);

	List<CandidateModel> getCandidate();

	List<CandidateModel> getCandidatePendingInterview();

	CandidateModel getByIdCandidateWithDocumentDeitals(Long id);

	Candidate getByIdCandidate(Long candidateId);

	CandidateModel getCadidateByIdView(Long id);

	void updateStatusCandidate(Long id, String status);
	

}
