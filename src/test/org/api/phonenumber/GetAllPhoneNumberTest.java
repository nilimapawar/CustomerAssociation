package org.api.phonenumber;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class GetAllPhoneNumberTest {
   @Test
   public void getAllPhoneNumbersOfCustomerTest(){
       CustomerPhoneNumbers customerPhoneNumbers = new CustomerPhoneNumbers();
       List<Integer> actualAllCustomerPhoneNumbers = customerPhoneNumbers.getAllPhoneNumbers();
       List<Integer> expectedAllCustomerPhoneNumbers = new ArrayList<Integer>();
       expectedAllCustomerPhoneNumbers.add(123456789);
       expectedAllCustomerPhoneNumbers.add(123456789);
       expectedAllCustomerPhoneNumbers.add(123456789);
       assertEquals(expectedAllCustomerPhoneNumbers,actualAllCustomerPhoneNumbers);
   }
}
