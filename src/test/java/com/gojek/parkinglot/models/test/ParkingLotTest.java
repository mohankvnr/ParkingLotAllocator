package com.gojek.parkinglot.models.test;

import com.gojek.parkinglot.models.ParkingLot;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by Mohan Kotla on 02/June/2019.
 */
public class ParkingLotTest {
    ParkingLot parkingLot = new ParkingLot();
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
    //Testcase for creating Parking Lot
    public void testCreateParkingLot() throws Exception {
        parkingLot.createParkingLot("6");
        assertEquals(6, parkingLot.getNumberOfAvailableSlots());
        assertEquals(6, parkingLot.getSlots().length);
        assertTrue("Created a parking lot with 6 slots".equalsIgnoreCase(outContent.toString().trim()));
    }

    @Test
    //Testcase for allocating parking slot
    public void testAllocateSlot() throws Exception {
        parkingLot.createParkingLot("6");
        parkingLot.allocateSlot("KA-01-HH-1234", "White");
        parkingLot.allocateSlot("KA-01-HH-9999", "White");
        assertEquals(4, parkingLot.getNumberOfAvailableSlots());
    }

    @Test
    //Testcase for allocating parking slot before creating parking lot
    public void testAllocateSlotBeforeCreatingParkingLot() throws Exception {
        parkingLot.allocateSlot("KA-01-HH-1234", "White");
        assertEquals("Sorry,parking lot is not created", outContent.toString().trim());
    }

    @Test
    //Testcase for releasing parking slot
    public void testReleaseSlot() throws Exception {
        parkingLot.createParkingLot("6");
        parkingLot.allocateSlot("KA-01-HH-1234", "White");
        parkingLot.allocateSlot("KA-01-HH-9999", "White");
        parkingLot.releaseSlot("2");
        assertEquals(5, parkingLot.getNumberOfAvailableSlots());
        assertEquals("Created a parking lot with 6 slots\n" +
                "Allocated slot number: 1\n" +
                "Allocated slot number: 2\n" +
                "Slot number 2 is free", outContent.toString().trim());
    }

    @Test
    //Testcase for releasing parking slot before creating parking lot
    public void testReleaseSlotBeforeCreatingParkingLot() throws Exception {
        parkingLot.releaseSlot("2");
        assertEquals("Sorry,parking lot is not created", outContent.toString().trim());
    }


    @Test
    //Testcase for getting status of parking lot
    public void testPrintAllAllocated() throws Exception {
        parkingLot.createParkingLot("6");
        parkingLot.allocateSlot("KA-01-HH-1234", "White");
        parkingLot.allocateSlot("KA-01-HH-9999", "White");
        parkingLot.printAllAllocated();
        assertEquals(4, parkingLot.getNumberOfAvailableSlots());
        assertEquals("Created a parking lot with 6 slots\n" +
                "Allocated slot number: 1\n" +
                "Allocated slot number: 2\n" +
                "Slot No.\tRegistration No\tColour\n" +
                "1\tKA-01-HH-1234\tWhite\n" +
                "2\tKA-01-HH-9999\tWhite", outContent.toString().trim());
    }

    @Test
    //Testcase for getting status of parking lot before creating parking lot
    public void testPrintAllAllocatedBeforeCreatingParkingLot() throws Exception {
        parkingLot.printAllAllocated();
        assertEquals("Sorry,parking lot is not created", outContent.toString().trim());
    }

    @Test
    //Testcase for printing registration numbers for given color
    public void testPrintRegistrationNumbersFromColor() throws Exception {
        parkingLot.createParkingLot("6");
        parkingLot.allocateSlot("KA-01-HH-1234", "White");
        parkingLot.allocateSlot("KA-01-HH-9999", "White");
        parkingLot.allocateSlot("KA-01-BB-0001", "Black");
        parkingLot.printRegistrationNumbersFromColor("White");
        assertEquals(3, parkingLot.getNumberOfAvailableSlots());
        assertEquals("Created a parking lot with 6 slots\n" +
                "Allocated slot number: 1\n" +
                "Allocated slot number: 2\n" +
                "Allocated slot number: 3\n" +
                "KA-01-HH-1234, KA-01-HH-9999", outContent.toString().trim());
    }

