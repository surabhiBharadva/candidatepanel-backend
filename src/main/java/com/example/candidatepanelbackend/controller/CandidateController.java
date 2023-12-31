package com.example.candidatepanelbackend.controller;

import java.io.IOException;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.candidatepanelbackend.constants.ResponseStatus;
import com.example.candidatepanelbackend.service.CandidateService;
import com.example.candidatepanelbackend.service.DocumentService;
import com.example.candidatepanelbackend.utils.ResponseBean;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.example.candidatepanelbackend.entity.Candidate;
import com.example.candidatepanelbackend.responseModels.CandidateModel;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/")
public class CandidateController {

	@Autowired
	private CandidateService candidateService;

	@Autowired
	ObjectMapper mapper;
	
	@Autowired
	private DocumentService documentService;

	@PostMapping("/candidate")
	private ResponseBean saveCandidate(@RequestParam("candidate") String candidate,
			@RequestParam(value = "file", required = false) MultipartFile file)
			throws JsonMappingException, JsonProcessingException {
		Candidate candidateObject = mapper.readValue(candidate, Candidate.class);
		try {
			if (candidateObject.getId() != null) {
				return candidateService.updateCandidate(candidateObject.getId(), candidateObject, file);
			} else {
				return candidateService.saveCandidate(candidateObject, file);
			}
		} catch (Exception e) {
			return ResponseBean.generateResponse(HttpStatus.ACCEPTED, ResponseStatus.Error, "Something went wrongs",
					ResponseStatus.Error);

		}
	}

	@GetMapping("/candidate")
	private ResponseEntity<List<CandidateModel>> getCandidate() {
		List<CandidateModel> candidateList = candidateService.getCandidate();
		return new ResponseEntity<>(candidateList, HttpStatus.OK);
	}
	
	@GetMapping("/candidate/candidateList")
	private ResponseEntity<List<CandidateModel>> getCandidatePendingInterview() {
		List<CandidateModel> candidateList = candidateService.getCandidatePendingInterview();
		return new ResponseEntity<>(candidateList, HttpStatus.OK);
	}


	@PutMapping("/candidate/{id}")
	private ResponseBean updateCandidate(@PathVariable Long id,@RequestParam("file") MultipartFile file) throws JsonMappingException, JsonProcessingException{
		Candidate candidateObject = mapper.readValue("", Candidate.class);
		try {
			return candidateService.updateCandidate(id, candidateObject,file);
		} catch (Exception e) {
			return ResponseBean.generateResponse(HttpStatus.ACCEPTED,ResponseStatus.Error,"Something went wrong",ResponseStatus.Error);
			
		}

	}

	@GetMapping("/candidate/{id}")
	private ResponseEntity<CandidateModel> getByIdCandidate(@PathVariable Long id) {
		CandidateModel candidateSave = candidateService.getByIdCandidateWithDocumentDeitals(id);
		return new ResponseEntity<>(candidateSave, HttpStatus.CREATED);
	}
	
	@GetMapping("/candidate/download/{fileName}")
	ResponseEntity<org.springframework.core.io.Resource> downloadFile(@PathVariable("fileName") String fileName)
			throws IOException {
		return documentService.getFile(fileName);

	}
	@GetMapping("/candidate/candidateview/{id}")
	private ResponseEntity<CandidateModel> getCadidateByIdView(@PathVariable Long id) {
		CandidateModel candidateSave = candidateService.getCadidateByIdView(id);
		return new ResponseEntity<>(candidateSave, HttpStatus.CREATED);
	}
	
	@GetMapping("/candidate/candidateStatus/{status}")
	private ResponseEntity<List<CandidateModel>> getStatusList(@PathVariable("status") String status) {
		List<CandidateModel> candidateList = candidateService.getStatusList(status);
		return new ResponseEntity<>(candidateList, HttpStatus.OK);
	}
}
