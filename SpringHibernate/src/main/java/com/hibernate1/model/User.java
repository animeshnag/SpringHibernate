package com.hibernate1.model;

import javax.persistence.*;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user")
public class User {

        @Id
        @GeneratedValue(strategy= GenerationType.IDENTITY)
        @Column(name="id")
        private int id;


        @Column(name="name")
        private String name;

        @Column(name="accountNumber")
        private String accountNumber;

        public User() {
        }

        public User(String name, String accountNumber) {
            this.name = name;
            this.accountNumber = accountNumber;
        }


        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }



    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", accountNumber='" + accountNumber + '\'' +
                '}';
    }
}








