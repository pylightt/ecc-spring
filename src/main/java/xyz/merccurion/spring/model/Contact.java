package xyz.merccurion.spring.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "contact")
public class Contact implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int contactid;

    @Column(name = "landline")
    private String landline;

    @Column(name = "mobile")
    private String mobile;

    @Column(name = "email")
    private String email;

    @Transient
    private Employee employee;

    public Contact() {}

    public Contact(String landline, String mobile, String email){
        this.landline = landline;
        this.mobile = mobile;
        this.email = email;
    }

    public int getContactid() {
        return contactid;
    }
    public void setContactid(int contactid) {
        this.contactid = contactid;
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
                "Id: " + contactid + "\n" +
                "Landline: " + landline + "\n\t\t" +
                "Mobile: " + mobile + "\n\t\t" +
                "E-mail: " + email;
    }
}
