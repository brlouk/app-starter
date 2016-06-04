package com.brlouk.starter.soap.config;

import org.hibernate.usertype.UserType;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.brlouk.starter.persistence.User;

import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;

@Configuration
public class MapperConfig {

	@Bean
	public MapperFactory mapperFactory() {
		DefaultMapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();
		//REGISTER MAPPERS
		registerUser(mapperFactory);
		//
		return mapperFactory;
	}

	@Bean(name="mapper")
	public MapperFacade mapperFacade(MapperFactory mapperFactory) {
		return mapperFactory.getMapperFacade();
	}

	public void registerUser(MapperFactory mapperFactory) {
		mapperFactory.classMap(User.class, UserType.class).byDefault().register();
	}

}
