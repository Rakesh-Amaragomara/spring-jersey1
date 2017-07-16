package org.arpit.java2blog.controller;

import java.net.URISyntaxException;
import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.arpit.java2blog.api.ProfileAPI;
import org.arpit.java2blog.bean.User;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;




@Path("/profile")
public class UserProfileController {
	
	@Autowired
	ProfileAPI profileservice;
	NavigatorService navigatorService=new NavigatorService();
	
    @GET
    @Path("/id")
    @Produces(MediaType.APPLICATION_JSON)
	public void getUserProfile() throws URISyntaxException
	{
    	System.out.println(profileservice.getUser().toString());
    	//java.net.URI location = new java.net.URI("/success");
	    //return Response.temporaryRedirect(location).build();
	}

    @POST
    @Path("/user")
    @Produces(MediaType.APPLICATION_JSON)
    public User updateUser(User user) throws URISyntaxException
	{System.out.println("this is a post method"+user);
		return (User) navigatorService.getProfile();
	}
	
}
