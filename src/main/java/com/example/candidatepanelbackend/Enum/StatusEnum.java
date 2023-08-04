package com.example.candidatepanelbackend.Enum;

public enum StatusEnum {
	Scheduled("Scheduled"),
	Selected("Selected"),
	Rejected("Rejected");
	
	public String status;

	public String getStatus() {
		return status;
	}

	private StatusEnum(String status) {
		this.status = status;
	}
	
}
