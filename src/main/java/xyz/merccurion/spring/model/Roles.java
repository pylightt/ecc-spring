package xyz.merccurion.spring.model;

import javax.persistence.Embeddable;
import java.util.LinkedHashSet;
import java.util.Set;

@Embeddable
public class Roles {
    private int roleid;
    private String role;
    private Set<Employee> employee = new LinkedHashSet<Employee>();

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

    public Set<Employee> getEmployee() {
        return employee;
    }
    public void setEmployee(Set<Employee> employee) {
        this.employee = employee;
    }

    @Override
    public String toString() {
        return "\t\t" +
                "Role Id: " + roleid + "\t" +
                "Role: " + role;
    }
}
