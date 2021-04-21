package xyz.merccurion.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.merccurion.spring.dao.EmployeeDao;
import xyz.merccurion.spring.dao.RolesDao;
import xyz.merccurion.spring.exceptions.ResourceNotFoundException;
import xyz.merccurion.spring.model.Employee;
import xyz.merccurion.spring.model.Roles;

import java.util.List;
import java.util.Optional;

@Service
public class RolesService {

    @Autowired
    private final RolesDao rolesDao;
    private final EmployeeDao employeeDao;

    public RolesService(RolesDao rolesDao, EmployeeDao employeeDao) {
        this.rolesDao = rolesDao;
        this.employeeDao = employeeDao;
    }

    public Roles addRole(Roles role) {
        return rolesDao.save(role);
    }

    public Employee addEmployeeRole(int employeeId, int roleId) throws ResourceNotFoundException {
        Employee employeeAddRole = employeeDao.findById(employeeId).orElseThrow(() ->
                new ResourceNotFoundException("Employee (ID: " + employeeId + " not found."));
        Roles roleToAdd = rolesDao.findById(roleId).orElseThrow(() ->
                new ResourceNotFoundException("Role (ID: " + roleId + " not found."));
        List<Roles> employeeRoles = employeeAddRole.getRoles();
        employeeRoles.add(roleToAdd);
        return employeeDao.save(employeeAddRole);
    }

    public Roles getRole(int id) throws ResourceNotFoundException {
        return rolesDao.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Role (ID: " + id + " not found."));
    }

    public List<Roles> listRoles() {
        return rolesDao.findAll();
    }

    public Roles updateRole(int roleId, Roles role) throws ResourceNotFoundException {
        Roles updatedRole = rolesDao.findById(roleId).orElseThrow(() ->
                new ResourceNotFoundException("Role (ID: " + roleId + " not found."));

        updatedRole.setRole(role.getRole());
        return this.rolesDao.save(updatedRole);
    }

    public void deleteRole(int id) {
        rolesDao.deleteById(id);
    }
}
