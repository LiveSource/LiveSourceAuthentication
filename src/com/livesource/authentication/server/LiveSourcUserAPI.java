package com.livesource.authentication.server;

public class LiveSourcUserAPI {

	private static final long serialVersionUID = -1721063626421257378L;

	private static String getUserEmailUrl = "http://jsonpfy.projectnection.appspot.com/ListDataService"
			+ "?kind=Entity&filterField=email";

	public static String getUserEmail(final String userEmail) {

		final String json = URLUtil.fetchURL(getUserEmailUrl + "&filterValue="
				+ userEmail);

		return json;
	}
}
