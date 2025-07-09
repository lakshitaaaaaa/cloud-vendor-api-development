package com.develop.rest_api.repository;

import com.develop.rest_api.model.CloudVendor;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest // implies that it should use in-memory database
public class CloudVendorRepositoryTest {

    @Autowired
    private CloudVendorRepository cloudVendorRepository;
    CloudVendor cloudVendor;

    @BeforeEach
    void setUp() {
        cloudVendor = new CloudVendor("1","Amazon","address 3","xxxx");
        cloudVendorRepository.save(cloudVendor);
    }

    @AfterEach
    void tearDown() {
        cloudVendor = null;
        cloudVendorRepository.deleteAll();
    }

    // Test case SUCCESS

    @Test
    void TestFindByVendorName_Found() {
        List<CloudVendor> list = cloudVendorRepository.findByVendorName("Amazon");
        //assertThat(list).isNotEmpty(); // prevent IndexOutOfBounds
        assertThat(list.get(0).getVendorId()).isEqualTo(cloudVendor.getVendorId());
        assertThat(list.get(0).getVendorAddress()).isEqualTo(cloudVendor.getVendorAddress());
    }


    // Test Case FAILURE
    @Test
    void TestFindByVendor_NotFound(){
        List<CloudVendor> list = cloudVendorRepository.findByVendorName("GCP");
        assertThat(list.isEmpty()).isTrue();
    }

}
