package com.example.candidatepanelbackend.service;

import com.example.candidatepanelbackend.entity.ConfigDataMasterValues;
import com.example.candidatepanelbackend.utils.ResponseBean;

public interface ConfigDataMasterValuesService {

	ResponseBean getCandidateStatus();

	ResponseBean getCnadidateStatus(Long id);

	ConfigDataMasterValues getValuebyKey(String Status, String candidateStatus);

	ResponseBean interviewStatus();

	ConfigDataMasterValues findStatusKey(String configKey);

}
