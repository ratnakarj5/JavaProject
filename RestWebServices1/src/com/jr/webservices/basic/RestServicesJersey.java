package com.jr.webservices.basic;

import java.util.List;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

@Path("/users")
public class RestServicesJersey {
	/*
	*	Normal URI Matching 1
	*/
	@GET
	public Response getUser() {
		System.out.println("Normal URI Matching 1");
		return Response.status(200).entity("getUser is called").build();
 
	}
	
	/*
	 * 	URI Matching and Parameter
	 */
	@GET
	@Path("{name}")
	public Response getUserByName(@PathParam("name") String name) {
		System.out.println("URI Matching and Parameter" + "@Path({name})");
		return Response.status(200).entity("getUserByName is called, name : " + name).build();
	}
	
	/*
	*	Normal URI Matching 2
	*/
	@GET
	@Path("/vip")
	public Response getUserVIP() {
		System.out.println("Normal URI Matching 2" + "@Path(/vip)");
		return Response.status(200).entity("getUserVIP is called").build();
 
	}
	
	/*
	 * URI Matching and Regular Expression
	 */
	
	@GET
	@Path("{id : \\d+}") //support digit only
	public Response getUserById(@PathParam("id") String id) {
	   System.out.print("URI Matching and Regular Expression 1");
	   System.out.println("@Path({id : \\d+})");
	   return Response.status(200).entity("getUserById is called, id : " + id).build();
 
	}
	
	/*
	 * URI Matching and Regular Expression 2
	 */
	@GET
	@Path("/username/{username : [a-zA-Z][a-zA-Z_0-9]*}")
	public Response getUserByUserName(@PathParam("username") String username) {
	   System.out.print("URI Matching and Regular Expression 2");
	   System.out.println("@Path(/username/{username : [a-zA-Z][a-zA-Z_0-9]})");
	   return Response.status(200)
		.entity("getUserByUserName is called, username : " + username).build();
 
	}
 
	/*
	 * URI Matching and Regular Expression 3
	 */
	@GET
	@Path("/books/{isbn : \\d+}")
	public Response getUserBookByISBN(@PathParam("isbn") String isbn) {
	   System.out.print("URI Matching and Regular Expression 3");
	   System.out.println("@Path(/books/{isbn : \\d+})");
	   return Response.status(200)
		.entity("getUserBookByISBN is called, isbn : " + isbn).build();
 
	}
	
	/*
	 * @QueryParam example
	 */
	@GET
	@Path("/query")
	public Response getUsersQueryParam(
		@QueryParam("from") int from,
		@QueryParam("to") int to,
		@QueryParam("orderBy") List<String> orderBy) {
 
		return Response
		   .status(200)
		   .entity("getUsers is called, from : " + from + ", to : " + to
			+ ", orderBy" + orderBy.toString()).build();
 
	}
 
	/*
	 * @DefaultValue example
	 */
	@GET
	@Path("/querydefault")
	public Response getUsersDefaultValue(
		@DefaultValue("1000") @QueryParam("from") int from,
		@DefaultValue("999") @QueryParam("to") int to,
		@DefaultValue("name") @QueryParam("orderBy") List<String> orderBy) {
 
		return Response
		   .status(200)
		   .entity("getUsers is called, from : " + from + ", to : " + to
			+ ", orderBy" + orderBy.toString()).build();
 
	}
	
	 
		@GET
		@Path("/queryprogrammatic")
		public Response getUsers(@Context UriInfo info) {
	 
			String from = info.getQueryParameters().getFirst("from");
			String to = info.getQueryParameters().getFirst("to");
			List<String> orderBy = info.getQueryParameters().get("orderBy");
	 
			return Response
			   .status(200)
			   .entity("getUsers is called, from : " + from + ", to : " + to
				+ ", orderBy" + orderBy.toString()).build();
	 
		}
		
		@GET
		@Path("/booksd/{year}")
		public Response getBooks(@PathParam("year") String year,
				@MatrixParam("author") String author,
				@MatrixParam("country") String country) {
	 
			return Response
				.status(200)
				.entity("getBooks is called, year : " + year
					+ ", author : " + author + ", country : " + country)
				.build();
	 
		}

}
