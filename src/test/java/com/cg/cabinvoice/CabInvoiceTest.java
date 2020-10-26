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

    @Test
    public void givenLessDistanceAndTime_ShouldReturnMinimumFare() {
        double distance = 0.2;
        int time = 1;
        double fare = invoiceGenerator.calculateFare(distance, time);
        Assert.assertEquals(5, fare, 0.0);
    }

<<<<<<< HEAD
=======
//    @Test
//    public void givenMultipleRides_ShouldReturnTotalFare() {
//        Ride[] rides = { new Ride(2.0, 5),
//                         new Ride(0.1, 1) };
//        invoiceGenerator.calculateFare(rides);
//        double fare = invoiceGenerator.calculateFare(rides);
//        Assert.assertEquals(30, fare, 0.0);
//    }
>>>>>>> UC3_EnhancedInvoice

    @Test
    public void givenMultipleRides_ShouldReturnInvoiceSummary() {
        Ride[] rides = { new Ride(2.0, 5),
                         new Ride(0.1, 1) };
        InvoiceSummary summary = invoiceGenerator.calculateFare(rides);
        InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(2, 30.0);
        Assert.assertEquals(expectedInvoiceSummary, summary);
    }

    
}
