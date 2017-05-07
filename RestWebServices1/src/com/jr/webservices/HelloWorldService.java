package com.jr.webservices;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;
 
@Path("/hello")
public class HelloWorldService {
	
	/*
	 * @author: Ratnakar J
	 */
	
	@GET
	@Path("/{param}")
	public Response getMsg(@PathParam("param") String msg) {
		System.out.println("HelloWorldService : getMsg" + msg);
 
		String output = "Jersey say : " + msg;
		System.out.println("output : " + output);
 
		return Response.status(200).entity(output).build();
 
	}
}