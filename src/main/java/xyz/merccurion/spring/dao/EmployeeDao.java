package xyz.merccurion.spring.dao;

import xyz.merccurion.spring.model.Employee;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.*;

@Repository
public interface EmployeeDao extends JpaRepository<Employee, Integer> {

    @Query(value = "SELECT * FROM employee ORDER BY gwa DESC", nativeQuery = true)
    Optional<List<Employee>> listEmployeeByGwaDesc();

    @Query(value = "SELECT * FROM employee ORDER BY gwa ASC", nativeQuery = true)
    Optional<List<Employee>> listEmployeeByGwaAsc();

    @Query(value = "SELECT * FROM employee ORDER BY hire_date DESC", nativeQuery = true)
    Optional<List<Employee>> listEmployeeByHireDateDesc();

    @Query(value = "SELECT * FROM employee ORDER BY hire_date ASC", nativeQuery = true)
    Optional<List<Employee>> listEmployeeByHireDateAsc();

    @Query(value = "SELECT * FROM employee ORDER BY last_name DESC", nativeQuery = true)
    Optional<List<Employee>> listEmployeeByLastNameDesc();

    @Query(value = "SELECT * FROM employee ORDER BY last_name ASC", nativeQuery = true)
    Optional<List<Employee>> listEmployeeByLastNameAsc();
}
