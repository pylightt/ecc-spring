package xyz.merccurion.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import xyz.merccurion.spring.dao.EmployeeDao;
import xyz.merccurion.spring.dao.RolesDao;
import xyz.merccurion.spring.exceptions.ResourceNotFoundException;
import xyz.merccurion.spring.model.Employee;
import xyz.merccurion.spring.model.Roles;

import java.util.List;

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
        List<Employee> roleEmployees = roleToAdd.getEmployee();
        employeeRoles.add(roleToAdd);
        roleEmployees.add(employeeAddRole);
        return employeeDao.save(employeeAddRole);
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
        if(rolesDao.existsById(id)) rolesDao.deleteById(id);
    }

    public Employee deleteEmployeeRole(int employeeId, int roleId) throws ResourceNotFoundException {
        Employee employeeDeleteRole = employeeDao.findById(employeeId).orElseThrow(() ->
                new ResourceNotFoundException("Employee (ID: " + employeeId + " not found."));
        Roles roleToDelete = rolesDao.findById(roleId).orElseThrow(() ->
                new ResourceNotFoundException("Role (ID: " + roleId + " not found."));
        List<Roles> employeeRoles = employeeDeleteRole.getRoles();

        employeeRoles.remove(new Roles(roleToDelete.toString()));
        return employeeDao.save(employeeDeleteRole);
    }
}
