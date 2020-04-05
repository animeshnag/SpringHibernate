package com.java.spring.hibernate.dao;

import com.java.spring.hibernate.model.Bank;
import com.java.spring.hibernate.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class BankDAO
{
    private SessionFactory sessionFactory;
    UserDAO userdao=new UserDAO();
    public void setSessionFactory(SessionFactory sessionFactory)
    {
        this.sessionFactory = sessionFactory;
    }


    public void save(Bank bank)
    {
        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.persist(bank);
        tx.commit();
    }

    public String deleteBranchByBranchCode(int branchCode)
    {
        Session session=this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        System.out.println("branch code " + branchCode);

        List<Bank> bankToBeFinded = session.createQuery("from Bank b where b.branchCode = '"+branchCode+"' ").list();
        if(bankToBeFinded.isEmpty()){
            return "SORRY NO BANK BRANCH FOUND WITH BRANCH CODE " + branchCode;
        }
        else {
            System.out.println("BankToBeFinded " + bankToBeFinded);
            List<User> listOfAssociatedUsers = bankToBeFinded.get(0).getUsers();
            System.out.println("ListOfAssociatedUsers " + listOfAssociatedUsers);
            for (int x = 0; x < listOfAssociatedUsers.size(); x++) {
                session.delete(listOfAssociatedUsers.get(x));
            }
            session.delete(bankToBeFinded.get(0));
            tx.commit();
            return "The Branch has been deleted";
        }
    }

    public String updateBranch(Bank bank)
    {
        Session session=this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        int branchCode=bank.getBranchCode();
        System.out.println("******************************************************************************************");
        System.out.println("branch COde " + branchCode );

        List<Bank> bankToBeFinded = session.createQuery("from Bank b where b.branchCode = '"+branchCode+"' ").list();
        if(bankToBeFinded.isEmpty()){
            return "SORRY NO BANK BRANCH FOUND WITH BRANCH CODE " + branchCode;
        }
        else {

            List<User> oldListOfAssociatedUsers = bankToBeFinded.get(0).getUsers();
            List<User> newListOfAssociatedUsers = bank.getUsers();
            List<User> completeListOfAssociatedUsers = new ArrayList<User>();

            completeListOfAssociatedUsers.addAll(newListOfAssociatedUsers);
            completeListOfAssociatedUsers.addAll(oldListOfAssociatedUsers);
            System.out.println("******************************************************************************************");
            System.out.println("completeListOfAssociatedUsers " + completeListOfAssociatedUsers);
            for (int x = 0; x < oldListOfAssociatedUsers.size(); x++) {
                userdao.deleteUser(oldListOfAssociatedUsers.get(x));
            }
            bank.setUsers(completeListOfAssociatedUsers);
            session.update(bank);
            tx.commit();
            return "SUCCESSFULLY UPDATED";
        }
    }

    public void saveBranchUSer(Bank bank)
    {
        Session session=this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        System.out.println(bank.getUsers());
        System.out.println("Branch Code" + bank.getBranchCode());
        Random rand = new Random();

        List<User> addedListofUsers=bank.getUsers();
        for(int x=0; x<addedListofUsers.size(); x++){
            String randomNo = String.format("%04d", rand.nextInt(10000));
            String accountNo=bank.getBranchCode() + randomNo;
            addedListofUsers.get(x).setAccountNo(accountNo);
        }
        System.out.println("NEW DETAILS" + addedListofUsers);
        session.save(bank);
        session.getTransaction().commit();
    }

    @SuppressWarnings("unchecked")
    public List<Bank> getAll()
    {
        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        System.out.println("BANKDAO*************************************************************************************************\n\n\n");
        List<Bank> ListOfAllBank = session.createQuery("from Bank").list();
        if(ListOfAllBank.isEmpty()){

            List<Bank> bank=new ArrayList<Bank>();
            return bank;
        }
        else {
            System.out.println("BANKDAO else***********************************************************************\n\n\n");
            return ListOfAllBank;
        }
    }
}
