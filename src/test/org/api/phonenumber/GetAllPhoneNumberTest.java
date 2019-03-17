package org.api.phonenumber;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class GetAllPhoneNumberTest {
    @Before
    public void setup(){
        CustomerPhoneNumbers customerPhoneNumbers = new CustomerPhoneNumbers();
        customerPhoneNumbers.add(1,"John Doe", "9912345678");
        customerPhoneNumbers.add(1,"John Doe", "9912345123");
        customerPhoneNumbers.add(2,"Smith Doe","9123456789");
        customerPhoneNumbers.add(3,"Maria Doe","9987654322");

    }
   @Test
   public void getAllPhoneNumbersOfCustomerTest(){
       CustomerPhoneNumbers customerPhoneNumbers = new CustomerPhoneNumbers();
       List<String> actualAllCustomerPhoneNumbers = customerPhoneNumbers.getAllPhoneNumbers();
       List<String> expectedAllCustomerPhoneNumbers = new ArrayList<String>();
       expectedAllCustomerPhoneNumbers.add("9912345678");
       expectedAllCustomerPhoneNumbers.add("9912345123");
       expectedAllCustomerPhoneNumbers.add("9123456789");
       expectedAllCustomerPhoneNumbers.add("9987654322");
       assertEquals(expectedAllCustomerPhoneNumbers,actualAllCustomerPhoneNumbers);
   }
}
