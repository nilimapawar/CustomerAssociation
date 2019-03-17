package org.api.phonenumber;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class GetAllPhoneNumberTest {
    CustomerPhoneNumbers customerPhoneNumbers = new CustomerPhoneNumbers();

    @Before
    public void setup() {
        customerPhoneNumbers.add(1, "John Doe", "9912345678");
        customerPhoneNumbers.add(1, "John Doe", "9912345123");
        customerPhoneNumbers.add(2, "Smith Doe", "9123456789");
        customerPhoneNumbers.add(3, "Maria Doe", "9987654322");

    }

    @Test
    public void verifyAllPhoneNumbersOfAllCustomers() {
        List<String> actualAllCustomerPhoneNumbers = customerPhoneNumbers.getAllPhoneNumbers();
        List<String> expectedAllCustomerPhoneNumbers = new ArrayList<String>();
        expectedAllCustomerPhoneNumbers.add("9912345678");
        expectedAllCustomerPhoneNumbers.add("9123456789");
        expectedAllCustomerPhoneNumbers.add("9987654322");
        expectedAllCustomerPhoneNumbers.add("9912345123");
        assertEquals(expectedAllCustomerPhoneNumbers, actualAllCustomerPhoneNumbers);
    }

    @After
    public void cleanup() {
        customerPhoneNumbers.remove(1);
        customerPhoneNumbers.remove(2);
        customerPhoneNumbers.remove(3);
    }
}