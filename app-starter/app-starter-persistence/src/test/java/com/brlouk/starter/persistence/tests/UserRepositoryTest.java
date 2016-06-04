package com.brlouk.starter.persistence.tests;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.transaction.annotation.Transactional;

import com.brlouk.starter.persistence.User;
import com.brlouk.starter.persistence.predicates.UserPredicate;
import com.brlouk.starter.persistence.repositories.UserRepository;

public class UserRepositoryTest extends AbstractPersistenceTest {

	@Resource
	private UserRepository userRepository;

	@Test
	@Transactional
	public void insert() {
		Assert.assertNotNull(userRepository);
		User entity = new User();
		userRepository.save(entity);
		Assert.assertTrue(entity.getId() != 0);
		Assert.assertFalse(userRepository.count() == 0L);
		userRepository.findAll();
	}

	@Test
	@Transactional
	@Sql("classpath:data/test-data.sql")
	public void findByFirstNameEndsWith() {
		List<User> users = userRepository.findByFirstNameEndsWith("3");
		Assert.assertTrue(users.size() == 1);

	}
	@Test
	@Transactional
	@Sql("classpath:data/test-age.sql")
	public void findByAge() {
		List<User> users = (List<User>) userRepository.findAll(UserPredicate.hasAge(20));
		Assert.assertTrue(users.size() == 1);

	}

}
