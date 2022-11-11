package com.cognizant.service.impl;

import com.cognizant.exception.ResourceNotFoundException;
import com.cognizant.model.Driver;
import com.cognizant.repository.DriverRepository;
import com.cognizant.service.DriverService;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class DriverServiceImpl implements DriverService {

    private DriverRepository driverRepository;

    public DriverServiceImpl(DriverRepository driverRepository) {
        super();
        this.driverRepository = driverRepository;
    }

    @Override
    public Driver saveDriver(Driver driver) {
        return driverRepository.save(driver);
    }

    @Override
    public List<Driver> getAllDrivers() {
        return driverRepository.findAll();
    }

    @Override
    public List<Driver> getDriversByVehicleType(String vehicleType) {
        List<Driver> dlist = driverRepository.findAllByVehicleType(vehicleType);
        if (dlist.isEmpty()){
            throw new ResourceNotFoundException("Driver", "vehicleType", vehicleType);
        }else {
            return dlist;
        }
    }

    @Override
    public void deleteDriver(String licenceNumber) {
        driverRepository.deleteById(licenceNumber);

    }
}
