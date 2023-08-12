package com.example.candidatepanelbackend.service;

import java.io.FileNotFoundException;

import java.io.IOException;
import java.io.InputStream;


import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import com.example.candidatepanelbackend.entity.Candidate;
import com.example.candidatepanelbackend.entity.DocumentDetails;
import com.example.candidatepanelbackend.entity.Employee;
import com.example.candidatepanelbackend.responseModels.DocumentDetilsModel;
import com.example.candidatepanelbackend.utils.ResponseBean;

import jakarta.servlet.http.Part;

public interface DocumentService {

	Map<String, String> saveDocument(MultipartFile file,Candidate candidateObject);

	Map<String, String> saveDocument(MultipartFile file, Employee employee);
	
	Map<String, String> saveDocument(MultipartFile file,Integer request);

	Map<String, String> saveDocument(MultipartFile file);
	
	Object saveFile(MultipartFile file);
	
	DocumentDetilsModel getFile(Long candidateId);

	Map<String, String> saveDocument(Part part, InputStream inputStream, String contentType, Integer contentLength);

	Map<String, String> saveDocument(byte[] fileBytes);

	DocumentDetails getDocument(Long candidateId);
	
	ResponseEntity<org.springframework.core.io.Resource> getFile(String id) throws FileNotFoundException, IOException;

	ResponseBean editDocument(MultipartFile file, Long id);

}