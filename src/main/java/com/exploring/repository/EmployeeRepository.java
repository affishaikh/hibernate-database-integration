package com.exploring.repository;


import com.exploring.model.Employee;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Integer> {

    @Query(value = "select * from emplyee", nativeQuery = true)
    List<Employee> getAll();
}

