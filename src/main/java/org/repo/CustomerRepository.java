package org.repo;

import org.domain.CustomerInfo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

public class CustomerRepository {
    static HashMap<Integer,CustomerInfo> customerInfoHashMap = new HashMap<Integer, CustomerInfo>();

    public void addNewCustomerToMap(CustomerInfo customerInfo) {
        customerInfoHashMap.put(customerInfo.getCustomerId(),customerInfo);
    }

    public List<String> getAllPhoneNumbers() {
        Collection<CustomerInfo> allCustomers = customerInfoHashMap.values();
        List<String> allPhoneNumbers = new ArrayList<String>();
        for (CustomerInfo currentCustomer:allCustomers) {
            List<String> customerPhoneNumbers = currentCustomer.getCustomerPhoneNumbers();
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
}
