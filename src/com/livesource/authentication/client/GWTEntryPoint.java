package com.livesource.authentication.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.Window.Location;
import com.google.gwt.user.client.ui.RootPanel;
import com.livesource.authentication.client.facebook.LoginWithFacebookButton;
import com.livesource.authentication.client.github.GithubLoginVerifyer;
import com.livesource.authentication.client.github.LoginGithubButton;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 * 
 * @Architecture
 */
public class GWTEntryPoint implements EntryPoint {

	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {

		final String authenticationCode = Location.getParameter("code");
		final String error = Location.getParameter("error_reason");

		if (null != error && error.equals("user_denied")) {

			RootPanel.get().add(new LoginGithubButton());

		} else if (authenticationCode == null || "".equals(authenticationCode)) {

			RootPanel.get().add(new LoginWithFacebookButton());
			
			RootPanel.get().add(new LoginGithubButton());

		} else {

			final String loginApp = Location.getParameter("login");

			if ("facebook".equals(loginApp)) {

			} else {
				GithubLoginVerifyer.authenticate(authenticationCode);
			}
		}
	}
}
