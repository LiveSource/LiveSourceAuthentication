package com.livesource.authentication.client.github;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;

public class GithubLoginVerifyer {

	public static void authenticate(final String authenticationCode) {

		final GithubAPIServiceAsync loginService = GWT.create(GithubAPIService.class); 

		if (!(authenticationCode == null || "".equals(authenticationCode))) {

			loginService.githubLogin(authenticationCode,
					new AsyncCallback<String>() {

						public void onFailure(final Throwable caught) {
							System.out.println(caught);
						}

						public void onSuccess(final String authenticationToken) {
							
							Window.alert(authenticationToken);
							System.out.println(authenticationToken);
						}
					});

		}
	}
}
