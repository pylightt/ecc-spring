package xyz.merccurion.spring.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import xyz.merccurion.spring.exceptions.ResourceNotFoundException;
import xyz.merccurion.spring.model.Employee;
import xyz.merccurion.spring.service.EmployeeService;

import java.util.List;

@RestController
@RequestMapping("api/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    // add employee
    @PostMapping("/add")
    public Employee addEmployee(@RequestBody Employee employee) {
        return this.employeeService.addEmployee(employee);
    }

    // get employees
    @GetMapping("/all")
    public Page<Employee> getAllEmployee(Pageable pageable) {
        return this.employeeService.getAllEmployee(pageable);
    }

    // get employees by gwa
    @GetMapping("/gwa/desc")
    public List<Employee> listEmployeeByGwaDesc() {
        return this.employeeService.listEmployeeByGwaDesc();
    }
    @GetMapping("/gwa/asc")
    public List<Employee> listEmployeeByGwaAsc() {
        return this.employeeService.listEmployeeByGwaAsc();
    }

    // get employees by date hired
    @GetMapping("/hiredate/desc")
    public List<Employee> listEmployeeByHireDateDesc() {
        return this.employeeService.listEmployeeByHireDateDesc();
    }
    @GetMapping("/hiredate/asc")
    public List<Employee> listEmployeeByHireDateAsc() {
        return this.employeeService.listEmployeeByHireDateAsc();
    }

    // get employees by last name
    @GetMapping("/lastname/desc")
    public List<Employee> listEmployeeByLastnameDesc() {
        return this.employeeService.listEmployeeByLastNameDesc();
    }
    @GetMapping("/lastname/asc")
    public List<Employee> listEmployeeByLastnameAsc() {
        return this.employeeService.listEmployeeByLastNameAsc();
    }

    // update employee
    @PutMapping("/update/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable("id") int id, @RequestBody Employee employee) throws ResourceNotFoundException {
        Employee updatedEmployee = employeeService.updateEmployee(id, employee);
        return ResponseEntity.ok(updatedEmployee);
    }

    // delete employee
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable("id") int id) throws ResourceNotFoundException {
        employeeService.deleteEmployee(id);
        return new ResponseEntity<>("Employee (ID: " + id + ") deleted.", HttpStatus.OK);
    }
}
