package com.livesource.authentication.server.github;

import com.livesource.authentication.server.URLUtil;

public class GithubLogin {

	private static final String SECRET_github_Testing = "8e8ae6b7cb786bc8734f3e493d403ae7f3e6d5c0";
	private static final String APPLICATION_ID_github_Testing = "51ae1237beba4135e83f";
	
	private static final String SECRET_github = "e8da41753e1e443e28064e8835de3a89a53b9945";
	private static final String APPLICATION_ID_github = "0fc5843521cee3e10e06";
	
	private static final String GITHUB_URL = "https://github.com/login/oauth/authorize";
	private static final String github_OAUTH_URL = "https://github.com/login/oauth/access_token";

	private static final String REDIRECT_URL_Testing = "http://127.0.0.1:8888/ProjectnectionWeb.html?gwt.codesvr=127.0.0.1:9997";
	private static final String REDIRECT_URL = "http://www.golivesource.com";
	

	public static String login(final String authenticationCode) {

		final String url = getAccessTokenUrlGithub(URLUtil
				.encode(authenticationCode));
		String authenticationToken = URLUtil.fetchURL(url);

		return authenticationToken;
	}

	private static String getAccessTokenUrlGithub(final String authCode) {

		final StringBuilder sb = new StringBuilder(github_OAUTH_URL);

		sb.append("?client_id=").append(APPLICATION_ID_github);
		sb.append("&redirect_uri=").append(URLUtil.encode(REDIRECT_URL));
		sb.append("&client_secret=").append(SECRET_github);
		sb.append("&code=").append(authCode);

		return sb.toString();
	}

}
