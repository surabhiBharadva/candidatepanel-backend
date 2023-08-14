package com.example.candidatepanelbackend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.candidatepanelbackend.constants.Constants;
import com.example.candidatepanelbackend.entity.ConfigDataMaster;
import com.example.candidatepanelbackend.repo.ConfigDataMasterRepo;
import com.example.candidatepanelbackend.repo.ConfigDataMasterValuesRepo;
import com.example.candidatepanelbackend.utils.ResponseBean;

@Service
public class ConfigDataMasterServiceImpl implements ConfigDataMasterService {
	
	@Autowired 
	private ConfigDataMasterRepo configDataMasterRepo;
	
	@Autowired ConfigDataMasterValuesService  configDataMasterValuesService;


	@Override
	public ResponseBean candidateStatus() {
		List<ConfigDataMaster> configData = configDataMasterRepo.findAll();
		for (ConfigDataMaster configDataMaster : configData) {
			if (configDataMaster.getConfigName().equals(Constants.CandidateStatus)) {
				return configDataMasterValuesService.getCnadidateStatus(configDataMaster.getId());
			}
		}
		return null;
	}

}
