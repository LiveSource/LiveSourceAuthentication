package com.livesource.authentication.client.github;

import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * The async counterpart of <code>GreetingService</code>.
 */
public interface GithubAPIServiceAsync {

	void githubLogin(String authenticationCode, AsyncCallback<String> callback);
}
