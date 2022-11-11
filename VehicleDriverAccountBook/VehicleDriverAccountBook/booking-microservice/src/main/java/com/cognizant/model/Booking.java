package com.cognizant.model;


import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="bookings")
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long bookingId;

    @Column(name="vehicle_type")
    private String vehicle;

    @Column(name="driver_name")
    private String driver;

    @Column(name="start_dateTime")
    private String sdTime;

    @Column(name="end_dateTime")
    private String edTime;

    @Column(name="from_location")
    private String fromLocation;

    @Column(name="to_location")
    private String toLocation;

    @Column(name="distance")
    private String distance;

    @Column(name="type")
    private String type;

    @Column(name="trip_fare")
    private int tripFare;

    @Column(name="fuel_expense")
    private int fuelExpense;

    @Column(name="driver_share")
    private String driverShare;

    @Column(name="remarks")
    private String remark;
}
