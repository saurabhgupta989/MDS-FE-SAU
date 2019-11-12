package com.mds.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.util.UriComponentsBuilder;

import com.mds.constants.RouterConstants;

public class RouterUtil {

	@Autowired
	public Environment env;

	public static String getBackendURL(Environment env, String urlKey) {

		String url = env.getProperty(urlKey);
		String beURL = env.getProperty(RouterConstants.beProtocol) + env.getProperty(RouterConstants.beServer) + ":"
				+ env.getProperty(RouterConstants.bePort) + url;

		return beURL.trim();
	}

	public static String getBackendURLWithQueryString(String queryString, String beUrl) {
		UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromUriString(beUrl);
		String[] queryParamsArray = queryString.split(RouterConstants.AND_DELIMETER);
		for (String queryParam : queryParamsArray) {
			String[] queryToken = queryParam.split(RouterConstants.EQUAL_DELIMETER);
			if (queryToken.length == RouterConstants.QUERY_TOKEN_LENGTH) {
				uriBuilder.queryParam(queryToken[0], queryToken[1]);
			}
		}
		return uriBuilder.toUriString();
	}

}
