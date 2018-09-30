package com.mds.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.mds.model.TokenResponse;
import com.mds.service.RouteService;
import com.mds.util.VerifyTokenUtil;

import static com.mds.util.RouterUtil.getBackendURL;
import static com.mds.util.RouterUtil.getBackendURLWithQueryString;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("api")
public class RouteController {

	@Autowired
	private RouteService routeService;

	@Autowired
	private Environment env;

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@GetMapping(value = "/get/{urlKey}", produces = "application/json")
	public ResponseEntity<Object> handleGetRequest(@PathVariable("urlKey") String urlKey, HttpServletRequest request) {

		logger.debug("handleGetRequest service called");
		logger.info("handleGetRequest service called");

		ResponseEntity<Object> response = null;
		Map<String, Object> map = new HashMap<>();

		String beUrl = getBackendURL(env, urlKey);

		String queryString = request.getQueryString();
		if (queryString != null) {
			logger.debug("Query String is present " + queryString);
			beUrl = getBackendURLWithQueryString(queryString, beUrl);
		} else {
			logger.debug("Query String not present");
		}

		if (beUrl == null || beUrl.equals("")) {
			map.put("message", "GET : BE url is null");
			response = new ResponseEntity<>(map, null, HttpStatus.INTERNAL_SERVER_ERROR);
			return response;
		}
		try {

			if (request.getHeader("token") == null) {
				logger.debug("Token is not present");
			} else {
				logger.debug("Token is present");
			}

			if (VerifyTokenUtil.verifyToken(request, request.getHeader("token"), env.getProperty("secretKey"))) {
				response = routeService.handleGetRequests(beUrl, HttpMethod.GET);
				logger.debug("GET: Response recieved from BE");
				return response;
			} else {
				map.put("message", "Token is not verified");
				response = new ResponseEntity<>(map, null, HttpStatus.INTERNAL_SERVER_ERROR);
				return response;
			}

		} catch (Exception e) {
			e.printStackTrace();
			response = new ResponseEntity<>(e.getMessage(), null, HttpStatus.INTERNAL_SERVER_ERROR);
			return response;
		}
	}

	@PostMapping(value = "/post/{urlKey}", produces = "application/json")
	public ResponseEntity<Object> handlePostRequest(@PathVariable("urlKey") String urlKey, HttpServletRequest request,
			@RequestBody Object requestBody) {

		logger.debug("handlePostRequest service called");
		logger.info("handlePostRequest service called");

		ResponseEntity<Object> response = null;
		Map<String, Object> map = new HashMap<>();

		String beUrl = getBackendURL(env, urlKey);

		if (beUrl == null || beUrl.equals("")) {
			map.put("message", "GET : BE url is null");
			response = new ResponseEntity<>(map, null, HttpStatus.INTERNAL_SERVER_ERROR);
			return response;
		}
		try {

			if (request.getHeader("token") == null) {
				logger.debug("Token is not present");
			} else {
				logger.debug("Token is present");
			}

			if (VerifyTokenUtil.verifyToken(request, request.getHeader("token"), env.getProperty("secretKey"))) {
				response = routeService.handlePostRequests(beUrl, HttpMethod.POST, request, requestBody);
				logger.debug("GET: Response recieved from BE");
				return response;
			} else {
				map.put("message", "Token is not verified");
				response = new ResponseEntity<>(map, null, HttpStatus.INTERNAL_SERVER_ERROR);
				return response;
			}

		} catch (Exception e) {
			e.printStackTrace();
			response = new ResponseEntity<>(e.getMessage(), null, HttpStatus.INTERNAL_SERVER_ERROR);
			return response;
		}
	}

	@PostMapping(value = "/login", produces = "application/json")
	public ResponseEntity<Object> login(HttpServletRequest request) {

		logger.debug("login service called");
		logger.info("login service called");

		String token = null;
		ResponseEntity<Object> response = null;
		TokenResponse responseObj = new TokenResponse();
		try {
			token = VerifyTokenUtil.generateJWTToken(request, env.getProperty("secretKey"));
			responseObj.setToken(token);
			response = new ResponseEntity<>(responseObj, null, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			response = new ResponseEntity<>(e.getMessage(), null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return response;

	}

}
