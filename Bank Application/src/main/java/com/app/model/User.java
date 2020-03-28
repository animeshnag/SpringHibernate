package com.app.model;

import javax.persistence.*;

@Entity
@Table(name="user")
public class User
{
    @Id
    @Column(name="account_no")
    private String accountNo;

    @Column(name="full_name")
    private String fullName;

    @Column(name="adhar_no")
    private String adharNo;

    @Column(name="balance")
    private double balance;

    public User(){}

    public User(String accountNo, String fullName, String adharNo, double balance)
    {
        this.accountNo = accountNo;
        this.fullName = fullName;
        this.adharNo = adharNo;
        this.balance = balance;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getAdharNo() {
        return adharNo;
    }

    public void setAdharNo(String adharNo) {
        this.adharNo = adharNo;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "User{" +
                "accountNo=" + accountNo +
                ", fullName='" + fullName + '\'' +
                ", adharNo=" + adharNo +
                ", balance=" + balance +
                '}';
    }
}
