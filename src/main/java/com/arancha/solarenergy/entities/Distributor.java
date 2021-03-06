package com.arancha.solarenergy.entities;

import lombok.NonNull;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "distributor")
public class Distributor {

    @Id
    @NonNull
    @Column(name = "dssn")
    private Long dssn;
    @Column(name = "name")
    private String name;
    @Column(name = "address")
    private String address;
    @Column(name = "contact_no")
    private String contact_no;
    @Column(name = "dob")
    private Date dob;
    @OneToMany(mappedBy = "distributor", cascade = CascadeType.ALL)
    private List<Customer> customerList;

    public Distributor() {

    }

    public Distributor(@NonNull Long dssn, String name, String address, String contact_no, Date dob) {
        this.dssn = dssn;
        this.name = name;
        this.address = address;
        this.contact_no = contact_no;
        this.dob = dob;
    }

    public Long getDssn() {
        return dssn;
    }

    public void setDssn(Long dssn) {
        this.dssn = dssn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContact_no() {
        return contact_no;
    }

    public void setContact_no(String contact_no) {
        this.contact_no = contact_no;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public List<Customer> getCustomerList() {
        return customerList;
    }

    public void setCustomerList(List<Customer> customerList) {
        this.customerList = customerList;
    }

}
