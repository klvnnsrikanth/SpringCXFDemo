package com.srikanth.demo.rest.services.impl;

import com.srikanth.demo.rest.dao.UserManagerDao;
import com.srikanth.demo.rest.model.UserRequest;
import com.srikanth.demo.rest.model.UserResponse;
import com.srikanth.demo.rest.services.UserManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class UserManagerService implements UserManager
{
    @Autowired
    private UserManagerDao userDao;

    public UserManagerDao getUserDao()
    {
        return userDao;
    }

    public void setUserDao(UserManagerDao userDao)
    {
        this.userDao = userDao;
    }

    public UserResponse fetchUserById(UserRequest request)
    {
        UserResponse response = new UserResponse();

        try
        {
            response.setUsers(Arrays.asList(getUserDao().fetchUserById(
                    request.getUser().getId())));
        }
        catch (Exception e)
        {
            response.setSuccess(false);
            response.setErrorMessage(e.getClass() + ": " + e.getMessage());
        }

        return response;
    }

    public UserResponse fetchAllUsers(UserRequest request)
    {
        UserResponse response = new UserResponse();

        try
        {
            response.setUsers(getUserDao().fetchAllUsers());
        }
        catch (Exception e)
        {
            response.setSuccess(false);
            response.setErrorMessage(e.getClass() + ": " + e.getMessage());
        }

        return response;
    }

    public UserResponse insertUser(UserRequest request)
    {
        UserResponse response = new UserResponse();

        try
        {
            getUserDao().insertUser(request.getUser());
        }
        catch (Exception e)
        {
            response.setSuccess(false);
            response.setErrorMessage(e.getClass() + ": " + e.getMessage());
        }

        return response;
    }

    public UserResponse updateUser(UserRequest request)
    {
        UserResponse response = new UserResponse();

        try
        {
            getUserDao().updateUser(request.getUser());
        }
        catch (Exception e)
        {
            response.setSuccess(false);
            response.setErrorMessage(e.getClass() + ": " + e.getMessage());
        }

        return response;
    }

    public UserResponse deleteUser(UserRequest request)
    {
        UserResponse response = new UserResponse();

        try
        {
            getUserDao().deleteUser(request.getUser());
        }
        catch (Exception e)
        {
            response.setSuccess(false);
            response.setErrorMessage(e.getClass() + ": " + e.getMessage());
        }

        return response;
    }
}
