package com.example.candidatepanelbackend.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/labels")
public class LabelController {
	  @GetMapping("/dynamic")
	    public ResponseEntity<Map<String, String>> getDynamicLabels() {
	      
	        Properties properties = new Properties();
	        try {
	            FileInputStream fileInputStream = new FileInputStream("C:\\Users\\Surabhi\\Downloads\\candidate-panel-backend\\src\\main\\resources\\labelShow.properties");
	            properties.load(fileInputStream);
	            fileInputStream.close();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	        
	        Map<String, String> labelMap = new HashMap<>();

	        for (String propertyName : properties.stringPropertyNames()) {
	            labelMap.put(propertyName, properties.getProperty(propertyName));
	        }
	        return ResponseEntity.ok(labelMap);
	    }
}
