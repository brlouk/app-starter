package com.brlouk.starter.rest.tests;

import org.junit.runner.RunWith;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-rest-ws.xml", "classpath:test/spring-rest-config.xml" })
@ComponentScan("com.brlouk.starter.rest.tests")
@ActiveProfiles(profiles = { "test", "dev" })
public abstract class AbstractRestTest {

}
