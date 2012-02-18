package com.livesource.authentication.server.facebook;

import org.json.JSONException;
import org.json.JSONObject;

import com.livesource.authentication.server.LiveSourceUserAPI;
import com.livesource.authentication.server.URLUtil;
import com.livesource.authentication.server.github.GithubAPI;

public class FacebookLogin {

	// private static final String SECRET_LiveSource_facebook =
	// "5a2a037588b453a3df4058c836850da1"; // Testing
	// private static final String APPLICATION_ID_github = "158550007562379"; //
	// Testing

	private static final String SECRET_LiveSource_facebook = "110a3c23f4c80ac47ddcc5c9fd9fb032";
	private static final String APPLICATION_ID_LiveSource_Facebook = "194243253971053";

	private static final String Facebook_URL = "https://graph.facebook.com/dialog/oauth/";
	private static final String Facebook_OAUTH_URL = "https://graph.facebook.com/oauth/access_token";

	// private static final String REDIRECT_URL =
	// "http://127.0.0.1:8888/LiveSourceApp.html?gwt.codesvr=127.0.0.1:9997"; //
	// Testing
	// private static final String REDIRECT_URL =
	// "http://127.0.0.1:8888/ProjectnectionWeb.html?gwt.codesvr=127.0.0.1:9997";
	// // Testing
	// private static final String REDIRECT_URL =
	// "http://127.0.0.1:8888/LiveSourceAuthentication.html?gwt.codesvr=127.0.0.1:9997";
	// // Testing
	// private static final String REDIRECT_URL = "http://www.golivesource.com";
	private static final String REDIRECT_URL = "http://livesrc.com";

	public static JSONObject githubLogin(final String authenticationCode) {

		JSONObject json = new JSONObject();

		String authenticationToken = login(authenticationCode);

		if (authenticationToken != null
				&& authenticationToken.contains("access_token=")) {

			JSONObject githubUserMe = GithubAPI.me(authenticationToken);

			String githubUserLogin = null;
			String githubUserName = null;

			try {
				githubUserLogin = githubUserMe.getString("login");
				githubUserName = githubUserMe.getString("name");

			} catch (JSONException e1) {
				e1.printStackTrace();
			}

			String livesourceUser = LiveSourceUserAPI
					.getLivesourceUser(githubUserLogin);

			try {

				json.put("authenticationToken", authenticationToken);

				json.put("githubUserLogin", githubUserLogin);

				json.put("githubUserName", githubUserName);

				json.put("livesourceUser", livesourceUser);

			} catch (JSONException e) {

				e.printStackTrace();
			}
		}

		return json;
	}

	public static String login(final String authenticationCode) {

		final String url = getAccessTokenUrlGithub(URLUtil
				.encode(authenticationCode));
		String authenticationToken = URLUtil.fetchURL(url);

		return authenticationToken;
	}

	private static String getAccessTokenUrlGithub(final String authCode) {

		final StringBuilder sb = new StringBuilder(Facebook_OAUTH_URL);

		sb.append("?client_id=").append(APPLICATION_ID_LiveSource_Facebook);
		sb.append("&redirect_uri=").append(URLUtil.encode(REDIRECT_URL));
		sb.append("&client_secret=").append(SECRET_LiveSource_facebook);
		sb.append("&code=").append(authCode);

		return sb.toString();
	}

}
