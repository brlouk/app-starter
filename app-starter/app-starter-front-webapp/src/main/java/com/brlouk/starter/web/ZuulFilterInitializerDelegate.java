package com.brlouk.starter.web;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.springframework.cloud.netflix.zuul.ZuulFilterInitializer;
import org.springframework.web.context.support.WebApplicationContextUtils;

@WebListener
public class ZuulFilterInitializerDelegate implements ServletContextListener {

	// @Autowired
	private ZuulFilterInitializer zuulFilterInitializer;

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		// ServletContext ctx = sce.getServletContext();
		zuulFilterInitializer = WebApplicationContextUtils.getWebApplicationContext(sce.getServletContext())
				.getBean(ZuulFilterInitializer.class);
		zuulFilterInitializer.contextInitialized(sce);

	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		zuulFilterInitializer = WebApplicationContextUtils.getWebApplicationContext(sce.getServletContext())
				.getBean(ZuulFilterInitializer.class);
		zuulFilterInitializer.contextDestroyed(sce);
	}

}
