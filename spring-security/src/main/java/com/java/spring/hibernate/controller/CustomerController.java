package com.java.spring.hibernate.controller;

import com.java.spring.hibernate.dao.UserDAO;
import com.java.spring.hibernate.model.User;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller

// This class will be responsible for controlling the customer
@RequestMapping("/customer")
public class CustomerController {

    UserDAO userDAO;
    public CustomerController() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
    }

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

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public @ResponseBody String showCustomers() {
        return "SUCCESS";
    }
}
