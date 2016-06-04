
package com.brlouk.starter.soap.v1.user;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.brlouk.starter.persistence.User;
import com.brlouk.starter.persistence.predicates.UserPredicate;
import com.brlouk.starter.persistence.repositories.UserRepository;
import com.brlouk.starter.soap.v1.fault.WSFaultBuilder;
import com.brlouk.starter.soap.v1.model.user.UserType;
import com.brlouk.starter.soap.v1.user.findusersbyage.FindUsersByAgeResponse;

import ma.glasnost.orika.MapperFacade;

@javax.jws.WebService(serviceName = "UserWS", portName = "UserWS", targetNamespace = "http://brlouk.com/starter/soap/v1/user", wsdlLocation = "classpath:wsdl/starter/v1/wsdl/user/UserWS.wsdl", endpointInterface = "com.brlouk.starter.soap.v1.user.UserWS")
@Service
public class UserWSImpl implements UserWS {

	@Inject
	private UserRepository userRepository;

	@Inject
	private MapperFacade mapper;

	public FindUsersByAgeResponse findUsersByAge(int age) throws WSFaultException {
		if (age < 0) {
			throw WSFaultBuilder.createSingleFunctionalFault("F-AGE-MIN", "Age ne peut pas être négatif!", age);
		}
		FindUsersByAgeResponse response = new FindUsersByAgeResponse();
		Iterable<User> users = userRepository.findAll(UserPredicate.hasAge(age));
		for (User user : users) {
			response.getUsers().add(mapper.map(user, UserType.class));
		}
		return response;
	}

}
