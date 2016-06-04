package com.brlouk.starter.rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.http.ResponseEntity;

import com.brlouk.starter.persistence.User;

@Path("/user")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public interface UserService {

	@GET
	@Path("/{id}")
	User findUserById(@PathParam("id") long id);
	
	@GET
	@Path("/{page}/{size}")
	ResponseEntity<List<User>> findUsers(@PathParam("page") int page, @PathParam("size") int size);

}