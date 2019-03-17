package org.repo;

import org.exceptions.InvalidCustomerIdException;
import org.domain.CustomerInfo;

import java.util.*;

public class CustomerRepository {
    private static HashMap<Integer,CustomerInfo> customerInfoHashMap = new HashMap<Integer, CustomerInfo>();
    public void addNewCustomerToMap(CustomerInfo customerInfo) {
        customerInfoHashMap.put(customerInfo.getCustomerId(),customerInfo);
    }

    public List<String> getAllPhoneNumbers() {
        Collection<CustomerInfo> allCustomers = customerInfoHashMap.values();
        List<String> allPhoneNumbers = new ArrayList<String>();
        for (CustomerInfo currentCustomer:allCustomers) {
            List<String> customerPhoneNumbers = currentCustomer.getCustomerPhoneNumbersList();
            for (String currentNumber: customerPhoneNumbers) {
                allPhoneNumbers.add(currentNumber);
            }
        }
        return allPhoneNumbers;
    }

    public boolean doesCustomerExist(int customerId) {
        return customerInfoHashMap.containsKey(customerId);
    }

    public void updatePhoneNumber(int customerId, String customerPhoneNumber) {
        customerInfoHashMap.get(customerId).addPhoneNumber(customerPhoneNumber);
    }

    public List<String> getAllPhoneNumbers(int customerId) throws InvalidCustomerIdException {
        try {
            return customerInfoHashMap.get(customerId).getCustomerPhoneNumbersList();
        } catch (NullPointerException nullPointerException) {
            throw new InvalidCustomerIdException("Customer ID Does not exist");
        }
    }

    public void removeCustomer(int customerId) {
        customerInfoHashMap.remove(customerId);
    }
}
