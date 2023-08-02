package com.example.candidatepanelbackend.Service;

import org.springframework.stereotype.Component;

import com.example.candidatepanelbackend.Enum.ResponseStatus;
import com.example.candidatepanelbackend.utils.ResponseBody;

@Component
public class ResponseService {
	
	
	public ResponseBody RespnseData(String message, Object object, ResponseStatus Status) {
		
		ResponseBody response = new ResponseBody();
		response.setMessage(message);
		response.setObject(object);
		response.setStatus(Status);
		return response;
	}

	public Object RespnseData(String message,ResponseStatus Status) {
		ResponseBody response = new ResponseBody();
		response.setMessage(message);
		response.setStatus(Status);
		return response;
	}

	public Object RespnseData(String message) {
		ResponseBody response = new ResponseBody();
		response.setMessage(message);
		
		return response;
	}

}
