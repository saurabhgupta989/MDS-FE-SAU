package com.mds.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

public interface RouteService {

	public ResponseEntity<Object> handleGetRequests(String beURL, HttpMethod httpMethod);

	public ResponseEntity<Object> handlePostRequests(String beURL, HttpMethod httpMethod, HttpServletRequest request,
			Object requestBody);

}
