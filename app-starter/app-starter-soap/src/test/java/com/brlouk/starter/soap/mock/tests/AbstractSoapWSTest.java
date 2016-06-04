package com.brlouk.starter.soap.mock.tests;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-soap-test.xml" })
public abstract class AbstractSoapWSTest {


}
