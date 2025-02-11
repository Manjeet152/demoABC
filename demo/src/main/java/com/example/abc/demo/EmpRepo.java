package com.example.abc.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmpRepo extends JpaRepository<Employee, Integer> {


    List<Employee> findBySalaryLessThanEqual(String toSalary);

    List<Employee> findBySalaryGreaterThanEqualAndSalaryLessThanEqual(String fromSalary, String toSalary);

    List<Employee> findBySalaryGreaterThanEqual(String fromSalary);

    List<Employee> findByFirstNameOrLastName(String name, String name1);
}
