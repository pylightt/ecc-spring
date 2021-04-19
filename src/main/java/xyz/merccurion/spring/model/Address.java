package xyz.merccurion.spring.model;

import javax.persistence.Embeddable;

@Embeddable
public class Address {
    private String streetNo;
    private String barangay;
    private String city;
    private int zip;

    public Address() {
    }

    public Address(String streetNo, String barangay, String city, int zip) {
        this.streetNo = streetNo;
        this.barangay = barangay;
        this.city = city;
        this.zip = zip;
    }

    public String getStreetNo() {
        return streetNo;
    }
    public void setStreetNo(String streetNo) {
        this.streetNo = streetNo;
    }

    public String getBarangay() {
        return barangay;
    }
    public void setBarangay(String barangay) {
        this.barangay = barangay;
    }

    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }

    public int getZip() {
        return zip;
    }
    public void setZip(int zip) {
        this.zip = zip;
    }

    @Override
    public String toString() {
        return "\t\t" +
                "Street no.: " + streetNo + "\n" +
                "Barangay: " + barangay + "\n\t\t" +
                "City: " + city + "\n\t\t" +
                "Zip: " + zip;
    }
}