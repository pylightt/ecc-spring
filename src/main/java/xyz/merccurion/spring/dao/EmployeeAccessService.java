package xyz.merccurion.spring.dao;

import xyz.merccurion.spring.model.Employee;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class EmployeeAccessService implements EmployeeDao {

    private static List<Employee> employeeList = new ArrayList<>();

    @Override
    public int addEmployee(Employee employee) {
        employeeList.add(new Employee(employee.getName(), employee.getAddress(), employee.getOther()));
        return 1;
    }
}