    @Test
    //Testcase if registration numbers not found for given color
    public void testRegistrationNumberNotFoundForColor() throws Exception {
        parkingLot.createParkingLot("6");
        parkingLot.allocateSlot("KA-01-HH-1234", "White");
        parkingLot.allocateSlot("KA-01-HH-9999", "White");
        parkingLot.allocateSlot("KA-01-BB-0001", "Black");
        parkingLot.printRegistrationNumbersFromColor("Red");
        assertEquals(3, parkingLot.getNumberOfAvailableSlots());
        assertEquals("Created a parking lot with 6 slots\n" +
                "Allocated slot number: 1\n" +
                "Allocated slot number: 2\n" +
                "Allocated slot number: 3\n" +
                "Not found", outContent.toString().trim());
    }

    @Test
    //Testcase for printing slot numbers for given color
    public void testPrintSlotNumbersFromColor() throws Exception {
        parkingLot.createParkingLot("6");
        parkingLot.allocateSlot("KA-01-HH-1234", "White");
        parkingLot.allocateSlot("KA-01-HH-9999", "White");
        parkingLot.allocateSlot("KA-01-BB-0001", "Black");
        parkingLot.printSlotNumbersFromColor("White");
        assertEquals(3, parkingLot.getNumberOfAvailableSlots());
        assertEquals("Created a parking lot with 6 slots\n" +
                "Allocated slot number: 1\n" +
                "Allocated slot number: 2\n" +
                "Allocated slot number: 3\n" +
                "1, 2", outContent.toString().trim());
    }

    @Test
    //Testcase if slot numbers not found for given color
    public void testSlotNumberNotFoundFromColor() throws Exception {
        parkingLot.createParkingLot("6");
        parkingLot.allocateSlot("KA-01-HH-1234", "White");
        parkingLot.allocateSlot("KA-01-HH-9999", "White");
        parkingLot.allocateSlot("KA-01-BB-0001", "Black");
        parkingLot.printSlotNumberFromRegNo("KA-01-HH-9933");
        assertEquals(3, parkingLot.getNumberOfAvailableSlots());
        assertEquals("Created a parking lot with 6 slots\n" +
                "Allocated slot number: 1\n" +
                "Allocated slot number: 2\n" +
                "Allocated slot number: 3\n" +
                "Not found", outContent.toString().trim());
    }

    @Test
    //Testcase for printing slot number for given registration number
    public void testPrintSlotNumberFromRegNo() throws Exception {
        parkingLot.createParkingLot("6");
        parkingLot.allocateSlot("KA-01-HH-1234", "White");
        parkingLot.allocateSlot("KA-01-HH-9999", "White");
        parkingLot.allocateSlot("KA-01-BB-0001", "Black");
        parkingLot.printSlotNumberFromRegNo("KA-01-HH-9999");
        assertEquals(3, parkingLot.getNumberOfAvailableSlots());
        assertEquals("Created a parking lot with 6 slots\n" +
                "Allocated slot number: 1\n" +
                "Allocated slot number: 2\n" +
                "Allocated slot number: 3\n" +
                "2", outContent.toString().trim());
    }

    @Test
    //Testcase if slot numbers not found for given registration number
    public void testSlotNumberNotFoundFromRegNo() throws Exception {
        parkingLot.createParkingLot("6");
        parkingLot.allocateSlot("KA-01-HH-1234", "White");
        parkingLot.allocateSlot("KA-01-HH-9999", "White");
        parkingLot.allocateSlot("KA-01-BB-0001", "Black");
        parkingLot.printSlotNumberFromRegNo("KA-01-HH-9993");
        assertEquals(3, parkingLot.getNumberOfAvailableSlots());
        assertEquals("Created a parking lot with 6 slots\n" +
                "Allocated slot number: 1\n" +
                "Allocated slot number: 2\n" +
                "Allocated slot number: 3\n" +
                "Not found", outContent.toString().trim());
    }
}