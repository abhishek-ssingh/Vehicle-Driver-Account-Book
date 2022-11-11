package com.cognizant.controller;

import com.cognizant.model.VehicleDetails;
import com.cognizant.service.VehicleDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
    @CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api")
public class VehicleController {

    private VehicleDetailsService vehicleDetailsService;

    @Autowired
    public VehicleController(VehicleDetailsService vehicleDetailsService) {
        this.vehicleDetailsService = vehicleDetailsService;
    }

    @PostMapping("/vehicledetails")
    public ResponseEntity<VehicleDetails> createVehicleDetails(@RequestBody VehicleDetails vehicleDetails){
        return new ResponseEntity<VehicleDetails>(vehicleDetailsService.createVehicleDetails(vehicleDetails),HttpStatus.CREATED);
    }

    @GetMapping("/vehicledetail")
    public List<VehicleDetails> getAllVehicleDetails(){
        return vehicleDetailsService.getAllVehicleDetails();
    }

    @GetMapping("/{vehicleType}")
    public List<VehicleDetails> getVehicleDetailsByType(@PathVariable("vehicleType") String vehicleType){
        return vehicleDetailsService.getVehicleDetailsByType(vehicleType);
    }

    @GetMapping("/vehicledetail/{registrationNo}")
    public List<VehicleDetails> getVehicleDetailsByRegistrationNo(@PathVariable("registrationNo") String registrationNo){
        return vehicleDetailsService.getVehicleDetailsByRegistrationNo(registrationNo);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<VehicleDetails> updateVehicleDetails(@PathVariable("id") long id,@RequestBody VehicleDetails vehicleDetails){
        return new ResponseEntity<VehicleDetails> (vehicleDetailsService.updateVehicleDetails(vehicleDetails,id),HttpStatus.OK);
    }

    @DeleteMapping("/delete/{registrationNo}")
    public ResponseEntity<String> deleteDriver(@PathVariable(name="registrationNo") String registrationNo){
        try{
            vehicleDetailsService.deleteVehicleDetails(registrationNo);
            return new ResponseEntity<String>("Driver deleted successfully!.", HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<String>(e.getMessage(),HttpStatus.NOT_FOUND);
        }
    }
}
