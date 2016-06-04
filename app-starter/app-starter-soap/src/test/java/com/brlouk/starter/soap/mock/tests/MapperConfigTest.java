package com.brlouk.starter.soap.mock.tests;

import javax.inject.Inject;

import org.joda.time.LocalDate;
import org.junit.Assert;
import org.junit.Test;

import com.brlouk.starter.persistence.User;
import com.brlouk.starter.soap.v1.model.user.UserType;

import ma.glasnost.orika.MapperFacade;

public class MapperConfigTest  extends AbstractSoapWSTest{

	@Inject
	private MapperFacade mapper;

	@Test
	public void userMapping() {
		Assert.assertNotNull(mapper);
		User user = new User();
		user.setFirstName("fname");
		user.setLastName("lName");
		user.setBirthDate(new LocalDate().toDate());
		user.setEmail("x.y@z");
		UserType userType = mapper.map(user, UserType.class);
		Assert.assertTrue(userType.getFirstName().equals(user.getFirstName()));

	}

}
