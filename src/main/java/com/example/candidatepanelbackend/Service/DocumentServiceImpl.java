package com.example.candidatepanelbackend.Service;

import java.io.IOException;

import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.unit.DataSize;
import org.springframework.web.multipart.MultipartFile;

import com.example.candidatepanelbackend.Model.Candidate;
import com.example.candidatepanelbackend.Model.DocumentDetails;
import com.example.candidatepanelbackend.Model.DocumentStorageProperty;
import com.example.candidatepanelbackend.Repo.DocumentRepository;

import jakarta.servlet.http.Part;

@Service
public class DocumentServiceImpl implements DocumentService {
	
	Logger logger = LoggerFactory.getLogger(DocumentServiceImpl.class);

	private final Path fileLocation;
	
	@Autowired
	DocumentRepository repository;
	
	@Autowired
	public DocumentServiceImpl(DocumentStorageProperty documentStorageProperty) {
		this.fileLocation = Paths.get(documentStorageProperty.getUploadDirectory()).toAbsolutePath().normalize();
		try {
			Files.createDirectories(this.fileLocation);
		} catch (IOException e) {
			logger.error(e.getMessage());
		}
	}

	@Override
	public Map<String, String> saveDocument(MultipartFile file, Integer id) {
		DocumentDetails entity = new DocumentDetails();

		if (file == null) {
			logger.error("File not Found...");
		}

		entity.setCandidateId(id);
		entity.setName(file.getOriginalFilename());
		try {
			entity.setFileData(file.getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		}
		entity.setType(file.getContentType());
		entity.setSize((double)(DataSize.ofBytes(file.getSize()).toMegabytes()));
		//entity.setStatus(Status.ACTIVE.getStatusValue());
		
		try {
			entity.setHash();
		} catch (NoSuchAlgorithmException e) {
			logger.error(e.getMessage());
		}
		
		//StoreDocument
		try {
			storeDocument(file, entity.getHash());
		} catch (IOException e) {
			logger.error(e.getMessage());
		}
		
		// Save in DB
		Map<String, String> response = new HashMap<>();
		DocumentDetails save = repository.save(entity);
		if(save.getId() != null) {
			response.put("response", "Thank You For Applying to Nexscend Technologies");
		}else {
			response.put("response", "Please select the valid file type");
		}
	    
		return response;
	}
	
	@Override
	public Map<String, String> saveDocument(MultipartFile file) {
		DocumentDetails entity = new DocumentDetails();

		if (file == null) {
			logger.error("File not Found...");
		}

		entity.setName(file.getOriginalFilename());
		try {
			entity.setFileData(file.getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		}
		entity.setType(file.getContentType());
		entity.setSize((double)(DataSize.ofBytes(file.getSize()).toMegabytes()));
		//entity.setStatus(Status.ACTIVE.getStatusValue());
		
		try {
			entity.setHash();
		} catch (NoSuchAlgorithmException e) {
			logger.error(e.getMessage());
		}
		
		//StoreDocument
		try {
			storeDocument(file, entity.getHash());
		} catch (IOException e) {
			logger.error(e.getMessage());
		}
		
		// Save in DB
		Map<String, String> response = new HashMap<>();
		DocumentDetails save = repository.save(entity);
		if(save.getId() != null) {
			response.put("response", "Thank You For Applying to Nexscend Technologies");
		}else {
			response.put("response", "Please select the valid file type");
		}
	    
		return response;
	}
	private void storeDocument(InputStream inputStream, String hash) throws IOException {
		
		if (this.fileLocation != null) {
			logger.info("File save at Location " + this.fileLocation);

			Path targetLocation = this.fileLocation.resolve(hash);
			Files.copy(inputStream, targetLocation);
		} else {
			logger.info("File is not saved in local system, because not provided the path in property file");
		}
	}
	
private void storeDocument(MultipartFile file, String hash) throws IOException {
		
		if (this.fileLocation != null) {
			logger.info("File save at Location " + this.fileLocation);

			Path targetLocation = this.fileLocation.resolve(hash);
			Files.copy(file.getInputStream(), targetLocation);
		} else {
			logger.info("File is not saved in local system, because not provided the path in property file");
		}
	}

	@Override
	public Object saveFile(MultipartFile uplodedFile) {

		DocumentDetails file = new DocumentDetails();

		file.setName(uplodedFile.getOriginalFilename());
		
		try {
			file.setFileData(uplodedFile.getBytes());
		} catch (IOException e) {
			logger.error(e.getMessage());
		}
		
		file.setType(uplodedFile.getContentType());

		// Save in DB
		Map<String, String> response = new HashMap<>();
		DocumentDetails save = repository.save(file);
		
		if(save.getId() != null) {
			response.put("response", "File Uploded Succesfully");
		}else {
			response.put("response", "Data base  connections issue found");
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
		}
	    
		return response;
	}
	
	
	public DocumentDetails getFile(Integer candidateId) {
		
		
		DocumentDetails documents = repository.findByIdFile(candidateId);
		DocumentDetails documentModel = new DocumentDetails();

		if (documents != null) {
			
			documentModel.setName(documents.getName());
			documentModel.setFileData(documents.getFileData());
		}
		return documentModel;
	}

	@Override
	public Map<String, String> saveDocument(Part part,InputStream inputStream, String contentType, Integer contentLength) {
		DocumentDetails entity = new DocumentDetails();
		
		byte[] bytes = new byte[contentLength];
		int data;
		int i = 0;
        try {
			while ((data = inputStream.read()) != -1) {
					bytes[i] = (byte) data;
					i++;
			}
		} catch (IOException e) {
			System.err.println(e.getMessage());
		}
        
		String fileName = part.getSubmittedFileName();
		
		entity.setName(fileName);
		entity.setFileData(bytes);
		entity.setType(contentType);
		entity.setSize((double) DataSize.ofBytes((bytes.length)).toMegabytes());
		//entity.setStatus(Status.ACTIVE.getStatusValue());

		try {
			entity.setHash();
		} catch (NoSuchAlgorithmException e) {
			logger.error(e.getMessage());
		}

		// StoreDocument
		try {
			storeDocument(inputStream, entity.getHash());
		} catch (IOException e) {
			logger.error(e.getMessage());
		}

		// Save in DB
		Map<String, String> response = new HashMap<>();
		DocumentDetails save = repository.save(entity);
		if (save.getId() != null) {
			response.put("response", "Thank You For Applying to Nexscend Technologies");
		} else {
			response.put("response", "Please select the valid file type");
		}

		return response;
	}

	private String getFileName(Part part) {
		String contentDispositionHeader = part.getHeader("content-disposition");
		String[] elements = contentDispositionHeader.split(";");
		for (String element : elements) {
			if (element.trim().startsWith("filename")) {
				return element.substring(element.indexOf('=') + 1).trim().replace("\"", "");
			}
		}
		return null;
	}

	@Override
	public Map<String, String> saveDocument(byte[] fileBytes) {
		DocumentDetails entity = new DocumentDetails();
		entity.setFileData(fileBytes);
		
		Map<String, String> response = new HashMap<>();
		DocumentDetails save = repository.save(entity);
		if (save.getId() != null) {
			response.put("response", "Thank You For Applying to Nexscend Technologies");
		} else {
			response.put("response", "Please select the valid file type");
		}
		
		return response;
	}

	public DocumentDetails getDocument(Integer candidateId) {
		
		
		DocumentDetails docuOptional = repository.findById(candidateId).get();
		return docuOptional;
		
	}


}
