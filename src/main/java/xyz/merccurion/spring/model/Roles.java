package xyz.merccurion.spring.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

@Entity
@Table(name="roles")
public class Roles implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int roleid;

    @Column(name = "role")
    private String role;

    @ManyToMany(mappedBy = "employee_roles", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<Employee> employee = new ArrayList<>();

    public Roles() {}

    public Roles(String role) {
        this.role = role;
    }

    public int getRoleid() {
        return roleid;
    }
    public void setRoleid(int roleid) {
        this.roleid = roleid;
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
        return "\t\t" +
                "Role Id: " + roleid + "\t" +
                "Role: " + role;
    }
}
