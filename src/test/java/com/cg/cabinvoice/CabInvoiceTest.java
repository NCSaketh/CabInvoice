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


    @Test
    public void givenMultipleRides_ShouldReturnInvoiceSummary() {
        Ride[] rides = { new Ride(2.0, 5),
                         new Ride(0.1, 1) };
        InvoiceSummary summary = invoiceGenerator.calculateFare(rides);
        InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(2, 30.0);
        Assert.assertEquals(expectedInvoiceSummary, summary);
    }

    @Test
    public void givenUserId_WhenPresentInRideRepository_ShouldReturnInvoiceSummary() {
        Ride[] rides1 = { new Ride(2.0, 5),
                          new Ride(0.1, 1)};
        Ride[] rides2 = { new Ride(3.0, 5),
                          new Ride(0.2, 1)};
        invoiceGenerator.addRides( "1", rides1);
        invoiceGenerator.addRides( "2", rides2);
        InvoiceSummary summary = invoiceGenerator.invoiceService("2");
        InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(2, 40.0);
        Assert.assertEquals(expectedInvoiceSummary, summary);
    }


    @Test
    public void givenPremiumRide_ShouldReturnTotalFare() {
        double distance = 2.0;
        int time = 5;
        double fare = invoiceGenerator.calculatePremiumFare(distance, time);
        Assert.assertEquals(40, fare, 0.0);
    }

    @Test
    public void givenLessDistanceAndTime_PremiumRide_ShouldReturnTotalFare() {
        double distance = 0.2;
        int time = 1;
        double fare = invoiceGenerator.calculatePremiumFare(distance, time);
        Assert.assertEquals(20, fare, 0.0);
    }

}
