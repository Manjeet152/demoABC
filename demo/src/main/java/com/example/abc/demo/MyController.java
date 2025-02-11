package com.example.abc.demo;

import com.fasterxml.jackson.annotation.JsonView;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class MyController {

    Logger logger = LoggerFactory.getLogger(MyController.class);

    @Autowired
    private EmpService empService;

    @PostMapping(path = "/employees", consumes={ "application/json" })
    @JsonView(value = {EmpView.UserView.Post.class})
    public ResponseEntity<Object> saveEmp(@RequestBody @Valid Employee emp) {
        Employee e = empService.savedata(emp);
        return ResponseEntity.status(HttpStatus.CREATED).body(e);
    }

    @GetMapping(path = "/employees/{id}")
    public ResponseEntity<Object> getEmpWithId(@PathVariable @Valid int id){

        Optional<Employee> e = empService.getEmpById(id);
        return ResponseEntity.status(HttpStatus.OK).body(e);
    }


    @GetMapping(path = "/employeeList")
    public ResponseEntity<Object> getEmpData(@RequestParam(required = false) String name,
                                             @RequestParam(required = false) String fromSalary,
                                             @RequestParam(required = false) String  toSalary){

        List<Employee> empList = empService.getEmpData(name,fromSalary,toSalary);
        return ResponseEntity.status(HttpStatus.OK).body(empList);
    }

}