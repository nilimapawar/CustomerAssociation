package org.api.phonenumber;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class GetAllPhoneNumbersForACustomerTest {
    @Before
    public void setup(){
        CustomerPhoneNumbers customerPhoneNumbers = new CustomerPhoneNumbers();
        customerPhoneNumbers.add(1,"John Doe", "9912345678");
        customerPhoneNumbers.add(1,"John Doe", "9912345123");
    }
   @Test
   public void verifyAllPhoneNumbersForACustomer(){
       CustomerPhoneNumbers customerPhoneNumbers = new CustomerPhoneNumbers();
       List<String> actualAllCustomerPhoneNumbers = customerPhoneNumbers.getAllPhoneNumbers(1);
       List<String> expectedAllCustomerPhoneNumbers = new ArrayList<String>();
       expectedAllCustomerPhoneNumbers.add("9912345678");
       expectedAllCustomerPhoneNumbers.add("9912345123");
       assertEquals(expectedAllCustomerPhoneNumbers,actualAllCustomerPhoneNumbers);
   }
}
