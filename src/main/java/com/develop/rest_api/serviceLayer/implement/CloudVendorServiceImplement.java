package com.develop.rest_api.serviceLayer.implement;

import com.develop.rest_api.exception.CloudVendorNotFoundException;
import com.develop.rest_api.model.CloudVendor;
import com.develop.rest_api.repository.CloudVendorRepository;
import com.develop.rest_api.serviceLayer.CloudVendorService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CloudVendorServiceImplement implements CloudVendorService {

    CloudVendorRepository cloudVendorRepository; //as it is only interacting with service layer

    public CloudVendorServiceImplement(CloudVendorRepository cloudVendorRepository) {
        this.cloudVendorRepository = cloudVendorRepository;
    }

    @Override
    public String createCloudVendor(CloudVendor cloudVendor) {
        cloudVendorRepository.save(cloudVendor);
        return "Successfully Added!";
    }

    @Override
    public String updateCloudVendor(CloudVendor cloudVendor) {
        cloudVendorRepository.save(cloudVendor);
        return "Updated Successfully!";
    }

    @Override
    public String deleteCloudVendor(String cloudVendorId) {
        cloudVendorRepository.deleteById(cloudVendorId);
        return "Deleted Successfullly!";
    }

    @Override
    public CloudVendor getCloudVendor(String cloudVendorId) {
        if (cloudVendorRepository.findById(cloudVendorId).isEmpty()){
            throw new CloudVendorNotFoundException("Requested Cloud Vendor does not exist.");
        }
        return cloudVendorRepository.findById(cloudVendorId).get();
    }

    @Override
    public List<CloudVendor> getAllCloudVendors() {
        return cloudVendorRepository.findAll();
    }

    @Override
    public List<CloudVendor> getByVendorName(String vendorName)
    {
        return cloudVendorRepository.findByVendorName(vendorName);
    }
}
