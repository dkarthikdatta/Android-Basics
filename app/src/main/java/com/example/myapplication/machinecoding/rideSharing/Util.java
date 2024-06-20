package com.example.myapplication.machinecoding.rideSharing;

import java.util.HashMap;

public class Util {
    private static int nextTripId = 1;

    public enum TRIP_STATUS {
        UNASSIGNED,
        DRIVER_ON_THE_WAY,
        DRIVER_ARRIVED,
        STARTED,
        PAUSED,
        CANCELLED,
        ENDED
    }

    public static String ratingToString(RATING pRating) {
        switch (pRating) {
            case ONE_STAR:
                return "one star";
            case TWO_STARS:
                return "two stars";
            case THREE_STARS:
                return "three stars";
            case FOUR_STARS:
                return "four stars";
            case FIVE_STARS:
                return "five stars";
            default:
                return "invalid rating";
        }
    }

    public static boolean isHighRating(RATING pRating) {
        return pRating == RATING.FOUR_STARS || pRating == RATING.FIVE_STARS;
    }
}

