package com.mds.util;

import java.security.Key;

import javax.crypto.spec.SecretKeySpec;
import javax.servlet.http.HttpServletRequest;
import javax.xml.bind.DatatypeConverter;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class VerifyTokenUtil {

	public static Boolean verifyToken(HttpServletRequest request, String token, String secretKey) {
		try {
			if (request.getHeader("token") == null || request.getHeader("token") == ""
					|| !isTokenValid(request, token, secretKey)) {
				return false;
			} else {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public static Boolean isTokenValid(HttpServletRequest request, String token, String secretKey) {
		try {
			Jwts.parser().setSigningKey(DatatypeConverter.parseBase64Binary(secretKey)).parseClaimsJws(token).getBody();
			return true;

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public static String generateJWTToken(HttpServletRequest request, String secretKey) {

		try {
			byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary(secretKey);
			Key signingKey = new SecretKeySpec(apiKeySecretBytes, SignatureAlgorithm.HS256.getJcaName());
			String subject = request.getHeader("user").concat(" ").concat(request.getHeader("timeStamp"));
			String jwtToken = Jwts.builder().setSubject(subject).signWith(SignatureAlgorithm.HS256, signingKey)
					.compact();
			return jwtToken;

		} catch (Exception e) {
			throw e;
		}
	}
}
