package com.brlouk.starter.web;

import javax.servlet.ServletContext;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.servlet.DispatcherServlet;

public class MvcInitializer implements WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext container) {
		ServletRegistration.Dynamic registration = container.addServlet("dispatcher", new DispatcherServlet());
		registration.setLoadOnStartup(1);
		registration.addMapping("/*");
	}

}