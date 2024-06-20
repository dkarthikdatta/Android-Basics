package com.example.myapplication.machinecoding.rideSharing.pricingStrategy;

import com.example.myapplication.machinecoding.rideSharing.TripMetaData;
import com.example.myapplication.machinecoding.rideSharing.Util;

import java.util.logging.Logger;

public class RatingBasedPricingStrategy implements PricingStrategy {
    private static final Logger logger = Logger.getLogger(RatingBasedPricingStrategy.class.getName());

    @Override
    public double calculatePrice(TripMetaData pTripMetaData) {
        double price = Util.isHighRating(pTripMetaData.getRiderRating()) ? 55.0 : 65.0;
        logger.info("Based on " + Util.ratingToString(pTripMetaData.getRiderRating()) +
                " rider rating, price of the trip is " + price);
        return price;
    }
}



