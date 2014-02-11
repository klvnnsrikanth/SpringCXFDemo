package com.srikanth.demo.rest.dao;

import com.srikanth.demo.rest.model.User;

import java.util.List;

public interface UserManagerDao
{
    public User fetchUserById(Integer id);
    public List fetchAllUsers();
    public void insertUser(User user);
    public void updateUser(User user);
    public void deleteUser(User user);
}
