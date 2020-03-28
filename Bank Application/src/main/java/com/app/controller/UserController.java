package com.app.controller;

import com.app.dao.UserDAO;
import com.app.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController
{
    @Autowired
    private UserDAO userDAO;

    @RequestMapping(value = "/saveUser", method = RequestMethod.POST)
    public User addUser(@RequestBody User user)
    {
        userDAO.save(user);
        return user;
    }

    @RequestMapping(value = "/getAllUsers" )
    public List<User> getUser()
    {
        return userDAO.getAll();
    }

    @RequestMapping(value = "/deleteUserByAccountNumber/{accountNumber}", method = RequestMethod.GET)
    public @ResponseBody String deleteUserByAccountNumber(@PathVariable String accountNumber)
    {    userDAO.deleteUserByAccountNumber(accountNumber);
        return "SUCCESS";
    }

    @RequestMapping(value = "/CreditBalanceWithAccountNumber/{accountNumber}", method = RequestMethod.POST)
    public @ResponseBody String CreditBalanceWithAccountNumber(@PathVariable String accountNumber, @RequestBody User u)
    {
        return userDAO.CreditBalanceWithAccountNumber(accountNumber, u);
    }

    @RequestMapping(value = "/DebitBalanceWithAccountNumber/{accountNumber}", method = RequestMethod.POST)
    public @ResponseBody String DebitBalanceWithAccountNumber(@PathVariable String accountNumber, @RequestBody User u)
    {
        return userDAO.DebitBalanceWithAccountNumber(accountNumber, u);
    }

    @RequestMapping(value="/updateUser", method = RequestMethod.POST)
    public User update(@RequestBody User user)
    {
        userDAO.updateUser(user);
        return user;
    }
}

