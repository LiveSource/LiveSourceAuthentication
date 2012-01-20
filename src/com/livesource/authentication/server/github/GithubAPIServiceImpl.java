package com.livesource.authentication.server.github;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.livesource.authentication.client.github.GithubAPIService;
import com.livesource.authentication.server.LiveSourcUserAPI;

public class GithubAPIServiceImpl extends RemoteServiceServlet implements
		GithubAPIService {

	private static final long serialVersionUID = -8355612980477933670L;

	public String githubLogin(final String authenticationCode) {

		String livesourceUser = null;

		String authenticationToken = GithubLogin.login(authenticationCode);

		if (authenticationToken != null
				&& authenticationToken.contains("access_token=")) {

			String githubUserLogin = GithubAPI.me(authenticationToken);

			livesourceUser = LiveSourcUserAPI
					.getLivesourceUser(githubUserLogin);
			
			//GithubAPI.sourceFiles(authenticationToken, githubUserLogin, "TravelLog");
		}

		return livesourceUser;
	}

}
