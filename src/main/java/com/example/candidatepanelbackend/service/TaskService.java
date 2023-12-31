package com.example.candidatepanelbackend.service;


import com.example.candidatepanelbackend.entity.Task;
import com.example.candidatepanelbackend.utils.ResponseBean;

public interface TaskService {

	ResponseBean getTaskByProjectId(Integer projectId);
	
	Task getTaskByTaskId(Integer taskId);
	
}