package com.livesource.authentication.client.facebook;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.livesource.authentication.client.LoginService;
import com.livesource.authentication.client.LoginServiceAsync;
import com.livesource.authentication.client.github.SetLoggedIn;

public class FacebookLoginVerifyer {

	public static void authenticate(final String authenticationCode) {

		final LoginServiceAsync loginService = GWT.create(LoginService.class);

		if (!(authenticationCode == null || "".equals(authenticationCode))) {

			loginService.facebookLogin(authenticationCode,
					new AsyncCallback<String>() {

						public void onFailure(final Throwable caught) {
							System.out.println(caught);
						}

						public void onSuccess(final String jsonResults) {

							SetLoggedIn.authenticated(jsonResults);
						}
					});

		}
	}
}
