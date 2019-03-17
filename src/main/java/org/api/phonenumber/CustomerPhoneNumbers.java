package org.api.phonenumber;

import org.domain.CustomerInfo;
import org.repo.CustomerRepository;

import java.util.List;

public class CustomerPhoneNumbers {

    public List<String> getAllPhoneNumbers() {
        CustomerRepository customerRepository = new CustomerRepository();
        return customerRepository.getAllPhoneNumbers();
    }

    public void add(int customerId, String customerName, String customerPhoneNumber) {
        CustomerRepository customerRepository = new CustomerRepository();
        if(customerRepository.doesCustomerExist(customerId)){
            customerRepository.updatePhoneNumber(customerId,customerPhoneNumber);
            return;
        }
        CustomerInfo customerInfo = new CustomerInfo(customerId,customerName,customerPhoneNumber);
        customerRepository.addNewCustomerToMap(customerInfo);

    }

    public List<String> getAllPhoneNumbers(int customerId) {
        CustomerRepository customerRepository = new CustomerRepository();
        return customerRepository.getAllPhoneNumbers(customerId);
    }
}
