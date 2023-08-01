package com.example.candidatepanelbackend.Controller;

import java.sql.SQLDataException;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
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
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.candidatepanelbackend.Model.Candidate;
import com.example.candidatepanelbackend.Model.CandidateModel;
import com.example.candidatepanelbackend.Service.CandidateService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.example.candidatepanelbackend.Service.ResponseService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/")
public class CandidateController {

	@Autowired
	private CandidateService candidateService;

	@Autowired
	ObjectMapper mapper;

	@Autowired
	private ResponseService responseService;

	@PostMapping("/candidate")
	private ResponseEntity<Object> saveCandidate(@RequestParam("candidate") String candidate,
			@RequestParam("file") MultipartFile file) throws JsonMappingException, JsonProcessingException {
		Candidate candidateObject = mapper.readValue(candidate, Candidate.class);
		try {
			return candidateService.saveCandidate(candidateObject, file);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE)
					.body(responseService.RespnseData("Candidate Alredy exits"));
		}
	}

	@GetMapping("/candidate")
	private ResponseEntity<List<CandidateModel>> getCandidate() {
		List<CandidateModel> candidateList = candidateService.getCandidate();
		return new ResponseEntity<>(candidateList, HttpStatus.OK);
	}

	@PutMapping("/candidate/{id}")
	private ResponseEntity<Object> updateCandidate(@PathVariable Long id, @RequestBody Candidate candidate) {
		try {
			return candidateService.updateCandidate(id, candidate);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE)
					.body(responseService.RespnseData("Candidate Alredy exits"));
		}

	}

	@GetMapping("/candidate/{id}")
	private ResponseEntity<Candidate> getByIdCandidate(@PathVariable Long id) {
		Candidate candidateSave = candidateService.getByIdCandidate(id);
		return new ResponseEntity<>(candidateSave, HttpStatus.CREATED);
	}

}
