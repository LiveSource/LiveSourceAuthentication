package com.livesource.authentication.server;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.livesource.authentication.client.LoginService;
import com.livesource.authentication.server.github.GithubLogin;

public class LoginServiceImpl extends RemoteServiceServlet implements
		LoginService {

	private static final long serialVersionUID = -8355612980477933670L;

	public String githubLogin(final String authenticationCode) {

		return GithubLogin.githubLogin(authenticationCode).toString();
	}

}
