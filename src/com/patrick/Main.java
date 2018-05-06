package com.patrick;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

//starting with javaimmutableclasses
/*
challenge;
- what is wrong with the public location constructor in location class
that would allow the program to compile but crash at run time,
identify and modify code to fix
 */
public class Main {

    //initializing hashmap
    private static Map<Integer, Location> locations = new HashMap<Integer, Location>();

    public static void main(String[] args) {

        //instance for scanner
        Scanner scanner = new Scanner(System.in);

        //temporary map that are going be our exits, fixes errors
        Map<String, Integer> tempExit = new HashMap<String, Integer>();
        locations.put(0, new Location(0, "You are sitting in front of a computer learning Java",tempExit));
        tempExit.put("W", 2); //changed through edit find replace
        tempExit.put("E", 3);
        tempExit.put("S", 4);
        tempExit.put("N", 5);
        locations.put(1, new Location(1, "You are standing by a small building",tempExit));

        tempExit = new HashMap<String, Integer>();
        tempExit.put("N", 5);
        locations.put(2, new Location(2, "You are on a hill",tempExit));

        tempExit = new HashMap<String, Integer>();
        tempExit.put("W", 1);
        locations.put(3, new Location(3, "You are inside a building",tempExit));

        tempExit = new HashMap<String, Integer>();
        tempExit.put("N", 1);
        tempExit.put("W", 2);
        locations.put(4, new Location(4, "You are by a stream",tempExit));

        tempExit = new HashMap<String, Integer>();
        tempExit.put("S", 1);
        tempExit.put("W", 2);
        locations.put(5, new Location(5, "You are in a scary forest",tempExit));

        //run to make sure working....yes

        //create a map for vocabulary
        Map<String, String> vocabulary = new HashMap<String, String>();
        vocabulary.put("QUIT", "Q");
        vocabulary.put("NORTH", "N");
        vocabulary.put("SOUTH", "S");
        vocabulary.put("WEST", "W");
        vocabulary.put("EAST", "E");

        //while loop
        int loc = 1;
        while (true) {
            System.out.println(locations.get(loc).getDesription());
            //potential problem here....someone could remove
            //to location class
            //to test run this change, now class is fully immutable
            tempExit.remove("S");
            if (loc==0) {
                break;
            }

            //directions
            Map<String, Integer> exits = locations.get(loc).getExits(); //returning actual location object
            System.out.print("Available exits are; ");
            for (String exit : exits.keySet()) {
                System.out.print(exit + ", ");
            }
            System.out.println();

            //scanner instance
            String direction = scanner.nextLine().toUpperCase();

            //put a check in here,
            if (direction.length() > 1) { //if you put in more than one letter
                String[] words = direction.split(" ");
                for (String word : words) {
                    if (vocabulary.containsKey(word)) {
                        direction = vocabulary.get(word); //get retrieves value from the map
                        break;

                        //run to test
                    }
                }
            }

            if (exits.containsKey(direction)) {
                loc = exits.get(direction);
            } else {
                System.out.println("You cannot go in that direction");


            }

        }


    }

}

