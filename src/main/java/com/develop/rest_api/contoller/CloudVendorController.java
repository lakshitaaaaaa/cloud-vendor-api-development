package com.develop.rest_api.contoller;

import com.develop.rest_api.model.CloudVendor;
import com.develop.rest_api.response.ResponseHandler;
import com.develop.rest_api.serviceLayer.CloudVendorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController  //tells that this class is responsible for all the REST APIs
@RequestMapping("/cloudvendor")
public class CloudVendorController
{
    // since controller is interacting, talking with service layer, therefore we will add an instance of service layer
    CloudVendorService cloudVendorService;

    public CloudVendorController(CloudVendorService cloudVendorService) {
        this.cloudVendorService = cloudVendorService;
    }

    @GetMapping("/welcome")
    public ResponseEntity welcomeMessage()
    {
        return new ResponseEntity<>("Welcome to the application",HttpStatus.OK);
    }

    // read specific cloud vendor details
    @GetMapping("{vendorId}")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<Object> getCloudVendorDetails(@PathVariable("vendorId") String vendorId){
        return ResponseHandler.responseBuilder("Requested Vendor Details are given here", HttpStatus.OK,cloudVendorService.getCloudVendor(vendorId));
    }

    // read all cloud vendor details available in the db
    @GetMapping
    @PreAuthorize("hasRole('ADMIN')")
    public List<CloudVendor> getAllCloudVendorDetails(){
        return cloudVendorService.getAllCloudVendors();
    }

    @PostMapping("/")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<String> createCloudVendorDetails(@RequestBody CloudVendor cloudVendor){
        cloudVendorService.createCloudVendor(cloudVendor);
        return new ResponseEntity<>("Cloud Vendor Created Successfully!",HttpStatus.OK);
    }

    @PutMapping("/")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<String> updateCloudVendorDetails(@RequestBody CloudVendor cloudVendor){
        cloudVendorService.updateCloudVendor(cloudVendor);
        return new ResponseEntity<>("Cloud Vendor Updated Successfully",HttpStatus.OK);
    }

    @DeleteMapping("/{vendorId}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<String> deleteCloudVendorDetails(@PathVariable("vendorId") String vendorId){
        cloudVendorService.deleteCloudVendor(vendorId);
        return new ResponseEntity<>("Cloud Vendor "+vendorId+" Deleted Succesfully!",HttpStatus.OK);
    }
}

