package com.example.candidatepanelbackend.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.candidatepanelbackend.Model.DocumentDetails;
import com.example.candidatepanelbackend.Service.DocumentService;



@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/")
public class DocumentController {
	
	@Autowired DocumentService documentService;
	
	@GetMapping("/document/{id}")
	private ResponseEntity<DocumentDetails> getDocument(@PathVariable Integer candidateId){
		DocumentDetails candidateSave = documentService.getDocument(candidateId);
		return new ResponseEntity<>(candidateSave, HttpStatus.CREATED);
	}

}
