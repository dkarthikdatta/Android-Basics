package com.example.myapplication.machinecoding.rideSharing;


import com.example.myapplication.machinecoding.rideSharing.dao.Driver;
import com.example.myapplication.machinecoding.rideSharing.dao.Rider;
import com.example.myapplication.machinecoding.rideSharing.dao.Trip;
import com.example.myapplication.machinecoding.rideSharing.managers.DriverMgr;
import com.example.myapplication.machinecoding.rideSharing.managers.RiderMgr;
import com.example.myapplication.machinecoding.rideSharing.managers.TripMgr;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        //---------------Creating Riders and Drivers--------------------------------
        Rider keertiRider = new Rider("Keerti", RATING.FIVE_STARS);
        Rider gauravRider = new Rider("Gaurav", RATING.THREE_STARS);
        RiderMgr riderMgr = RiderMgr.getRiderMgr();
        riderMgr.addRider("keerti", keertiRider);
        riderMgr.addRider("gaurav", gauravRider);

        Driver yogitaDriver = new Driver("Yogita", RATING.THREE_STARS);
        Driver riddhiDriver = new Driver("Riddhi", RATING.FOUR_STARS);
        DriverMgr driverMgr = DriverMgr.getDriverMgr();
        driverMgr.addDriver("yogita", yogitaDriver);
        driverMgr.addDriver("riddhi", riddhiDriver);

        //These details in turn will be stored in database
        //-------------------------------------------------------------------------

        TripMgr tripMgr = TripMgr.getTripMgr();

        System.out.println("\nCreating Trip for Keerti from location (10,10) to (30,30)");
        tripMgr.createTrip(keertiRider, new Location(10, 10), new Location(30, 30));

        System.out.println("\nCreating Trip for Gaurav from location (200,200) to (500,500)");
        tripMgr.createTrip(gauravRider, new Location(200, 200), new Location(500, 500));

        //-------------------Display all the trips created--------------------------
        HashMap<Integer, Trip> tripsMap = tripMgr.getTripsMap();
        for (Map.Entry<Integer, Trip> mapVal : tripsMap.entrySet()) {
            mapVal.getValue().displayTripDetails();
        }
    }
}


