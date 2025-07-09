package com.develop.rest_api.serviceLayer;

import com.develop.rest_api.model.CloudVendor;

import java.util.List;

public interface CloudVendorService
{
    public String createCloudVendor(CloudVendor cloudVendor);
    public String updateCloudVendor(CloudVendor cloudVendor);
    public String deleteCloudVendor(String cloudVendorId);
    public CloudVendor getCloudVendor(String cloudVendorId);
    public List<CloudVendor> getAllCloudVendors();

    List<CloudVendor> getByVendorName(String vendorName);
}
