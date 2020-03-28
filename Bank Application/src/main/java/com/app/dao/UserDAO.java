package com.app.dao;

import com.app.model.Bank;
import com.app.model.User;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDAO
{
    @Autowired
    private SessionFactory sessionFactory;
    public void setSessionFactory(SessionFactory sessionFactory)
    {
        this.sessionFactory = sessionFactory;
    }

    public void save(User user)
    {
        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.persist(user);
        tx.commit();
    }

    //@SuppressWarnings("unchecked")
    public List<User> getAll()
    {
        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        List<User> personList = session.createQuery("from User").list();
        return personList;
    }

    public String CreditBalanceWithAccountNumber(String accountNumber, User u){
        Session session=this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        double balance = u.getBalance();
        System.out.println("*************************************************************\nBalance " + balance);
        List<User> userToBeFinded = session.createQuery("from User u where u.accountNo = '"+accountNumber+"' ").list();
        if(userToBeFinded.isEmpty()){
            return "SORRY NO USER FOUND WITH ACCOUNT NUMBER " + accountNumber;
        }
        else {
            double presentBalance = userToBeFinded.get(0).getBalance();
            double balanceAfterCredit = presentBalance + balance;
            userToBeFinded.get(0).setBalance(balanceAfterCredit);
            session.update(userToBeFinded.get(0));
            tx.commit();
            return "YOUR ACCOUNT HAS BEEN SUCCESSFULLY CREDITED\nYOUR BALANCE AFTER CREDIT IS " + balanceAfterCredit;
        }
    }

    public String DebitBalanceWithAccountNumber(String accountNumber, User u){
        Session session=this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        double balanceToBeWithdrawn = u.getBalance();
        List<User> userToBeFinded = session.createQuery("from User u where u.accountNo = '"+accountNumber+"' ").list();
        if(userToBeFinded.isEmpty()){
            return "SORRY NO USER FOUND WITH ACCOUNT NUMBER " + accountNumber;
        }
        else {
            double presentBalance = userToBeFinded.get(0).getBalance();
            if (presentBalance < balanceToBeWithdrawn) {
                return "Sorry Insufficient Balance\nYour balance is " + presentBalance;
            }
            else {
                double amountAfterDeduction = presentBalance - balanceToBeWithdrawn;
                userToBeFinded.get(0).setBalance(amountAfterDeduction);
                session.update(userToBeFinded.get(0));
                tx.commit();
                return "YOUR ACCOUNT HAS BEEN SUCCESSFULLY DEBITED\nYOUR BALANCE AFTER DEDUCTION IS " + amountAfterDeduction;
            }
        }
    }

    public void deleteUserByAccountNumber(String accountNumber)
    {
        Session session=this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        System.out.println("AccountNumber " + accountNumber);

        List<User> userToBeFinded = session.createQuery("from User u where u.accountNo = '"+accountNumber+"' ").list();
        System.out.println("*************************************************\nUserToBeFinded " + userToBeFinded);
        session.delete(userToBeFinded.get(0));
        tx.commit();
    }

    public void updateUser(User user)
    {
        Session session=this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.update(user);
        tx.commit();
    }
    public  void deleteUser(User user)
    {
        System.out.println("**********************************************************************************");
        System.out.println("INSIDE DELETE USER");
        Session session=this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.delete(user);
        tx.commit();
    }
}
