package com.livesource.authentication.server.github;

import com.livesource.authentication.server.URLUtil;

public class GithubAPI {
	

	private static final String userURL = "https://api.github.com/user";
	
	private static final String userEmailsURL = "https://api.github.com/user/emails";
	

	
	public String me(final String authToken) {

		final String json = URLUtil.fetchURL(userURL + "?"
				+ authToken);

		return json;
	}
	
	public static String userEmails(final String authToken) {

		final String json = URLUtil.fetchURL(userEmailsURL + "?"
				+ authToken);
		
		//final FBFriends fbFriends = new Gson().fromJson(json, );

		return json;
	}
	
}
