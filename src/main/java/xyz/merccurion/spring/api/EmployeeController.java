package xyz.merccurion.spring.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import xyz.merccurion.spring.exceptions.ResourceNotFoundException;
import xyz.merccurion.spring.model.Employee;
import xyz.merccurion.spring.service.EmployeeService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/")
public class EmployeeController {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    // add employee
    @PostMapping("employee")
    public Employee addEmployee(@RequestBody Employee employee) {
        return this.employeeService.addEmployee(employee);
    }

    // get employees
    @GetMapping("employee")
    public List<Employee> getAllEmployee() {
        return this.employeeService.getAllEmployee();
    }

    // get employees by gwa
    @GetMapping("employee/gwa/desc")
    public List<Employee> listEmployeeByGwaDesc() {
        return this.employeeService.listEmployeeByGwaDesc();
    }
    @GetMapping("employee/gwa/asc")
    public List<Employee> listEmployeeByGwaAsc() {
        return this.employeeService.listEmployeeByGwaAsc();
    }

    // get employees by date hired
    @GetMapping("/employee/hiredate/desc")
    public List<Employee> listEmployeeByHireDateDesc() {
        return this.employeeService.listEmployeeByHireDateDesc();
    }
    @GetMapping("/employee/hiredate/asc")
    public List<Employee> listEmployeeByHireDateAsc() {
        return this.employeeService.listEmployeeByHireDateAsc();
    }

    // get employees by last name
    @GetMapping("/employee/lastname/desc")
    public List<Employee> listEmployeeByLastnameDesc() {
        return this.employeeService.listEmployeeByLastNameDesc();
    }
    @GetMapping("/employee/lastname/asc")
    public List<Employee> listEmployeeByLastnameAsc() {
        return this.employeeService.listEmployeeByLastNameAsc();
    }

    // update employee
    @PutMapping("employee/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable("id") int id, @RequestBody Employee employee) throws ResourceNotFoundException {
        Employee updatedEmployee = employeeService.updateEmployee(id, employee);
        return ResponseEntity.ok(updatedEmployee);
    }

    // delete employee
    @DeleteMapping("employee/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable("id") int id) {
        employeeService.deleteEmployee(id);
        return new ResponseEntity<>("Employee (ID: " + id + ") deleted.", HttpStatus.OK);
    }
}
