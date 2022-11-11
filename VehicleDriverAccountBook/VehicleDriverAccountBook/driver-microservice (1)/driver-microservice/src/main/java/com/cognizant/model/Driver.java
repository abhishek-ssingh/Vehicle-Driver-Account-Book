package com.cognizant.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name="drivers")
public class Driver {

    @Id
    @Column(name="lic_num")
    private String licenceNumber;

    @Column(name="driver_name")
    private String name;

    @Column(name="driver_age")
    private int age;

    @Column(name="veh_type")
    private String vehicleType;


    public Driver() {
    }

    public Driver(String licenceNumber, String name, int age, String vehicleType) {
        this.licenceNumber = licenceNumber;
        this.name = name;
        this.age = age;
        this.vehicleType = vehicleType;
    }
}
