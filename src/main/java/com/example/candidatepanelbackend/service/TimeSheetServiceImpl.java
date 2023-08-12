package com.example.candidatepanelbackend.service;

import java.util.Date;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.example.candidatepanelbackend.constants.Constants;
import com.example.candidatepanelbackend.constants.ResponseStatus;
import com.example.candidatepanelbackend.repo.TimeSheetRepository;
import com.example.candidatepanelbackend.responseModels.TimeSheetModel;
import com.example.candidatepanelbackend.entity.Project;
import com.example.candidatepanelbackend.entity.Task;
import com.example.candidatepanelbackend.entity.TimeSheet;
import com.example.candidatepanelbackend.utils.ResponseBean;

@Service
public class TimeSheetServiceImpl implements TimeSheetService {

	@Autowired
	private TimeSheetRepository timeSheetRepository;

	@Autowired
	private ProjectService projectService;

	@Autowired
	private TaskService taskService;

	@Override
	public ResponseBean addOrUpdate(TimeSheetModel request, Integer id) {

		if (id == null) {
			return addTimeSheet(request);
		} else {
			return updateTimeSheet(request, id);
		}

	}

	private ResponseBean updateTimeSheet(TimeSheetModel request, Integer id) {
		if (request == null) {
			return ResponseBean.generateResponse(HttpStatus.BAD_REQUEST, ResponseStatus.Error,
					"Missing mandatory fields");
		}

		Optional<TimeSheet> timeSheet = timeSheetRepository.findById(id);
		if (!timeSheet.isPresent()) {
			TimeSheet timeSheetDb = new TimeSheet();
			TimeSheet timeSheetObject = timeSheet.get();

			if (request.getProject() != null && request.getTask() != null) {
				getProjectAndTask(request.getProject(), request.getTask(), timeSheetDb);
			}
			
			if(request.getHours() != null) {
				timeSheetDb.setHours(request.getHours());
			} else {
				timeSheetDb.setHours(timeSheetObject.getHours());
			}
			
			if(request.getDate() != null) {
				timeSheetDb.setDate(null);
			}
		}

		return null;
	}

	private ResponseBean addTimeSheet(TimeSheetModel request) {

		if (request == null) {
			return ResponseBean.generateResponse(HttpStatus.BAD_REQUEST, ResponseStatus.Error,
					"Missing mandatory fields");
		}

		// For Store Db
		TimeSheet timeSheet = new TimeSheet();

		getProjectAndTask(request.getProject(), request.getTask(), timeSheet);

		timeSheet.setDate(request.getDate());
		timeSheet.setHours(request.getHours());
		timeSheet.setEmployeeId(request.getEmployeeId());
		
		timeSheet.setCreatedBy(Constants.Admin);
		timeSheet.setModifiedBy(Constants.Admin);
		timeSheet.setCreatedDate(new Date());
		timeSheet.setModifiedDate(new Date());

		timeSheetRepository.save(timeSheet);
		return ResponseBean.generateResponse(HttpStatus.CREATED, ResponseStatus.Success,
				"Time Sheet Added Succesfully");
	}

	private void getProjectAndTask(Integer projectId, Integer taskId, TimeSheet timeSheet) {
		Project project = projectService.getProjectById(projectId);
		Task task = taskService.getTaskByTaskId(taskId);

		if (project != null) {
			timeSheet.setProjectName(project.getName());
		}

		if (task != null) {
			timeSheet.setTaskName(task.getName());
		}
	}

	@Override
	public ResponseBean getLastSyncDate(Integer employeeId) {
//		List<TimeSheet> timeSheet = timeSheetRepository.findByEmployeeId(employeeId);

//		if (timeSheet != null) {
//			return ResponseBean.generateResponse(HttpStatus.ACCEPTED, ResponseStatus.Success, timeSheet.get(0).getDate());
//		}
//		return ResponseBean.generateResponse(HttpStatus.BAD_REQUEST, ResponseStatus.Error, null);
	return null;
	}

}
