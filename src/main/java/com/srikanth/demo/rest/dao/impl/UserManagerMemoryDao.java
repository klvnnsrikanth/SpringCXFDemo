package com.srikanth.demo.rest.dao.impl;

import com.srikanth.demo.rest.dao.UserManagerDao;
import com.srikanth.demo.rest.model.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserManagerMemoryDao implements UserManagerDao
{
    private int nextUserId = 0;

    List<User> users = new ArrayList<User>();

    public User fetchUserById(Integer id)
    {
        for (User user : users)
        {
            if (user.getId().equals(id))
            {
                return user;
            }
        }

        throw new RuntimeException("User Not Found: " + id);
    }

    public List fetchAllUsers()
    {
        return users;
    }

    public void insertUser(User user)
    {
        user.setId(nextUserId++);
        users.add(user);
    }

    public void updateUser(User user)
    {
        User editUser = fetchUserById(user.getId());

        editUser.setBirthDate(user.getBirthDate());
        editUser.setCity(user.getCity());
        editUser.setEmail(user.getEmail());
        editUser.setName(user.getName());
        editUser.setState(user.getState());
    }

    public void deleteUser(User user)
    {
        User delUser = fetchUserById(user.getId());
        users.remove(delUser);
    }
}
