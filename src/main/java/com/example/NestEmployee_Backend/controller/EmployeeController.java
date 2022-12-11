package com.example.NestEmployee_Backend.controller;

import com.example.NestEmployee_Backend.dao.EmployeeDao;
import com.example.NestEmployee_Backend.model.EmployeeModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

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

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/emplogin", consumes = "application/json", produces = "application/json")
    public HashMap<String, String> EmpLogin(@RequestBody EmployeeModel e){

        String email=String.valueOf(e.getEmail());
        String password=String.valueOf(e.getPassword());
        List<EmployeeModel> result=(List<EmployeeModel>) dao.empLogin(email, password);
        HashMap<String,String> st=new HashMap<>();
        if (result.size()==0)
        {
            st.put("status","failed");
        }
        else
        {
            int id=result.get(0).getId();
            st.put("userid",String.valueOf(id));
            st.put("status","success");
        }
        return st;
    }

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/profileview",consumes = "application/json",produces = "application/json")
    public List<EmployeeModel> ProfileView(@RequestBody EmployeeModel u)
    {
        return (List<EmployeeModel>) dao.profileView(u.getId());

    }

    @CrossOrigin(origins = "*")
    @GetMapping(path = "/viewemployee")
    public List<EmployeeModel> ProfileView()
    {
        return (List<EmployeeModel>) dao.findAll();

    }

}
