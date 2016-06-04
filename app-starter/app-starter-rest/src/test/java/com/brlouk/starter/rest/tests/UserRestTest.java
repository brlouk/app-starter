package com.brlouk.starter.rest.tests;

import java.util.Arrays;

import javax.inject.Inject;

import org.apache.cxf.jaxrs.client.JAXRSClientFactory;
import org.apache.cxf.jaxrs.spring.JAXRSServerFactoryBeanDefinitionParser.SpringJAXRSServerFactoryBean;
import org.codehaus.jackson.jaxrs.JacksonJaxbJsonProvider;
import org.easymock.EasyMock;
import org.junit.Assert;
import org.junit.Test;

import com.brlouk.starter.persistence.User;
import com.brlouk.starter.persistence.repositories.UserRepository;
import com.brlouk.starter.rest.UserService;

public class UserRestTest extends AbstractRestTest {

	@Inject
	private SpringJAXRSServerFactoryBean restfulServicesServer;
	
	@Inject
	private UserRepository userRepository;
	

	@Test
	public void simple() {
		Assert.assertNotNull(restfulServicesServer);
		UserService userService = JAXRSClientFactory.create(restfulServicesServer.getAddress(), UserService.class,
				Arrays.asList(new JacksonJaxbJsonProvider()));
		Assert.assertNotNull(userService);
		User user = new User();
		user.setFirstName("tName");
		EasyMock.expect(userRepository.findOne(101L)).andReturn(user);
		EasyMock.replay(userRepository);
		User userById = userService.findUserById(101);
		Assert.assertTrue(userById.getFirstName().equals(user.getFirstName()));
	}

}
