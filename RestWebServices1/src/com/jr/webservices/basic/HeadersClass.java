package com.jr.webservices.basic;

import java.util.List;
import java.util.Map;

import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;

@Path("/usersheaders")
public class HeadersClass {
	@GET
	@Path("/gets1")
	public Response addUser(@HeaderParam("user-agent") String userAgent,
			@HeaderParam("username") String username,
			@HeaderParam("password") String password,
			@HeaderParam("Accept-Encoding") String acceptEncoding,
			@HeaderParam("Accept-Language") String acceptLanguage) {
 
		System.out.println("userAgent"+userAgent);
		System.out.println("username"+username);
		System.out.println("password"+password);
		System.out.println(acceptEncoding + " " + acceptLanguage);
		return Response.status(200)
			.entity("addUser is called, userAgent : " + userAgent)
			.build();
 
	}
	
	@GET
	@Path("/gets2")
	public Response addUser(@Context HttpHeaders headers) {
 
		String userAgent = headers.getRequestHeader("user-agent").get(0);
		System.out.println(headers.getRequestHeader("username").get(0));
		System.out.println(headers.getRequestHeader("password").get(0));
		System.out.println(headers.getRequestHeader("Accept-Encoding").get(0));
		System.out.println(headers.getRequestHeader("Accept-Language").get(0));
		
		for(String header : headers.getRequestHeaders().keySet()){
			System.out.println(header);
		}
		
		for (Map.Entry<String, List<String>> e : headers.getRequestHeaders().entrySet()) {
			System.out.println(e.getKey() +" : " + e.getValue().get(0));
	    } 
		return Response.status(200)
			.entity("addUser is called, userAgent : " + userAgent)
			.build();
 
	}

}
