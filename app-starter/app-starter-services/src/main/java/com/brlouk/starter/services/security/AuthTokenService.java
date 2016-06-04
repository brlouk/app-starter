package com.brlouk.starter.services.security;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class AuthTokenService {

	public UserPassword parse(String token) {
		if (token != null) {
			List<String> userToken = Arrays.asList(token.split(":"));
			if (userToken.size() == 2) {
				return new UserPassword(userToken.get(0), userToken.get(1));
			}
		}
		return null;

	}

	public static class UserPassword {
		private String userName;
		private String password;

		public UserPassword(String userName, String password) {
			super();
			this.userName = userName;
			this.password = password;
		}

		public String getUserName() {
			return userName;
		}

		public void setUserName(String userName) {
			this.userName = userName;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

	}

}
