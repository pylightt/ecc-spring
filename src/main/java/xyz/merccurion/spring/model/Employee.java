package xyz.merccurion.spring.model;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name ="lastName", column = @Column(name = "last_name")),
            @AttributeOverride(name = "firstName", column = @Column(name = "first_name")),
            @AttributeOverride(name = "middleName", column = @Column(name = "middle_name")),
            @AttributeOverride(name = "suffix", column = @Column(name = "suffix")),
            @AttributeOverride(name = "title", column = @Column(name = "title"))
    })
    private Name name;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "streetNo", column = @Column(name = "street_no")),
            @AttributeOverride(name = "barangay", column = @Column(name = "barangay")),
            @AttributeOverride(name = "city", column = @Column(name = "city")),
            @AttributeOverride(name = "zip", column = @Column(name = "zip"))
    })
    private Address address;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "birthday", column = @Column(name = "birthday")),
            @AttributeOverride(name = "gwa", column = @Column(name = "gwa")),
            @AttributeOverride(name = "hireDate", column = @Column(name = "hire_date")),
            @AttributeOverride(name = "isHired", column = @Column(name = "hire_status"))
    })
    private Other other;

    @OneToMany(cascade = CascadeType.ALL, fetch=FetchType.LAZY)
    @JoinColumn(name="employee_id", referencedColumnName = "contactid")
    private List<Contact> contact = new ArrayList<>();

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch=FetchType.LAZY)
    @JoinTable(name = "employee_roles", joinColumns = {@JoinColumn(name = "employee_id")}, inverseJoinColumns = {@JoinColumn(name = "role_id")})
    private List<Roles> roles = new ArrayList<>();

    public Employee() {}

    public Employee(Name name, Address address, Other other) {
        this.name = name;
        this.address = address;
        this.other = other;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public Name getName() {
        return name;
    }
    public void setName(Name name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }
    public void setAddress(Address address) {
        this.address = address;
    }

    public Other getOther() {
        return other;
    }
    public void setOther(Other other){
        this.other = other;
    }

    public List<Contact> getContact() {
        return contact;
    }
    public void setContact(List<Contact> contact) {
        this.contact = contact;
    }

    public List<Roles> getRoles() {
        return roles;
    }
    public void setRoles(List<Roles> roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return  "[Id: " + id + "] " + name + "\n\t" +
                "Address:\n" + address + "\n\t" +
                "Other Information:\n" + other + "\n\t" +
                "Contact:\n" + contact + "\n\t" +
                "Roles:\n" + roles ;
    }
}
