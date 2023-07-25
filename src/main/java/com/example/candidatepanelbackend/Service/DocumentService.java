package com.example.candidatepanelbackend.Service;

import java.io.InputStream;

import java.util.Map;
import java.util.Optional;

import org.springframework.web.multipart.MultipartFile;

import com.example.candidatepanelbackend.Model.DocumentDetails;

import jakarta.servlet.http.Part;

public interface DocumentService {

	Map<String, String> saveDocument(MultipartFile file,Integer request);
	
	Map<String, String> saveDocument(MultipartFile file);
	
	Object saveFile(MultipartFile file);
	
	DocumentDetails getFile(Integer candidateId);

	Map<String, String> saveDocument(Part part, InputStream inputStream, String contentType, Integer contentLength);

	Map<String, String> saveDocument(byte[] fileBytes);

	DocumentDetails getDocument(Integer candidateId);
}