package com.example.abc.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmpService {

    Logger logger = LoggerFactory.getLogger(EmpService.class);

    @Autowired
    private EmpRepo empRepo;

    public Employee savedata(Employee emp) {
        Employee e = empRepo.save(emp);
        return e;
    }

    public Optional<Employee> getEmpById(int id) {
        Optional<Employee> emp = empRepo.findById(id);
        return emp;
    }

    public List<Employee> getEmpData(String name, String fromSalary , String toSalary) {
        List<Employee> empList = null;
        if(name.isEmpty()) {
            if (!toSalary.isEmpty() && fromSalary.isEmpty()) {
                empList = empRepo.findBySalaryLessThanEqual(toSalary);
            } else if (toSalary.isEmpty() && !fromSalary.isEmpty()) {
                empList = empRepo.findBySalaryGreaterThanEqual(fromSalary);
            } else if (!toSalary.isEmpty() && !fromSalary.isEmpty()) {
                empList = empRepo.findBySalaryGreaterThanEqualAndSalaryLessThanEqual(fromSalary, toSalary);
            }
        } else if (!name.isEmpty()){
            empList = empRepo.findByFirstNameOrLastName(name,name);
        }
        return empList == null ? empRepo.findAll() : empList;
    }
}
