package org.api;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.exceptions.InvalidCustomerIdException;
import org.exceptions.PhoneNumberNotFoundException;

import static org.junit.Assert.assertEquals;

public class ActivatePhoneNumberTest {
    CustomerPhoneNumbers customerPhoneNumbers = new CustomerPhoneNumbers();

    @Rule
    public final ExpectedException exception = ExpectedException.none();

    @Before
    public void setup(){
        customerPhoneNumbers.add(1,"John Doe", "9912345678");
        customerPhoneNumbers.add(1,"John Doe", "9912345123");

    }
   @Test
   public void verifyPhoneNumberIsActivated() throws PhoneNumberNotFoundException {
       customerPhoneNumbers.activatePhoneNumber("9912345678");
       boolean isActivated = customerPhoneNumbers.isPhoneNumberActive("9912345678");
       assertEquals(true,isActivated);
   }

    @Test
    public void verifyIfPhoneNumberDoesNotExistInMap() throws PhoneNumberNotFoundException {
        exception.expect(PhoneNumberNotFoundException.class);
        customerPhoneNumbers.activatePhoneNumber("9912341111");
    }

   @After
    public void cleanup() throws InvalidCustomerIdException {
        customerPhoneNumbers.remove(1);
   }
}
