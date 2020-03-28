package com.hibernate1.model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "bankBranch")
public class BankBranch {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="branchName")
    private String branchName;

    @OneToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
    @JoinColumn(name="branchId")
    private List<User> listOfusers;

    public BankBranch() {
    }

    public BankBranch(String branchName) {
        //this.id = id;
        this.branchName = branchName;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public List<User> getUserList() {
        return listOfusers;
    }

    public void setUserList(List<User> listOfusers) {
        this.listOfusers = listOfusers;
    }

    // add a convenience method

    public void addUsers(User user) {

        if (listOfusers == null) {
            listOfusers = new ArrayList<>();
        }
        listOfusers.add(user);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "BankBranch{" +
                "id=" + id +
                ", branchName='" + branchName + '\'' +
                ", listOfusers=" + listOfusers +
                '}';
    }
}