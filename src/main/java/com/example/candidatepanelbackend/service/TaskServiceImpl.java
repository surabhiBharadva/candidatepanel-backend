package com.example.candidatepanelbackend.service;


import java.util.List;

import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.example.candidatepanelbackend.repo.TaskRepository;
import com.example.candidatepanelbackend.responseModels.TaskModel;
import com.example.candidatepanelbackend.constants.ResponseStatus;
import com.example.candidatepanelbackend.entity.Task;
import com.example.candidatepanelbackend.utils.ResponseBean;

@Service
public class TaskServiceImpl implements TaskService {
	
	@Autowired
	private TaskRepository taskRepository;
	
	TaskModel convertDBObjectToResponseModel(Task task) {
		TaskModel model = new TaskModel();
		model.setName(task.getName());
		model.setId(task.getId());
		return model;
	}



	@Override
	public ResponseBean getTaskByProjectId(Integer projectId) {
		 List<Task> findByProductId = taskRepository.findByProjectId(projectId);
		return ResponseBean.generateResponse(HttpStatus.ACCEPTED, ResponseStatus.Success, findByProductId.stream().map(this::convertDBObjectToResponseModel).collect(Collectors.toList()),"Get All Tasks");
//		List<Task> findByProductId = taskRepository.findByProjectId(projectId);
//		return ResponseBean.generateResponse(HttpStatus.ACCEPTED, "Get All Product", null);
	}



	@Override
	public Task getTaskByTaskId(Integer taskId) {
		Optional<Task> task = taskRepository.findById(taskId);
		
		if(!task.isPresent()) {
			return null;
		}
		return task.get();
	}

}
