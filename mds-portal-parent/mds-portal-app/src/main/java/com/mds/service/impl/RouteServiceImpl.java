package com.mds.service.impl;

import java.net.URI;

import java.net.URISyntaxException;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.mds.service.RouteService;

@Service
public class RouteServiceImpl implements RouteService {

	@Autowired
	RestTemplate restTemplate;

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Override
	public ResponseEntity<Object> handleGetRequests(String beURL, HttpMethod httpMethod) {
		logger.debug("handleGetRequests service invoked");
		logger.info("handleGetRequests service invoked");

		ResponseEntity<Object> response = restTemplate.exchange(beURL, HttpMethod.GET, null, Object.class);
		logger.debug("GET:Response came in service");
		return response;
	}

	@Override
	public ResponseEntity<Object> handlePostRequests(String beURL, HttpMethod httpMethod, HttpServletRequest request,
			Object requestBody) {

		RequestEntity<Object> requestEntity = null;

		URI uri = null;
		ResponseEntity<Object> response = null;
		try {
			uri = new URI(beURL);
			requestEntity = RequestEntity.post(uri).contentType(MediaType.APPLICATION_JSON)
					.header(HttpHeaders.ACCESS_CONTROL_ALLOW_ORIGIN, "*").header(HttpHeaders.ORIGIN, "*")
					.body(requestBody);
			response = restTemplate.exchange(beURL, HttpMethod.POST, requestEntity, Object.class);
			logger.debug("POST:Response came in service");

		} catch (URISyntaxException e) {
			response = new ResponseEntity<>(e.getMessage(), null, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return response;
	}

}
