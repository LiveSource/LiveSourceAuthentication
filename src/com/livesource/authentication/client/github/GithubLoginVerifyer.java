package com.livesource.authentication.client.github;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;

public class GithubLoginVerifyer {

	public static void authenticate(final String authenticationCode) {

		final GithubLoginServiceAsync loginService = GWT.create(GithubLoginService.class); 

		if (!(authenticationCode == null || "".equals(authenticationCode))) {

			loginService.githubLogin(authenticationCode,
					new AsyncCallback<String>() {

						public void onFailure(final Throwable caught) {
							System.out.println(caught);
						}

						public void onSuccess(final String authenticationToken) {

						
						}
					});

		}
	}
}
