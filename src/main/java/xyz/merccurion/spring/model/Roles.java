package xyz.merccurion.spring.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

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

    @ManyToMany(
            fetch = FetchType.EAGER,
            mappedBy = "roles",
            cascade = {CascadeType.DETACH,
                    CascadeType.PERSIST
//                    CascadeType.DETACH,
//                    CascadeType.MERGE,
//                    CascadeType.PERSIST
            })
    @JsonIgnore
    private List<Employee> employee = new ArrayList<Employee>();

    public Roles() {}

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
        return "\t\t" +
                "Role Id: " + roleId + "\t" +
                "Role: " + role;
    }
}
