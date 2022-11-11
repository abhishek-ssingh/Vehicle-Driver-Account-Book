package com.cognizant.dto;

import lombok.Data;

@Data
public class VehicleDetailsDto {

    private long id;
    private String registrationNo;
    private String modelName;
    private String vehicleType;
    private int numberOfSeat;
    private boolean acAvailable;
}
