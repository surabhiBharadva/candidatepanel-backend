package com.example.candidatepanelbackend.Service;

import com.example.candidatepanelbackend.ResponseModels.TimeSheetModel;
import com.example.candidatepanelbackend.utils.ResponseBean;

public interface TimeSheetService {

	ResponseBean addOrUpdate(TimeSheetModel request, Integer id);

	ResponseBean getLastSyncDate(Integer employeeId);

	
}