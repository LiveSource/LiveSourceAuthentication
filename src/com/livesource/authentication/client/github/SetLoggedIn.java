package com.livesource.authentication.client.github;

import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONParser;
import com.google.gwt.user.client.Cookies;
import com.livesource.authentication.client.Utilities.ConvertJson;
import com.livesource.authentication.client.Utilities.EncryptText;

public class SetLoggedIn {

	public static void authenticated(final String jsonResults) {

		JSONObject obj = (JSONObject) JSONParser.parseStrict(jsonResults);

		String authenticationToken = ConvertJson.convertToString(obj
				.get("authenticationToken"));

		String githubUserLogin = ConvertJson.convertToString(obj
				.get("githubUserLogin"));

		String livesourceUser = ConvertJson.convertToString(obj
				.get("livesourceUser"));

		Cookies.setCookie("githubAuthenticationToken",
				EncryptText.encrypt(authenticationToken));

		Cookies.setCookie("githubUserLogin",
				EncryptText.encrypt(githubUserLogin));

		Cookies.setCookie("livesourceUser", EncryptText.encrypt(livesourceUser));
	}
}
