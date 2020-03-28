package com.hibernate1.dao;

import com.hibernate1.model.BankBranch;
import com.hibernate1.model.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BankRepository {

    @Autowired
    private SessionFactory sessionFactory;

    public void getAllPresentBranches(){
        List<BankBranch> listOfallBankBranches =sessionFactory.getCurrentSession().createQuery("from BankBranch").getResultList();
        System.out.println("ALL BANK BRANCHES" + listOfallBankBranches);
        System.out.println("Available Bank Branches are");
        for(int x=0; x<listOfallBankBranches.size(); x++){
            System.out.println(listOfallBankBranches.get(x).getId() + " ");
        }

    }
    public void saveUserDetails(User user) {
        sessionFactory.getCurrentSession().save(user);
    }

    public void deleteUserById(int id) {
        User user=sessionFactory.getCurrentSession().get(User.class, id);
        sessionFactory.getCurrentSession().delete(user);
    }

    public String findUserById(int id){
        User user=sessionFactory.getCurrentSession().get(User.class, id);
        return user.toString();
    }

    public void updateUserById(int id){
        User user=sessionFactory.getCurrentSession().get(User.class, id);
        user.setName("Animesh");
        sessionFactory.getCurrentSession().update(user);
    }

    public void saveBranchDetails(BankBranch bankBranch) {
        System.out.println("inside bank repo");
        sessionFactory.getCurrentSession().save(bankBranch);
    }

    public void deleteBranchById(int id) {
        BankBranch bankBranch=sessionFactory.getCurrentSession().get(BankBranch.class, id);
        sessionFactory.getCurrentSession().delete(bankBranch);
    }

    public BankBranch findBranchById(int id){
        BankBranch bankBranch=sessionFactory.getCurrentSession().get(BankBranch.class, id);
        return bankBranch; //.toString();
    }

    public void updateBranchById(int id,User user){
        BankBranch bankBranch=sessionFactory.getCurrentSession().get(BankBranch.class, id);
        bankBranch.setBranchName("SBI2");
        sessionFactory.getCurrentSession().update(bankBranch);
    }
}
