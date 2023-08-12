package com.example.candidatepanelbackend.service;


import java.util.List;

import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.example.candidatepanelbackend.constants.ResponseStatus;
import com.example.candidatepanelbackend.entity.Project;
import com.example.candidatepanelbackend.responseModels.ProjectModel;
import com.example.candidatepanelbackend.utils.ResponseBean;

@Service
public class ProjectServiceImpl implements ProjectService {
	
	@Autowired
	private com.example.candidatepanelbackend.repo.ProjectRepository productRepository;
	
	@Override
	public ResponseBean getProduct() {
		List<Project> products = productRepository.findAll();
		return ResponseBean.generateResponse(HttpStatus.ACCEPTED, ResponseStatus.Success, products.stream().map(this::convertDBObjectToResponseModel).collect(Collectors.toList()),"Get all Products");
	}
	
	ProjectModel convertDBObjectToResponseModel(Project product) {
		ProjectModel model = new ProjectModel();
		model.setName(product.getName());
		model.setId(product.getId());
		return model;
	}

	@Override
	public Project getProjectById(Integer productId) {
		Optional<Project> project = productRepository.findById(productId);
		if(!project.isPresent()) {
			return null;
		}
		return project.get();
	}

}
