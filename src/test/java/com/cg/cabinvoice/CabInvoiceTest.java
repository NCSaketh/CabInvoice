package com.cg.cabinvoice;

import org.junit.Assert;
import org.junit.Test;

public class CabInvoiceTest {

    InvoiceGenerator invoiceGenerator = new InvoiceGenerator();

    @Test
    public void givenDistanceAndTime_ShouldReturnTotalFare() {
        double distance = 3.0;
        int time = 5;
        double fare = invoiceGenerator.calculateFare(distance, time);
        Assert.assertEquals(35, fare, 0.0);
    }

    
}
