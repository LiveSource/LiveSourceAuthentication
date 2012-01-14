package com.livesource.authentication.server;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.livesource.authentication.client.github.GithubAPIService;
import com.livesource.authentication.server.github.GithubAPI;

/**
 * The server side implementation of the RPC service.
 */
@SuppressWarnings("serial")
public class GithubAPIServiceImpl extends RemoteServiceServlet implements
		GithubAPIService {

	public static final String SECRET_github = "8e8ae6b7cb786bc8734f3e493d403ae7f3e6d5c0";
	public static final String APPLICATION_ID_github = "51ae1237beba4135e83f";
	public static final String GITHUB_URL = "https://github.com/login/oauth/authorize";
	public static final String github_OAUTH_URL = "https://github.com/login/oauth/access_token";

	public static final String REDIRECT_URL = "http://127.0.0.1:8888/LiveSourceAuthentication.html?gwt.codesvr=127.0.0.1:9997";


	public String githubLogin(final String authenticationCode) {

		final String url = getAccessTokenUrlGithub(URLUtil.encode(authenticationCode));
		String authenticationToken = URLUtil.fetchURL(url);
		
		if (authenticationToken!= null && authenticationToken.contains("access_token=")) {
			
			String userEmail = GithubAPI.me(authenticationToken);

			LiveSourcUserAPI.getUserEmail(userEmail);
		}
		
		return "";
	}

	
	public static String getAccessTokenUrlGithub(final String authCode) {

		final StringBuilder sb = new StringBuilder(github_OAUTH_URL);

		sb.append("?client_id=").append(APPLICATION_ID_github);
		sb.append("&redirect_uri=").append(URLUtil.encode(REDIRECT_URL));
		sb.append("&client_secret=").append(SECRET_github);
		sb.append("&code=").append(authCode);

		return sb.toString();
	}



}
