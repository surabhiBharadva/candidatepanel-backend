package com.example.candidatepanelbackend;

import org.apache.log4j.PropertyConfigurator;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.candidatepanelbackend.constants.Constants;



@SpringBootApplication
public class CandidatePanelBackendApplication {

	public static void main(String[] args) {
		PropertyConfigurator.configure(Constants.LOG4j_FILE_PATH);
		SpringApplication.run(CandidatePanelBackendApplication.class, args);
	}

}
