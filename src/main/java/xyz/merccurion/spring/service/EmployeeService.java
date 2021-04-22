package xyz.merccurion.spring.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import xyz.merccurion.spring.dao.EmployeeDao;
import xyz.merccurion.spring.exceptions.ResourceNotFoundException;
import xyz.merccurion.spring.model.Employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private final EmployeeDao employeeDao;

    public EmployeeService(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    public Employee addEmployee(Employee employee) {
        return employeeDao.save(employee);
    }

    // GET / LIST //
    public Page<Employee> getAllEmployee(Pageable pageable) {
        return employeeDao.findAll(pageable);
    }

    public List<Employee> listEmployeeByGwaDesc() {
        Optional<List<Employee>> employeeByGwa = employeeDao.listEmployeeByGwaDesc();
        return employeeByGwa.orElse(null);
    }
    public List<Employee> listEmployeeByGwaAsc() {
        Optional<List<Employee>> employeeByGwa = employeeDao.listEmployeeByGwaAsc();
        return employeeByGwa.orElse(null);
    }

    public List<Employee> listEmployeeByLastNameDesc() {
        Optional<List<Employee>> employeeByLastName = employeeDao.listEmployeeByLastNameDesc();
        return employeeByLastName.orElse(null);
    }
    public List<Employee> listEmployeeByLastNameAsc() {
        Optional<List<Employee>> employeeByLastName = employeeDao.listEmployeeByLastNameAsc();
        return employeeByLastName.orElse(null);
    }

    public List<Employee> listEmployeeByHireDateDesc() {
        Optional<List<Employee>> employeeByHireDate = employeeDao.listEmployeeByHireDateDesc();
            return employeeByHireDate.orElse(null);
    }
    public List<Employee> listEmployeeByHireDateAsc() {
        Optional<List<Employee>> employeeByHireDate = employeeDao.listEmployeeByHireDateAsc();
        return employeeByHireDate.orElse(null);
    }

    public Employee updateEmployee(int id, Employee employee) throws ResourceNotFoundException {
        Employee updatedEmployee = employeeDao.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Employee (ID: " + id + " not found."));

        updatedEmployee.getName().setLastName(employee.getName().getLastName());
        updatedEmployee.getName().setFirstName(employee.getName().getFirstName());
        updatedEmployee.getName().setMiddleName(employee.getName().getMiddleName());
        updatedEmployee.getName().setSuffix(employee.getName().getSuffix());
        updatedEmployee.getName().setTitle(employee.getName().getTitle());

        updatedEmployee.getAddress().setStreetNo(employee.getAddress().getStreetNo());
        updatedEmployee.getAddress().setBarangay(employee.getAddress().getBarangay());
        updatedEmployee.getAddress().setCity(employee.getAddress().getCity());
        updatedEmployee.getAddress().setZip(employee.getAddress().getZip());

        updatedEmployee.getOther().setBirthday(employee.getOther().getBirthday());
        updatedEmployee.getOther().setHireDate(employee.getOther().getHireDate());
        updatedEmployee.getOther().setGwa(employee.getOther().getGwa());
        updatedEmployee.getOther().setHired(employee.getOther().isHired());

        return this.employeeDao.save(updatedEmployee);
    }

    public void deleteEmployee(int id) throws ResourceNotFoundException {
        if(employeeDao.existsById(id)) employeeDao.deleteById(id);
    }
}
