package org.domain;

import java.util.ArrayList;
import java.util.List;

public class CustomerInfo {

    private int customerId;
    private String customerName;
    private List<String> customerPhoneNumberList;
    private boolean status;

    public CustomerInfo(int customerId, String customerName, String customerPhoneNumber) {

        this.customerId = customerId;
        this.customerName = customerName;
        this.customerPhoneNumberList = new ArrayList<String>();
        customerPhoneNumberList.add(customerPhoneNumber);
    }

    public int getCustomerId() {
        return customerId;
    }

    public void addPhoneNumber(String customerPhoneNumber) {
        customerPhoneNumberList.add(customerPhoneNumber);
    }

    public List<String> getCustomerPhoneNumbersList() {
        return customerPhoneNumberList;
    }
}
