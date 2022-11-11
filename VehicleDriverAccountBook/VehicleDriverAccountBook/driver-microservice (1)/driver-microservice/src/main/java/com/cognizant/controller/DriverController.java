package com.cognizant.controller;

import com.cognizant.model.Driver;
import com.cognizant.service.DriverService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/drivers/")
public class DriverController {

    private DriverService driverService;

    public DriverController(DriverService driverService) {
        this.driverService = driverService;
    }

    //build create driver REST API
    @PostMapping
    public ResponseEntity<Driver> saveDriver(@RequestBody Driver driver){
        return  new ResponseEntity<Driver>(driverService.saveDriver(driver), HttpStatus.CREATED);
    }

    
    //build get all drivers REST API
    @GetMapping
    public List<Driver> getAllDrivers(){

        return driverService.getAllDrivers();

    }

    @GetMapping("{vehicleType}")
    public  List<Driver> getDriversByVehicleType(@PathVariable(name="vehicleType") String vehicleType){
        return driverService.getDriversByVehicleType(vehicleType);
    }

    @DeleteMapping("{licenceNumber}")
    public ResponseEntity<String> deleteDriver(@PathVariable(name="licenceNumber") String licenceNumber){
        try{
            driverService.deleteDriver(licenceNumber);
            return new ResponseEntity<String>("Driver deleted succefully!.", HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<String>("Please enter a valid license number",HttpStatus.NOT_FOUND);
        }
    }
}
