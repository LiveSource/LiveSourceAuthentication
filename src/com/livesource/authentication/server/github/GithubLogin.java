package com.livesource.authentication.server.github;

import com.livesource.authentication.server.URLUtil;

public class GithubLogin {

	private static final String SECRET_github = "8e8ae6b7cb786bc8734f3e493d403ae7f3e6d5c0";
	private static final String APPLICATION_ID_github = "51ae1237beba4135e83f";
	private static final String GITHUB_URL = "https://github.com/login/oauth/authorize";
	private static final String github_OAUTH_URL = "https://github.com/login/oauth/access_token";

	private static final String REDIRECT_URL = "http://127.0.0.1:8888/LiveSourceAuthentication.html?gwt.codesvr=127.0.0.1:9997";

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
