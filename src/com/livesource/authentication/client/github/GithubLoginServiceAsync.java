package com.livesource.authentication.client.github;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface GithubLoginServiceAsync {

	void githubLogin(String authenticationCode, AsyncCallback<String> callback);
}
