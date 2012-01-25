package com.livesource.authentication.server;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class LiveSourceUserAPI {

	private static String getUserEmailUrl = "http://jsonpfy.projectnection.appspot.com/ListDataService"
			+ "?kind=Entity&filterField=githubLogin&filterValue=";

	public static String getLivesourceUser(final String githubLogin) {

		String livesourceUser = null;

		final String jsonString = URLUtil.fetchURL(getUserEmailUrl
				+ githubLogin);

		try {
			JSONArray json = new JSONArray(jsonString);

			JSONObject user = (JSONObject) json.get(0);

			livesourceUser = user.getString("ID");

		} catch (JSONException e) {

			e.printStackTrace();
		}

		return livesourceUser;
	}
}
