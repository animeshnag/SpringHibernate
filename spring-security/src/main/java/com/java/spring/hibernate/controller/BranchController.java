package com.java.spring.hibernate.controller;

import com.java.spring.hibernate.dao.BankDAO;
import com.java.spring.hibernate.model.Bank;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping(value = "/branch")
public class BranchController {

    BankDAO bankDAO;
    public BranchController() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
    }
    @RequestMapping(value = "/saveBranch", method = RequestMethod.POST)
    public Bank addBranch(@RequestBody Bank bank)
    {
        bankDAO.save(bank);
        return bank;
    }

    @RequestMapping(value = "/saveBranchUser", method = RequestMethod.POST)
    public Bank addBranchUser(@RequestBody Bank bank)
    {
        bankDAO.saveBranchUSer(bank);
        return bank;
    }

    /*@RequestMapping(value = "/getAllBranches" )
    public List<Bank> getBranch()
    {
        return bankDAO.getAll();
    }*/

    @RequestMapping(value = "/deleteBranchByBranchCode/{branchCode}", method = RequestMethod.GET)
    public @ResponseBody String deleteBranchByBranchCode(@PathVariable("branchCode") int branchCode)
    {
        return bankDAO.deleteBranchByBranchCode(branchCode);
    }

    @RequestMapping(value="/updateBranch", method = RequestMethod.POST)
    public String update(@RequestBody Bank bank)
    {
        return bankDAO.updateBranch(bank);
    }

    @RequestMapping(value = "/getAllBranches" )
    public String getBranch()
    {
        return "SUCCESS";
    }
}
