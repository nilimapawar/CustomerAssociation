package org.api.phonenumber;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ActivatePhoneNumberTest {
    CustomerPhoneNumbers customerPhoneNumbers = new CustomerPhoneNumbers();

    @Before
    public void setup(){
        customerPhoneNumbers.add(1,"John Doe", "9912345678");
        customerPhoneNumbers.add(1,"John Doe", "9912345123");

    }
   @Test
   public void verifyAllPhoneNumbersOfAllCustomers(){
       customerPhoneNumbers.activatePhoneNumber("9912345678");
       boolean isActivated = customerPhoneNumbers.isPhoneNumberActive("9912345678");
       assertEquals(true,isActivated);
   }

   @After
    public void cleanup(){
        customerPhoneNumbers.remove(1);
   }
}
