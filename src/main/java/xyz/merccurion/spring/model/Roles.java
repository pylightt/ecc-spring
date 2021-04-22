package xyz.merccurion.spring.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

@Entity
@Table(name="roles")
public class Roles implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "role_id", updatable = false, nullable = false)
    private int roleId;

    private String role;

    @ManyToMany(mappedBy = "roles", cascade = CascadeType.PERSIST)
    @JsonIgnore
    private List<Employee> employee = new ArrayList<Employee>();


    public Roles(String role) {
        this.role = role;
    }

    public int getRoleId() {
        return roleId;
    }
    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public String getRole() {
        return role;
    }
    public void setRole(String role) {
        this.role = role;
    }

    public List<Employee> getEmployee() {
        return employee;
    }
    public void setEmployee(List<Employee> employee) {
        this.employee = employee;
    }

    @Override
    public String toString() {
        return role;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Roles) {
            Roles r = (Roles) obj;
            return true;
        }
        return false;
    }

    @PreRemove
    public void removeRoleFromEmployee() {
        for (Employee e : employee) {
            e.getRoles().remove(this);
        }
    }
 }
