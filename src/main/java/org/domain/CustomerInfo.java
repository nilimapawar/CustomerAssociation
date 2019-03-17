package org.domain;

import java.util.ArrayList;
import java.util.List;

public class CustomerInfo {

    private int customerId;
    private String customerName;
    private List<String> customerPhoneNumbers;

    public CustomerInfo(int customerId, String customerName, String customerPhoneNumber) {

        this.customerId = customerId;
        this.customerName = customerName;
        this.customerPhoneNumbers = new ArrayList<String>();
        customerPhoneNumbers.add(customerPhoneNumber);
    }

    public int getCustomerId() {
        return customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void addPhoneNumber(String customerPhoneNumber) {
        customerPhoneNumbers.add(customerPhoneNumber);
    }

    public List<String> getCustomerPhoneNumbers() {
        return customerPhoneNumbers;
    }
}
