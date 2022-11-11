package com.cognizant.repository;

import com.cognizant.model.VehicleDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface VehicleRepository extends JpaRepository<VehicleDetails, Long> {

    List<VehicleDetails> findAllByVehicleType(String vehicleType);

    List<VehicleDetails> findByRegistrationNo(String registrationNo);

    void deleteByRegistrationNo(String registrationNo);
}
