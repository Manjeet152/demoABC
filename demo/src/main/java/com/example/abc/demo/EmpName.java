package com.example.abc.demo;

import jakarta.persistence.Embeddable;

import java.io.Serializable;

public class EmpName implements Serializable {
    private String firstName;
    private String lastName;

    public EmpName(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public EmpName() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

}
