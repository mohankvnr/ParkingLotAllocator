package com.gojek.parkinglot.services;

import com.gojek.parkinglot.models.ParkingLot;
import com.gojek.parkinglot.models.Queries;

import java.io.*;
import java.lang.reflect.Method;


/**
 * Created by Mohan Kotla on 01/June/2019
 */

//Service class that drives parking allocation
public class ParkingAllocator {

    ParkingLot parkingLot;
    Queries queries;

    public ParkingAllocator()  {
        queries = new Queries();
        parkingLot = new ParkingLot();
    }

    public void executeQuery(String inputQuery) {//Function to give interactive response
        String splittedQuery[] = inputQuery.split(" ");// Split the input to get query and input values
        switch (splittedQuery.length) {
            case 1:
                try {
                    Method method = queries.queriesMap.get(splittedQuery[0]);
                    if (method != null) {
                        method.invoke(parkingLot);
                    } else {
                        System.out.println("Invalid input.");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            case 2:
                try {
                    Method method = queries.queriesMap.get(splittedQuery[0]);
                    if (method != null) {
                        method.invoke(parkingLot, splittedQuery[1]);
                    } else {
                        System.out.println("Invalid input.");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            case 3:
                try {
                    Method method = queries.queriesMap.get(splittedQuery[0]);
                    if (method != null) {
                       method.invoke(parkingLot, splittedQuery[1], splittedQuery[2]);
                    } else {
                        System.out.println("Invalid input.");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            default:
                System.out.println("Invalid input.");
        }
    }

    public void executeQueriesFromFile(String filePath) {
        // Assuming input to be a valid file path.
        File inputFile = new File(filePath);
        try {
            BufferedReader br = new BufferedReader(new FileReader(inputFile));
            String line;
            try {
                while ((line = br.readLine()) != null) {
                    executeQuery(line.trim());
                }
            } catch (IOException ex) {
                System.out.println("Error in reading the input file.");
                ex.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found in the path specified.");
            e.printStackTrace();
        }
    }
}
