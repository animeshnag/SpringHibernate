package com.app.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="bank")
public class Bank
{
    @Id
    @Column(name="branch_code")
    private int branchCode;

    @Column(name="branch_name")
    private String branchName;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name="bank_branch_code")
    private List<User> users;

    public Bank() { }

    public Bank(int branchCode, String branchName) {
        this.branchCode = branchCode;
        this.branchName = branchName;
    }

    public int getBranchCode() {
        return branchCode;
    }

    public void setBranchCode(int branchCode) {
        this.branchCode = branchCode;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }


    @Override
    public String toString() {
        return "Bank{" +
                "branchCode=" + branchCode +
                ", branchName='" + branchName + '\'' +
                '}';
    }

    public void add(User user)
    {
        if(users==null)
            users=new ArrayList<>();
        users.add(user);
    }
}
