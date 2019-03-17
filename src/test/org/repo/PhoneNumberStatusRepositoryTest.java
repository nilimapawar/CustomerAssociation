package org.repo;

import org.exceptions.PhoneNumberNotFoundException;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class PhoneNumberStatusRepositoryTest {

    @Test
    public void createPhoneNumberAndStatus() {
        PhoneNumberStatusRepository phoneNumberStatusRepository = new PhoneNumberStatusRepository();
        phoneNumberStatusRepository.createPhoneNumberAndStatus("9912345678");
        phoneNumberStatusRepository.createPhoneNumberAndStatus("9912345123");
        assertEquals(false,phoneNumberStatusRepository.isPhoneNumberActive("9912345678"));
        List<String> expectedPhoneNumbers = new ArrayList<String>();
        expectedPhoneNumbers.add("9912345678");
        phoneNumberStatusRepository.removePhoneActive("9912345123");
        assertEquals(expectedPhoneNumbers,phoneNumberStatusRepository.getAllPhoneNumbers());
    }

    @Test
    public void activateCustomerPhoneNumber() throws PhoneNumberNotFoundException {
        PhoneNumberStatusRepository phoneNumberStatusRepository = new PhoneNumberStatusRepository();
        phoneNumberStatusRepository.createPhoneNumberAndStatus("9912345678");
        phoneNumberStatusRepository.activateCustomerPhoneNumber("9912345678");
        assertEquals(true,phoneNumberStatusRepository.isPhoneNumberActive("9912345678"));
        phoneNumberStatusRepository.removePhoneActive("9912345123");
    }

}