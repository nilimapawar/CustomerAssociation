package org.repo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PhoneNumberStatusRepository {
    private static HashMap<String, Boolean> activeStatusOfPhoneNumberMap = new HashMap<String, Boolean>();

    public void createPhoneNumberAndStatus(String customerPhoneNumber) {
        activeStatusOfPhoneNumberMap.put(customerPhoneNumber,false);
    }

    public void activateCustomerPhoneNumber(String customerPhoneNumber) {
        activeStatusOfPhoneNumberMap.put(customerPhoneNumber, true);
    }

    public boolean isPhoneNumberActive(String phoneNumber) {
        return activeStatusOfPhoneNumberMap.get(phoneNumber).booleanValue();
    }

    public void removePhoneActive(String phoneNumber) {
        activeStatusOfPhoneNumberMap.remove(phoneNumber);
    }

    public List<String> getAllPhoneNumbers() {
        List<String> allPhoneNumbers = new ArrayList<String>();
        for ( String phoneNumber : activeStatusOfPhoneNumberMap.keySet() ) {
            allPhoneNumbers.add(phoneNumber);
        }
        return allPhoneNumbers;
    }
}
