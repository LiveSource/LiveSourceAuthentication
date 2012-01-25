package com.livesource.authentication.client.github;

import com.google.gwt.core.client.GWT;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONParser;
import com.google.gwt.user.client.Cookies;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.livesource.authentication.client.ConvertJson;
import com.livesource.authentication.client.EncryptText;
import com.livesource.authentication.client.LoginService;
import com.livesource.authentication.client.LoginServiceAsync;

public class GithubLoginVerifyer {

	public static void authenticate(final String authenticationCode) {

		final LoginServiceAsync loginService = GWT
				.create(LoginService.class);

		if (!(authenticationCode == null || "".equals(authenticationCode))) {

			loginService.githubLogin(authenticationCode,
					new AsyncCallback<String>() {

						public void onFailure(final Throwable caught) {
							System.out.println(caught);
						}

						public void onSuccess(final String jsonResults) {

							JSONObject obj = (JSONObject) JSONParser
									.parseStrict(jsonResults);

							String authenticationToken = ConvertJson
									.convertToString(obj
											.get("authenticationToken"));

							String githubUserLogin = ConvertJson
									.convertToString(obj.get("githubUserLogin"));

							String livesourceUser = ConvertJson
									.convertToString(obj.get("livesourceUser"));

							Cookies.setCookie("githubAuthenticationToken",
									EncryptText.encrypt(authenticationToken));

							Cookies.setCookie("githubUserLogin",
									EncryptText.encrypt(githubUserLogin));

							Cookies.setCookie("livesourceUser",
									EncryptText.encrypt(livesourceUser));

						}
					});

		}
	}
}
