package com.brlouk.starter.persistence.repositories;

import java.util.List;

import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.brlouk.starter.persistence.User;

public interface UserRepository extends PagingAndSortingRepository<User, Long>, QueryDslPredicateExecutor<User> {

	List<User> findByFirstNameEndsWith(String firstname);

}