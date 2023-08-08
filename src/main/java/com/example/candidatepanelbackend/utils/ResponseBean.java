package com.example.candidatepanelbackend.utils;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import com.example.candidatepanelbackend.Enum.ResponseStatus;
import com.example.candidatepanelbackend.Model.Candidate;

@Component
public class ResponseBean {

	private int statusCode;
	private HttpStatus httpstatus;
	private String message;
	private Object body;
	private ResponseStatus status;

	
	public HttpStatus getHttpstatus() {
		return httpstatus;
	}

	public void setHttpstatus(HttpStatus httpstatus) {
		this.httpstatus = httpstatus;
	}

	public ResponseStatus getStatus() {
		return status;
	}

	public void setStatus(ResponseStatus status) {
		this.status = status;
	}

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getBody() {
		return body;
	}

	public void setBody(Object body) {
		this.body = body;
	}

	public static ResponseBean generateResponse(HttpStatus httpStatus,ResponseStatus status,  String message, Object body) {
		ResponseBean bean = new ResponseBean();

		bean.setMessage(message);
		bean.setStatus(status);
		bean.setHttpstatus(httpStatus);
		bean.setBody(body);

		return bean;
	}

	public static ResponseBean generateResponse(HttpStatus httpStatus,ResponseStatus status, String message) {
		ResponseBean bean = new ResponseBean();

		bean.setMessage(message);
		bean.setStatus(status);
		bean.setHttpstatus(httpStatus);
		return bean;
	}

	public static ResponseBean generateResponse(HttpStatus httpStatus,ResponseStatus status, Object body) {
		ResponseBean bean = new ResponseBean();

		bean.setStatus(status);
		bean.setBody(body);
		bean.setHttpstatus(httpStatus);
		return bean;
	}

	public static ResponseBean generateResponse(HttpStatus httpStatus,ResponseStatus status, Object body, String message) {
		ResponseBean bean = new ResponseBean();
		bean.setMessage(message);
		bean.setStatus(status);
		bean.setBody(body);
		bean.setHttpstatus(httpStatus);
		return bean;	
	}

}