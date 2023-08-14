package com.example.candidatepanelbackend.responseModels;

public class ConfigDataMasterValuesModel {
	private Long id;
	private String configKey;
	private String configValue;
	private String configValueDescription;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getConfigKey() {
		return configKey;
	}
	public void setConfigKey(String configKey) {
		this.configKey = configKey;
	}
	public String getConfigValue() {
		return configValue;
	}
	public void setConfigValue(String configValue) {
		this.configValue = configValue;
	}
	public String getConfigValueDescription() {
		return configValueDescription;
	}
	public void setConfigValueDescription(String configValueDescription) {
		this.configValueDescription = configValueDescription;
	}
	
}
