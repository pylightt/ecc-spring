package xyz.merccurion.spring.dao;

import xyz.merccurion.spring.model.Employee;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.*;

public interface EmployeeDao {

    int addEmployee(Employee employee);

//    @Query(value = "SELECT * FROM employee ORDER BY hire_date DESC", nativeQuery = true)
//    Optional<List<Employee>> listEmployeeByHireDate();
//
//    @Query(value = "SELECT * FROM employee ORDER BY last_name ASC", nativeQuery = true)
//    Optional<List<Employee>> listEmployeeByLastName();
}
