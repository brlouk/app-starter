package com.brlouk.starter.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.http.ResponseEntity;

@Path("/monitoring")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public interface MonitoringService {

	@GET
	@Path("/ping")
	public ResponseEntity<String> ping();

}
