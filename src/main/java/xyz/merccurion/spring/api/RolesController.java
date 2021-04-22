package xyz.merccurion.spring.api;

import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import xyz.merccurion.spring.dao.EmployeeDao;
import xyz.merccurion.spring.exceptions.ResourceNotFoundException;
import xyz.merccurion.spring.model.Contact;
import xyz.merccurion.spring.model.Employee;
import xyz.merccurion.spring.model.Roles;
import xyz.merccurion.spring.service.RolesService;

import java.util.List;

@RestController
@RequestMapping("api/roles")
public class RolesController {

    @Autowired
    private final RolesService rolesService;

    public RolesController(RolesService rolesService) {
        this.rolesService = rolesService;
    }

    @PostMapping("/add")
    public Roles addRole(@RequestBody Roles role) {
        return this.rolesService.addRole(role);
    }

    @PostMapping("/addTo/{employeeId}/{roleId}")
    public ResponseEntity<Employee> addEmployeeRole(@PathVariable("employeeId") int employeeId,
                                                    @PathVariable("roleId") int roleId) throws ResourceNotFoundException {
        Employee addedEmployeeRole = rolesService.addEmployeeRole(employeeId,roleId);
        return ResponseEntity.ok(addedEmployeeRole);
    }

    @PutMapping("/update/{roleId}")
    public ResponseEntity<Roles> updateRole(@PathVariable("roleId") int roleId,
                                            @RequestBody Roles role) throws ResourceNotFoundException {
        Roles updatedRole = rolesService.updateRole(roleId, role);
        return ResponseEntity.ok(updatedRole);
    }

    @GetMapping("/all")
    public List<Roles> listRoles() {
        return this.rolesService.listRoles();
    }

    @DeleteMapping("/delete/{roleId}")
    public ResponseEntity<String> deleteRole(@PathVariable("roleId") int roleId) {
        rolesService.deleteRole(roleId);
        return new ResponseEntity<>("Role (ID: " + roleId + ") deleted.", HttpStatus.OK);
    }

}
