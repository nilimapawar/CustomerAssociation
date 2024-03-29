package org.api;

import org.domain.CustomerInfo;
import org.repo.CustomerRepository;
import org.exceptions.InvalidCustomerIdException;
import org.exceptions.PhoneNumberNotFoundException;
import org.repo.PhoneNumberStatusRepository;

import java.util.List;

public class CustomerPhoneNumbers {

    public List<String> getAllPhoneNumbers() {
        PhoneNumberStatusRepository phoneNumberStatusRepository = new PhoneNumberStatusRepository();
        return phoneNumberStatusRepository.getAllPhoneNumbers();
    }

    public List<String> getAllPhoneNumbers(int customerId) throws InvalidCustomerIdException {
        CustomerRepository customerRepository = new CustomerRepository();
        return customerRepository.getAllPhoneNumbers(customerId);
    }

    public void activatePhoneNumber(String customerPhoneNumber) throws PhoneNumberNotFoundException {
        PhoneNumberStatusRepository phoneNumberStatusRepository = new PhoneNumberStatusRepository();
        phoneNumberStatusRepository.activateCustomerPhoneNumber(customerPhoneNumber);
    }

    public boolean isPhoneNumberActive(String phoneNumber) {
        PhoneNumberStatusRepository phoneNumberStatusRepository = new PhoneNumberStatusRepository();
        return phoneNumberStatusRepository.isPhoneNumberActive(phoneNumber);
    }

    public void add(int customerId, String customerName, String customerPhoneNumber) {
        PhoneNumberStatusRepository phoneNumberStatusRepository = new PhoneNumberStatusRepository();
        phoneNumberStatusRepository.createPhoneNumberAndStatus(customerPhoneNumber);
        CustomerRepository customerRepository = new CustomerRepository();
        if(customerRepository.doesCustomerExist(customerId)){
            customerRepository.updatePhoneNumber(customerId,customerPhoneNumber);
            return;
        }
        CustomerInfo customerInfo = new CustomerInfo(customerId,customerName,customerPhoneNumber);
        customerRepository.addNewCustomerToMap(customerInfo);

    }

    public void remove(int customerId) throws InvalidCustomerIdException {
        CustomerRepository customerRepository = new CustomerRepository();
        List<String> allPhoneNumbers = customerRepository.getAllPhoneNumbers(customerId);
        customerRepository.removeCustomer(customerId);
        PhoneNumberStatusRepository phoneNumberStatusRepository = new PhoneNumberStatusRepository();
        for (String currentNumber: allPhoneNumbers) {
            phoneNumberStatusRepository.removePhoneActive(currentNumber);
        }
    }
}
