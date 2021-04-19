package xyz.merccurion.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.merccurion.spring.dao.EmployeeDao;
import xyz.merccurion.spring.model.Employee;

@Service
public class EmployeeService {

    private final EmployeeDao employeeDao;

    @Autowired
    public EmployeeService(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    public int addEmployee(Employee employee) {
        return employeeDao.addEmployee(employee);
    }

}
