package com.example.candidatepanelbackend.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.example.candidatepanelbackend.entity.ConfigDataMasterValues;
import com.example.candidatepanelbackend.repo.ConfigDataMasterValuesRepo;
import com.example.candidatepanelbackend.responseModels.ConfigDataMasterValuesModel;
import com.example.candidatepanelbackend.utils.ResponseBean;
import com.example.candidatepanelbackend.constants.Constants;
import com.example.candidatepanelbackend.constants.ResponseStatus;

@Service
public class ConfigDataMasterValuesImpl implements ConfigDataMasterValuesService{

	
	@Autowired
	private ConfigDataMasterValuesRepo  configDataMasterValuesRepo;
	
	@Override
	public ResponseBean getCandidateStatus() {
		List<ConfigDataMasterValuesModel> list = new ArrayList<ConfigDataMasterValuesModel>();
		List<ConfigDataMasterValues> candidateList = configDataMasterValuesRepo.findAll();
		if(candidateList != null) {
		for (ConfigDataMasterValues configDataMasterValues : candidateList) {
			if (configDataMasterValues.getConfigDataMaster().getConfigCode().equals(Constants.CandidateStatus)) {
				ConfigDataMasterValuesModel configDataMasterValuesModel = new ConfigDataMasterValuesModel();
				configDataMasterValuesModel.setId(configDataMasterValues.getId());
				configDataMasterValuesModel.setConfigValue(configDataMasterValues.getConfigValue());
				configDataMasterValuesModel.setConfigKey(configDataMasterValues.getConfigKey());
				list.add(configDataMasterValuesModel);
			}
		}
		}
		return ResponseBean.generateResponse(HttpStatus.ACCEPTED,ResponseStatus.Success,list);
	}

	@Override
	public ResponseBean getCnadidateStatus(Long id) {
		List<ConfigDataMasterValues> configDataMasterValues = configDataMasterValuesRepo.findCandidateStatus(id);
		return ResponseBean.generateResponse(HttpStatus.ACCEPTED,ResponseStatus.Success,configDataMasterValues);
	}

	@Override
	public ConfigDataMasterValues getValuebyKey(String Status,String candidateStatus) {
		return configDataMasterValuesRepo.getValuebyKey(Status,candidateStatus);
	}

	@Override
	public ResponseBean interviewStatus() {
		List<ConfigDataMasterValuesModel> list = new ArrayList<ConfigDataMasterValuesModel>();
		List<ConfigDataMasterValues> candidateList = configDataMasterValuesRepo.findAll();
		for (ConfigDataMasterValues configDataMasterValues : candidateList) {
			if (configDataMasterValues.getConfigDataMaster().getConfigCode().equals(Constants.InterviewStatus)) {
				ConfigDataMasterValuesModel configDataMasterValuesModel = new ConfigDataMasterValuesModel();
				configDataMasterValuesModel.setId(configDataMasterValues.getId());
				configDataMasterValuesModel.setConfigValue(configDataMasterValues.getConfigValue());
				configDataMasterValuesModel.setConfigKey(configDataMasterValues.getConfigKey());
				list.add(configDataMasterValuesModel);
			}
		}
		return ResponseBean.generateResponse(HttpStatus.ACCEPTED,ResponseStatus.Success,list);
	}

	@Override
	public ConfigDataMasterValues findStatusKey(String configKey) {
		return configDataMasterValuesRepo.findStatusKey(configKey);
	}

}
