package com.gojek.parkinglot.services.test;

import com.gojek.parkinglot.services.ParkingAllocator;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

/**
 * Created by Mohan Kotla on 02/June/2019.
 */
public class ParkingAllocatorTest {
    ParkingAllocator parkingAllocator = new ParkingAllocator();
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void cleanUpStreams() {
        System.setOut(null);
    }

    @Test
    public void executeQuery() {
        parkingAllocator.executeQuery("hello");
        assertEquals("Invalid input.", outContent.toString().trim());
        parkingAllocator.executeQuery("create_parking_lot 6");
        assertEquals("Invalid input.\nCreated a parking lot with 6 slots", outContent.toString().trim());
    }
}