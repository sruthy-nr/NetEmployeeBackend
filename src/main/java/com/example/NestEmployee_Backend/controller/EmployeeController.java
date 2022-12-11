package com.example.NestEmployee_Backend.controller;

import com.example.NestEmployee_Backend.dao.EmployeeDao;
import com.example.NestEmployee_Backend.model.EmployeeModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public class EmployeeController {

    @Autowired
    EmployeeDao dao;

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/", consumes = "application/json", produces = "application/json")
    public String Homepage(){
        return "WELCOME TO MY WEBSITE";
    }

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/addemployee", consumes = "application/json", produces = "application/json")
    public HashMap<String,String> AddEmployee(@RequestBody EmployeeModel e){
        HashMap<String,String> map=new HashMap<>();
        map.put("status","success");
        dao.save(e);
        return map;
    }
}
