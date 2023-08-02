package com.example.candidatepanelbackend.utils;

import com.example.candidatepanelbackend.Enum.ResponseStatus;

public class ResponseBody {
	
	private String message;
	private Object object;
	private ResponseStatus status; 
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Object getObject() {
		return object;
	}
	public void setObject(Object object) {
		this.object = object;
	}
	public ResponseStatus getStatus() {
		return status;
	}
	public void setStatus(ResponseStatus status) {
		this.status = status;
	}
	
	

}
