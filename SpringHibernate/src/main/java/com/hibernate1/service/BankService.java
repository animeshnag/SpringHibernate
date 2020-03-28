package com.hibernate1.service;

import com.hibernate1.dao.BankRepository;
import com.hibernate1.model.BankBranch;
import com.hibernate1.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import javax.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class BankService {

    @Autowired
    private BankRepository bankRepository;

    @Transactional
    public void getAllPresentBranches(){
        bankRepository.getAllPresentBranches();
    }

    @Transactional
    public void saveBranchDetails(BankBranch bankBranch) {

        System.out.println("inside bank service");
        bankRepository.saveBranchDetails(bankBranch);
    }


    @Transactional
    public void saveUserDetails(User user) {
        bankRepository.saveUserDetails(user);
    }

    @Transactional
    public BankBranch findBranchById(int id) {
        return bankRepository.findBranchById(id);
    }

    @Transactional
    public BankBranch updateBranchById(int id,User user) {
        return bankRepository.findBranchById(id);
    }
}
