package com.example.NestEmployee_Backend.controller;

import com.example.NestEmployee_Backend.dao.TaskDao;
import com.example.NestEmployee_Backend.model.EmployeeModel;
import com.example.NestEmployee_Backend.model.TaskModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class TaskController {

    @Autowired
    TaskDao dao;

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/addtask", consumes = "application/json", produces = "application/json")
    public HashMap<String,String> AddTask(@RequestBody TaskModel t) {
        HashMap<String, String> map = new HashMap<>();
        map.put("status", "success");
        dao.save(t);
        return map;
    }

    @CrossOrigin("*")
    @PostMapping(path = "/userviewtask", consumes = "application/json", produces = "application/json")
    public List<TaskModel> UserViewTask(@RequestBody TaskModel t){

        return (List<TaskModel>) dao.userViewTask(t.getEmpid());
    }

    @CrossOrigin("*")
    @PostMapping(path = "/updatestatus", consumes = "application/json", produces = "application/json")
    public Map<String,String> UpdateStatus(@RequestBody TaskModel t){
        String tid=String.valueOf(t.getEmpid());
        System.out.println(tid);
        dao.updateStatus(t.getEmpid(),t.getStatus());
        HashMap<String,String> map=new HashMap<>();
        map.put("status","success");
        return map;
    }

}
