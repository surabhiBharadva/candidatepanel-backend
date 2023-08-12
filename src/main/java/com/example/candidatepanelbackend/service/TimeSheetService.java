package com.example.candidatepanelbackend.service;

import com.example.candidatepanelbackend.responseModels.TimeSheetModel;
import com.example.candidatepanelbackend.utils.ResponseBean;

public interface TimeSheetService {

	ResponseBean addOrUpdate(TimeSheetModel request, Integer id);

	ResponseBean getLastSyncDate(Integer employeeId);

	
}