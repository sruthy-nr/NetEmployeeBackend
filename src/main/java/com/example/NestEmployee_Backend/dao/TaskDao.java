package com.example.NestEmployee_Backend.dao;

import com.example.NestEmployee_Backend.model.TaskModel;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TaskDao extends CrudRepository<TaskModel,Integer> {

    @Query(value = "SELECT `id`, `empid`, `status`, `task` FROM `task` WHERE `empid`= :empid",nativeQuery = true)
    public List<TaskModel> userViewTask(@Param("empid") int empid);

    @Modifying
    @Transactional
    @Query(value = "UPDATE `task` SET `status`=:status WHERE `empid`= :empid",nativeQuery = true)
    void updateStatus(@Param("empid") Integer empid, @Param("status") String status);

}
