package com.brlouk.starter.services.filters;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.preauth.AbstractPreAuthenticatedProcessingFilter;

import com.brlouk.starter.services.security.AuthTokenService;
import com.brlouk.starter.services.security.AuthTokenService.UserPassword;

public class PreAuthenticatedFilter extends AbstractPreAuthenticatedProcessingFilter {

	private static Logger logger = Logger.getLogger(PreAuthenticatedFilter.class);

	@Resource
	private AuthTokenService authTokenService;

	/** InMemory : FOR TEST/DEV ONLY **/
	@Resource
	private UserDetailsService inMemoryUserDetailsService;

	@Override
	protected Object getPreAuthenticatedPrincipal(HttpServletRequest httpRequest) {
		// 0-GET TOKEN
		String token = httpRequest.getHeader("auth-token");
		if (token != null) {
			// 1-VALIDATE TOKEN (USER/PASSWORD)
			UserPassword currentUser = authTokenService.parse(token);
			UserDetails userInMem = null;
			try {
				userInMem = inMemoryUserDetailsService.loadUserByUsername(currentUser.getUserName());
				if (currentUser.getPassword().equals(userInMem.getPassword())) {
					return currentUser.getUserName();
				} else {
					logger.error("Invalid username/password");
				}
			} catch (UsernameNotFoundException e) {
				logger.error("username not found");
			}

		}
		return null;
	}

	@Override
	protected Object getPreAuthenticatedCredentials(HttpServletRequest httpRequest) {
		return "N/A";
	}

}
