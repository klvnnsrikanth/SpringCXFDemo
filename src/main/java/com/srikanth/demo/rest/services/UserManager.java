package com.srikanth.demo.rest.services;

import com.srikanth.demo.rest.model.UserRequest;
import com.srikanth.demo.rest.model.UserResponse;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;


@Consumes("application/json")
@Produces("application/json")
public interface UserManager
{
    @POST
    @Path("/fetchUserById/")
    public UserResponse fetchUserById(UserRequest request);

    @POST
    @Path("/fetchAllUsers/")
    public UserResponse fetchAllUsers(UserRequest request);

    @POST
    @Path("/insertUser/")
    public UserResponse insertUser(UserRequest request);

    @POST
    @Path("/updateUser/")
    public UserResponse updateUser(UserRequest request);

    @POST
    @Path("/deleteUser/")
    public UserResponse deleteUser(UserRequest request);
}
