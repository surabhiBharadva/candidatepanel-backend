package com.example.candidatepanelbackend.service;

import com.example.candidatepanelbackend.responseModels.TimeSheetModel;

public interface WeekService {
	
	void insertRecord(TimeSheetModel request);
}