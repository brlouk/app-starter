package com.brlouk.starter.rest.impl;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.brlouk.starter.rest.MonitoringService;

@Service
public class MonitoringServiceImpl implements MonitoringService {

	@Override
	public ResponseEntity<String> ping() {
		return new ResponseEntity<String>("Welcome!", HttpStatus.ACCEPTED);
	}

}
