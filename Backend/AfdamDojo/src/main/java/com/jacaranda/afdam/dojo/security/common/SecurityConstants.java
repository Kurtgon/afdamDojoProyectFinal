package com.jacaranda.afdam.dojo.security.common;

public class SecurityConstants {

	public static final String SECRET = "GonzKeyToGenJWT_afdamD_@_GonzKeyToGenJWT_afdamD_@_GonzKeyToGenJWT_afdamD";

	public static final long EXPIRATION_TIME = 604_000_000;
	public static final String SIGN_UP_URL_ALUMNO = "/sign-up/alumno";
	public static final String SIGN_UP_URL_PROFESOR = "/sign-up/profesor";
	public static final String LOG_IN = "/user/login";
	public static final String HEADER_STRING = "Authorization";
	public static final String TOKEN_PREFIX = "Bearer ";
	

}
