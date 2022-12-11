package com.example.NestEmployee_Backend.dao;


import com.example.NestEmployee_Backend.model.EmployeeModel;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeDao extends CrudRepository<EmployeeModel,Integer> {
}
