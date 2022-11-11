package com.cognizant.repository;

import com.cognizant.model.Driver;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DriverRepository extends JpaRepository<Driver, String> {
    List<Driver> findAllByVehicleType(String vehicleType);

}
