package com.brlouk.starter.soap.mock.tests;

import org.easymock.EasyMock;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.brlouk.starter.persistence.repositories.UserRepository;

@Configuration
public class EasyMockConfiguration {

	@Bean
	public UserRepository userRepository() {
		return EasyMock.createStrictMock(UserRepository.class);
	}


}