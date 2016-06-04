package com.brlouk.starter.rest.impl;

import java.util.List;

import javax.inject.Inject;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.brlouk.starter.persistence.User;
import com.brlouk.starter.persistence.repositories.UserRepository;
import com.brlouk.starter.rest.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Inject
	private UserRepository userRepository;

	public User findUserById(long id) {
		User user = userRepository.findOne(id);
		return user;
	}

	@Override
	public ResponseEntity<List<User>> findUsers(int page, int size) {
		Page<User> result = userRepository
				.findAll(new PageRequest(page, size, new Sort(Sort.Direction.ASC, "lastName")));
		List<User> users = result.getContent();
		long count = userRepository.count();
		HttpHeaders headers = new HttpHeaders();
		headers.add("count", String.valueOf(count));
		return new ResponseEntity<List<User>>(users, headers, HttpStatus.ACCEPTED);
	}

}
