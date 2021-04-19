package xyz.merccurion.spring.api;

import org.springframework.beans.factory.annotation.Autowired;
import xyz.merccurion.spring.model.Employee;
import xyz.merccurion.spring.service.EmployeeService;

public class EmployeeController {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    public void addEmployee(Employee employee) {
        employeeService.addEmployee(employee);
    }
}
