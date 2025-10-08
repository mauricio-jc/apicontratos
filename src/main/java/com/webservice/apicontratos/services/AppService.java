package com.webservice.apicontratos.services;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class AppService {
	private final long start;
	
	public AppService() {
		this.start = System.currentTimeMillis();
	}
	
	public Map<String, Object> api() {
		long now = System.currentTimeMillis();
        long uptimeSeconds = (now - this.start) / 1000;
        
        Map<String, Object> data = new HashMap<String, Object>();
        data.put("uptime", uptimeSeconds);
		
		Map<String, Object> response = new HashMap<String, Object>();
		response.put("statusCode", HttpStatus.OK.value());
		response.put("status", true);
		response.put("message", "API Online");
		response.put("error", null);
		response.put("data", data);
		
		return response;
	}
}
