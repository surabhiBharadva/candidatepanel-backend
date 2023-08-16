package com.example.candidatepanelbackend.service;

import java.util.List;


import com.example.candidatepanelbackend.responseModels.TimeSheetModel;
import com.example.candidatepanelbackend.entity.TimeSheet;
import com.example.candidatepanelbackend.utils.ResponseBean;

public interface TimeSheetService {

	ResponseBean addOrUpdate(TimeSheetModel request, Integer id);

	ResponseBean getLastSyncDate(Integer employeeId);

	List<TimeSheet> getHourOfWeek(Long employeeId, String startDate, String endDate);
	

	
}