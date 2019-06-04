package com.gojek.parkinglot;

import com.gojek.parkinglot.services.ParkingAllocator;

import java.util.Scanner;

/**
 * Created by Mohan Kotla on 01/June/2019
 */

// Class that run everything
public class Main {

    public static void main(String[] args) {

        ParkingAllocator allocator = new ParkingAllocator();

        switch (args.length) {
            case 0://Interactive Approach
                System.out.println("Please enter Input... , Else enter 'exit' to quit");
                while (Boolean.TRUE) {// Run an infinite loop
                    Scanner sc = new Scanner(System.in);
                    String inputQuery = sc.nextLine();
                    if (inputQuery.equalsIgnoreCase("exit")) {
                        break;
                    } else if (inputQuery == null) {
                        // Do nothing
                    } else {
                        allocator.executeQuery(inputQuery);
                    }
                }
                break;
            case 1://File Approach
                allocator.executeQueriesFromFile(args[0]);
                break;
            default:
                System.out.println("Invalid Input.");

        }
    }
}
