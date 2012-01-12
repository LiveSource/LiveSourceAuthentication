package com.livesource.authentication.client.github;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("githubAPI")
public interface GithubLoginService extends RemoteService {
	

	public String githubLogin(String authenticationCode);
}
