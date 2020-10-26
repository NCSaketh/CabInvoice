package com.cg.cabinvoice;

import org.jetbrains.annotations.NotNull;

public class InvoiceGenerator {

    private static final int COST_PER_TIME = 1;
    private static final double MINIMUM_COST_PER_KM = 10;
    private static final double PREMIUM_MINIMUM_COST_PER_KM = 15;
    private static final int PREMIUM_COST_PER_TIME = 2;

    public double calculateFare(double distance, int time) {
        double fare = distance * MINIMUM_COST_PER_KM +
                time * COST_PER_TIME;
        return fare>5 ? fare : 5;
    }

    public InvoiceSummary calculateFare(@NotNull Ride[] rides) {
        double totalFare = 0;
        for(Ride ride : rides) {
            totalFare += this.calculateFare(ride.distance, ride.time);
        }
        return new InvoiceSummary(rides.length, totalFare);

    }

    public InvoiceSummary invoiceService(String userID) {
        return calculateFare(RideRepository.userRidesHashMap.get(userID));
    }

    public void addRides(String userID, Ride[] rides) {
        RideRepository.userRidesHashMap.put(userID, rides);
    }

    public double calculatePremiumFare(double distance, int time) {
        double fare = distance * PREMIUM_MINIMUM_COST_PER_KM +
                      time * PREMIUM_COST_PER_TIME;
        //return Math.max(fare, PREMIUM_MINIMUM_FARE);
        return fare>20 ? fare : 20;
    }
}
