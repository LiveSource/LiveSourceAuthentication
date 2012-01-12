package com.livesource.authentication.server;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.livesource.authentication.client.GreetingService;

/**
 * The server side implementation of the RPC service.
 */
@SuppressWarnings("serial")
public class GreetingServiceImpl extends RemoteServiceServlet implements
		GreetingService {

	public String greetServer(String input) throws IllegalArgumentException {
		
		return null;
	}
}
