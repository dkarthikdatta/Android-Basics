package com.example.myapplication.machinecoding.rideSharing;


// This class basically has all the info that will be used by strategy
// Pricing strategy and Driver Matching strategy will need data
// Even if more data is needed, only this class needs to be updated

public class TripMetaData {
    private Location srcLoc;
    private Location dstLoc;
    private RATING riderRating;
    private RATING driverRating;

    public TripMetaData(Location pSrcLoc, Location pDstLoc, RATING pRiderRating) {
        this.srcLoc = pSrcLoc;
        this.dstLoc = pDstLoc;
        this.riderRating = pRiderRating;
        this.driverRating = RATING.UNASSIGNED;
    }

    // Getters and setters
    public RATING getRiderRating() {
        return riderRating;
    }

    public RATING getDriverRating() {
        return driverRating;
    }

    public void setDriverRating(RATING pDriverRating) {
        this.driverRating = pDriverRating;
    }
}



