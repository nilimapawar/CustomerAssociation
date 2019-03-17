package org.repo;

import org.domain.CustomerInfo;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class CustomerRepositoryTest {

    @Test
    public void verifyUserCanAddCustomerAndCheckIfCustomerExist() {
        CustomerInfo customerInfo = new CustomerInfo(1,"John Doe", "9912345678");
        CustomerRepository customerRepository = new CustomerRepository();
        customerRepository.addNewCustomerToMap(customerInfo);
        assertEquals(true,customerRepository.doesCustomerExist(1));
        assertEquals(false,customerRepository.doesCustomerExist(2));
    }

    @Test
    public void getAllPhoneNumbers() {
        CustomerInfo customer1Info = new CustomerInfo(1,"John Doe", "9912345678");
        CustomerInfo customer3Info = new CustomerInfo(2,"Smith Doe","9123456789");
        CustomerRepository customerRepository = new CustomerRepository();
        customerRepository.addNewCustomerToMap(customer1Info);
        customerRepository.updatePhoneNumber(1,"9912345123");
        customerRepository.addNewCustomerToMap(customer3Info);
        List<String> expectedAllCustomerPhoneNumbers = new ArrayList<String>();
        expectedAllCustomerPhoneNumbers.add("9912345678");
        expectedAllCustomerPhoneNumbers.add("9912345123");
        expectedAllCustomerPhoneNumbers.add("9123456789");
        assertEquals(expectedAllCustomerPhoneNumbers,customerRepository.getAllPhoneNumbers());
    }
}