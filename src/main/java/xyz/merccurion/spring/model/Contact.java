package xyz.merccurion.spring.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "contact")
public class Contact implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int contactId;

    private String landline;

    private String mobile;

    private String email;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Employee employee;

    public Contact() {}

    public Contact(String landline, String mobile, String email){
        this.landline = landline;
        this.mobile = mobile;
        this.email = email;
    }

    public int getContactId() {
        return contactId;
    }
    public void setContactId(int contactId) {
        this.contactId = contactId;
    }

    public String getLandline() {
        return landline;
    }
    public void setLandline(String landline) {
        this.landline = landline;
    }

    public String getMobile() {
        return mobile;
    }
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public Employee getEmployee() {
        return employee;
    }
    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    @Override
    public String toString() {
        return "\t\t" +
                "contactId: " + contactId + "\n" +
                "Landline: " + landline + "\n\t\t" +
                "Mobile: " + mobile + "\n\t\t" +
                "E-mail: " + email;
    }
}
