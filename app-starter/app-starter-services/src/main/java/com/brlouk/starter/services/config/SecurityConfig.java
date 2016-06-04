package com.brlouk.starter.services.config;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.AnonymousAuthenticationFilter;
import org.springframework.security.web.csrf.CsrfTokenRepository;
import org.springframework.security.web.csrf.HttpSessionCsrfTokenRepository;
import org.springframework.security.web.session.SessionManagementFilter;

import com.brlouk.starter.services.filters.CsrfHeaderFilter;
import com.brlouk.starter.services.filters.PreAuthenticatedFilter;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Resource
	private PreAuthenticatedFilter preAuthenticatedFilter;
	
	
	/**ONLY FOR BACK-END DEV*/
//	@Autowired
//	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//		auth
//			.inMemoryAuthentication()
//				.withUser("dev").password("dev").roles("USER");
//	}

	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable().authorizeRequests().anyRequest().permitAll();
//		http.authorizeRequests().antMatchers("/**/logout").permitAll().and().authorizeRequests().anyRequest()
//				.authenticated().and().addFilterBefore(preAuthenticatedFilter, AnonymousAuthenticationFilter.class)
//				.addFilterAfter(new CsrfHeaderFilter(), SessionManagementFilter.class).csrf()
//				.csrfTokenRepository(csrfTokenRepository())/*.and().httpBasic()*/;
	}

	private CsrfTokenRepository csrfTokenRepository() {
		HttpSessionCsrfTokenRepository repository = new HttpSessionCsrfTokenRepository();
		repository.setHeaderName("X-XSRF-TOKEN");
		return repository;
	}

}