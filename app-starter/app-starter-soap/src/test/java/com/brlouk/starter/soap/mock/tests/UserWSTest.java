package com.brlouk.starter.soap.mock.tests;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.easymock.EasyMock;
import org.junit.Assert;
import org.junit.Test;

import com.brlouk.starter.persistence.User;
import com.brlouk.starter.persistence.predicates.UserPredicate;
import com.brlouk.starter.persistence.repositories.UserRepository;
import com.brlouk.starter.soap.v1.user.UserWSImpl;
import com.brlouk.starter.soap.v1.user.WSFaultException;
import com.brlouk.starter.soap.v1.user.findusersbyage.FindUsersByAgeResponse;

public class UserWSTest extends AbstractSoapWSTest {

	@Inject
	private UserWSImpl userWS;
	
	@Inject
	private UserRepository userRepository;

	@Test
	public void simple() throws WSFaultException {
		Assert.assertNotNull(userWS);
		List<User> users = new ArrayList<>();
		User user = new User();
		user.setFirstName("fName");
		users.add(user);
		EasyMock.expect(userRepository.findAll(UserPredicate.hasAge(10))).andReturn(users);
		EasyMock.replay(userRepository);
		FindUsersByAgeResponse response = userWS.findUsersByAge(10);
		Assert.assertTrue(response.getUsers().size()==1);
	}

}
