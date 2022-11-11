package com.cognizant.service.impl;

import com.cognizant.exception.ResourceNotFoundException;
import com.cognizant.model.VehicleDetails;
import com.cognizant.repository.VehicleRepository;
import com.cognizant.service.VehicleDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class VehicleDetailsServiceImpl implements VehicleDetailsService {

    private VehicleRepository vehicleRepository;

    @Autowired
    public VehicleDetailsServiceImpl(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    @Override
    public VehicleDetails createVehicleDetails(VehicleDetails vehicleDetails) {
        return vehicleRepository.save(vehicleDetails);
    }

    @Override
    public List<VehicleDetails> getAllVehicleDetails() {
        return vehicleRepository.findAll();
    }

    @Override
    public List<VehicleDetails> getVehicleDetailsByType(String vehicleType) {
        return vehicleRepository.findAllByVehicleType(vehicleType);
    }

    @Override
    public List<VehicleDetails> getVehicleDetailsByRegistrationNo(String registrationNo) {
        return vehicleRepository.findByRegistrationNo(registrationNo);
    }

    @Override
    public VehicleDetails updateVehicleDetails(VehicleDetails vehicleDetails, long id) {
        VehicleDetails existingVehicleDetails =vehicleRepository.findById(id).orElseThrow( ()->
                new ResourceNotFoundException("VehicleDetails","Id",String.valueOf(id)));

        existingVehicleDetails.setRegistrationNo(vehicleDetails.getRegistrationNo());
        existingVehicleDetails.setModelName(vehicleDetails.getModelName());
        existingVehicleDetails.setVehicleType(vehicleDetails.getVehicleType());
        existingVehicleDetails.setNumberOfSeat(vehicleDetails.getNumberOfSeat());
        existingVehicleDetails.setAcAvailable(vehicleDetails.isAcAvailable());

        vehicleRepository.save(existingVehicleDetails);
        return existingVehicleDetails;
    }
    @Override
    @Transactional
    public void deleteVehicleDetails(String registrationNo) {
        vehicleRepository.deleteByRegistrationNo(registrationNo);
    }
}
