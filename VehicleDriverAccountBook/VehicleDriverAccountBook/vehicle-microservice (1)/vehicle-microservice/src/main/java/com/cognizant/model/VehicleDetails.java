package com.cognizant.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="vehicles")
public class VehicleDetails {


    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Id
    @Column(unique = true)
    private String registrationNo;

    @Column
    private String modelName;

    @Column
    private String vehicleType;

    @Column
    private int numberOfSeat;

    @Column
    private boolean acAvailable;
}
