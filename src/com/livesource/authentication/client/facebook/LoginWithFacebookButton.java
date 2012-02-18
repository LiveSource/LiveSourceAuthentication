package com.livesource.authentication.client.facebook;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Image;

public class LoginWithFacebookButton extends Image {

	// private static final String livesourceFacebookID = "194243253971053";
	private static final String livesourceFacebookID = "158550007562379"; // _localhost

	// private static final String REDIRECT_URL = "http://xlean.biz";
	private static final String REDIRECT_URL = "http://localhost:8888/?login=facebook"; // localhost

	public LoginWithFacebookButton() {

		this.setUrl(GWT.getModuleName()
				+ "/authentication/images/LoginWithFacebook.png");

		this.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {

				String url = "https://www.facebook.com/dialog/oauth?"
						+ "client_id=" + livesourceFacebookID
						+ "&redirect_uri=" + REDIRECT_URL + "&scope=email";

				redirect(url);
			}
		});

	}

	// redirect the browser to the given url
	public static native void redirect(String url)/*-{
		$wnd.location = url;
	}-*/;
}
