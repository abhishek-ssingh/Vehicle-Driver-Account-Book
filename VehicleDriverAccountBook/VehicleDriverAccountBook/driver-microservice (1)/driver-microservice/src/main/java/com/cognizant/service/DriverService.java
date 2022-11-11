package com.cognizant.service;

import com.cognizant.model.Driver;

import java.util.List;

public interface DriverService {
    Driver saveDriver(Driver driver);
    List<Driver> getAllDrivers();
    List<Driver> getDriversByVehicleType(String vehicleType);
    void deleteDriver(String licence);
}
