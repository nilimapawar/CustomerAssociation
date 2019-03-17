package org.api;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.exceptions.InvalidCustomerIdException;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class GetAllPhoneNumbersForACustomerTest {
    CustomerPhoneNumbers customerPhoneNumbers = new CustomerPhoneNumbers();

    @Rule
    public final ExpectedException exception = ExpectedException.none();

    @Before
    public void setup(){
        customerPhoneNumbers.add(1,"John Doe", "9912345678");
        customerPhoneNumbers.add(1,"John Doe", "9912345123");
    }
   @Test
   public void verifyAllPhoneNumbersForACustomer() throws InvalidCustomerIdException {
       List<String> actualAllCustomerPhoneNumbers = customerPhoneNumbers.getAllPhoneNumbers(1);
       List<String> expectedAllCustomerPhoneNumbers = new ArrayList<String>();
       expectedAllCustomerPhoneNumbers.add("9912345678");
       expectedAllCustomerPhoneNumbers.add("9912345123");
       assertEquals(expectedAllCustomerPhoneNumbers,actualAllCustomerPhoneNumbers);
   }

    @Test
    public void verifyAllPhoneNumbersForAInvalidCustomerID() throws InvalidCustomerIdException {
        exception.expect(InvalidCustomerIdException.class);
        customerPhoneNumbers.getAllPhoneNumbers(2);
    }

   @After
    public void cleanup() throws InvalidCustomerIdException {
        customerPhoneNumbers.remove(1);
   }
}
