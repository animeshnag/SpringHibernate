package com.app.controller;

import com.app.dao.BankDAO;
import com.app.dao.UserDAO;
import com.app.model.Bank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BankController
{
    @Autowired
    private BankDAO bankDAO;

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

    @RequestMapping(value = "/getAllBranches" )
    public List<Bank> getBranch()
    {
        return bankDAO.getAll();
    }

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

    /*@RequestMapping(value="/updateBranch", method = RequestMethod.POST)
    public Bank update(@RequestBody Bank bank)
    {
        bankDAO.updateBranch(bank);
        return bank;
    }*/
}


