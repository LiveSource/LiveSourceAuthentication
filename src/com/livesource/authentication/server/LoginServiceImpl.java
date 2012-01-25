package com.livesource.authentication.server;

import org.json.JSONException;
import org.json.JSONObject;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.livesource.authentication.client.LoginService;
import com.livesource.authentication.server.github.GithubAPI;
import com.livesource.authentication.server.github.GithubLogin;

public class LoginServiceImpl extends RemoteServiceServlet implements
		LoginService {

	private static final long serialVersionUID = -8355612980477933670L;

	public String githubLogin(final String authenticationCode) {

		JSONObject json = new JSONObject();

		String authenticationToken = GithubLogin.login(authenticationCode);

		if (authenticationToken != null
				&& authenticationToken.contains("access_token=")) {

			String githubUserLogin = GithubAPI.me(authenticationToken);

			String livesourceUser = LiveSourceUserAPI
					.getLivesourceUser(githubUserLogin);

			try {

				json.put("authenticationToken", authenticationToken);

				json.put("githubUserLogin", githubUserLogin);

				json.put("livesourceUser", livesourceUser);

			} catch (JSONException e) {

				e.printStackTrace();
			}

		}

		return json.toString();
	}

}
