package com.patrick;

import java.util.HashMap;
import java.util.Map;

//class
public class Location {

    //fields or variables, made final
    private final int locationID;
    private final String desription;
    private final Map<String, Integer> exits;

    //constructor, for location id and description
    public Location(int locationID, String desription, Map<String, Integer> exits) {
        this.locationID = locationID;
        this.desription = desription;
        this.exits = new HashMap<String, Integer>(exits);
        //back to main to test run

        this.exits.put("Q", 0); //ability to quit out of a particular location
    }

    //getters for all
    public int getLocationID() {
        return locationID;
    }

    public String getDesription() {
        return desription;
    }

    public Map<String, Integer> getExits() {
        return new HashMap<String, Integer>(exits);
    }
}
