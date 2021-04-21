package xyz.merccurion.spring.api;

import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import xyz.merccurion.spring.exceptions.ResourceNotFoundException;
import xyz.merccurion.spring.model.Contact;
import xyz.merccurion.spring.model.Employee;
import xyz.merccurion.spring.model.Roles;
import xyz.merccurion.spring.service.RolesService;

@RestController
@RequestMapping("api/roles")
public class RolesController {

    @Autowired
    private final RolesService rolesService;

    public RolesController(RolesService rolesService) {
        this.rolesService = rolesService;
    }

    @PostMapping("/addRole")
    public ResponseEntity<Roles> addRole(Roles role) {
        return ResponseEntity.ok(role);
    }

    @PostMapping("/addEmployeeRole/{employeeId}/{roleId}")
    public ResponseEntity<Employee> addEmployeeRole(@PathVariable("employeeId") int employeeId,
                                                    @PathVariable("roleId") int roleId) throws ResourceNotFoundException {
        Employee addedEmployeeRole = rolesService.addEmployeeRole(employeeId,roleId);
        return ResponseEntity.ok(addedEmployeeRole);
    }

    public ResponseEntity<Roles> updateRole(@PathVariable("roleId") int roleId,
                                            @RequestBody Roles role) throws ResourceNotFoundException {
        Roles updatedRole = rolesService.updateRole(roleId, role);
        return ResponseEntity.ok(updatedRole);
    }

    @DeleteMapping("/deleteRole/{id}")
    public ResponseEntity<String> deleteRole(@PathVariable("roleId") int roleId) {
        rolesService.deleteRole(roleId);
        return new ResponseEntity<>("Role (ID: " + roleId + ") deleted.", HttpStatus.OK);
    }

}
