package com.example.NestEmployee_Backend.dao;


import com.example.NestEmployee_Backend.model.EmployeeModel;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EmployeeDao extends CrudRepository<EmployeeModel,Integer> {

    @Query(value = "SELECT `id`, `designation`, `email`, `empcode`, `empname`, `password`, `phone`, `salary` FROM `employee` WHERE `email`=:email AND `password`=:password",nativeQuery = true)
    public List<EmployeeModel> empLogin(@Param("email") String email, @Param("password") String password);

    @Query(value = "SELECT `id`, `designation`, `email`, `empcode`, `empname`, `password`, `phone`, `salary` FROM `employee` WHERE `id`=:id",nativeQuery = true)
    public  List<EmployeeModel> profileView(@Param("id") Integer id);
}
