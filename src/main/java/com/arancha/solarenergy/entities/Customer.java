package com.arancha.solarenergy.entities;

import lombok.NonNull;
import org.hibernate.mapping.ToOne;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "customer")
public class Customer {

    @Id
    @NonNull
    @Column(name = "cssn")
    private Long cssn;
    @Column(name = "name")
    private String name;
    @Column(name = "address")
    private String address;
    @Column(name = "contact_no")
    private String contact_no;
    @Column(name = "dob")
    private Date dob;
    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "dssn")
    private Distributor distributor;
    @Column(name = "areacode")
    private Long areacode;

    public Customer() {

    }

    public Customer(@NonNull Long cssn, String name, String address, String contact_no, Long areacode) {
        this.cssn = cssn;
        this.name = name;
        this.address = address;
        this.contact_no = contact_no;
        this.areacode = areacode;
    }

    public Long getCssn() {
        return cssn;
    }

    public void setCssn(Long cssn) {
        this.cssn = cssn;
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

    public Distributor getDistributor() {
        return distributor;
    }

    public void setDistributor(Distributor distributor) {
        this.distributor = distributor;
    }

    public Long getAreacode() {
        return areacode;
    }

    public void setAreacode(Long areacode) {
        this.areacode = areacode;
    }
}