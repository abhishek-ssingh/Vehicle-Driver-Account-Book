package com.cognizant.service;

import com.cognizant.model.VehicleDetails;

import java.util.List;
import java.util.Optional;

public interface VehicleDetailsService {
    VehicleDetails createVehicleDetails(VehicleDetails vehicleDetails);

    List<VehicleDetails> getAllVehicleDetails();

    List<VehicleDetails> getVehicleDetailsByType(String vehicleType);

    List<VehicleDetails> getVehicleDetailsByRegistrationNo(String registrationNo);

    VehicleDetails updateVehicleDetails(VehicleDetails vehicleDetails, long id);

    void deleteVehicleDetails(String registrationNo);
}
