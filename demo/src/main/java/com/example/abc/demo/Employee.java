package com.example.abc.demo;


import com.fasterxml.jackson.annotation.JsonView;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;

import java.util.Objects;


@Entity
@Builder
@Table(name = "employee")
public class Employee {

    @Id
    @Column
    @JsonView(value = {EmpView.UserView.Post.class})
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    @NotBlank(message = "first name should not be empty")
    private String firstName;

    @NotBlank(message = "last name should not be empty")
    private String lastName;

    @NotBlank(message = "DOB should not be null")
    private String dateOfBirth;

    @NotBlank(message = "salary must be provided")
    private String salary;

    @NotBlank(message = "Joinning date should not be null")
    private String joinDate;

    @NotBlank(message = "dept should not be null")
    private String department;

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public String getSalary() {
        return salary;
    }

    public String getJoinDate() {
        return joinDate;
    }

    public String getDepartement() {
        return department;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public void setJoinDate(String joinDate) {
        this.joinDate = joinDate;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}