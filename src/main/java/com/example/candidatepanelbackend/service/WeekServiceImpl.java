package com.example.candidatepanelbackend.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.example.candidatepanelbackend.repo.WeekRepository;
import com.example.candidatepanelbackend.responseModels.TimeSheetModel;

@Service
public class WeekServiceImpl implements WeekService {
	
	@Autowired
	private WeekRepository weekRepository;

	@Override
	public void insertRecord(TimeSheetModel request) {
		
	}
	
	
	
}
