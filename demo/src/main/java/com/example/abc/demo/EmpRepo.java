package com.example.abc.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmpRepo extends JpaRepository<Employee, Integer> {


    List<Employee> findByJoinDateLessThanEqual(String toSalary);

    List<Employee> findByJoinDateGreaterThanEqual(String fromSalary);

    List<Employee> findByJoinDateGreaterThanEqualAndJoinDateLessThanEqual(String fromSalary, String toSalary);

    List<Employee> findByFirstNameOrLastName(String name, String name1);
}
