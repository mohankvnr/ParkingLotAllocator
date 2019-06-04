package com.gojek.parkinglot.models;

/**
 * Created by Mohan Kotla on 01/June/2019
 */

public class ParkingLot {
    private ParkingSlot slots[];
    private int numberOfAvailableSlots;

    public void ParkingLot() {
    }

    public ParkingSlot[] getSlots() {
        return slots;
    }

    public int getNumberOfAvailableSlots() {
        return numberOfAvailableSlots;
    }

    public void createParkingLot(String numberOfSlots) {
        this.slots = new ParkingSlot[Integer.parseInt(numberOfSlots)];
        this.numberOfAvailableSlots = Integer.parseInt(numberOfSlots);
        for (int i = 0; i < Integer.parseInt(numberOfSlots); i++) {
            ParkingSlot slot = new ParkingSlot();
            slot.setVehicleNumber("");
            slot.setColor("");
            slot.setOccupied(Boolean.FALSE);
            slots[i] = slot;
        }
        System.out.println("Created a parking lot with " + numberOfSlots + " slots");
    }

    private int GetNearestAvailableSlotIndex() {
        for (int i = 0; i < this.slots.length; i++) {
            if (slots[i].getOccupied() == Boolean.FALSE) {
                return i;
            }
        }
        return this.slots.length;
    }

    public void allocateSlot(String vehicleNumber, String color) {
        if (slots != null) {
            String response = "";
            if (this.numberOfAvailableSlots != 0) {
                int nearSlot = GetNearestAvailableSlotIndex();
                if (nearSlot < this.slots.length) {
                    slots[nearSlot].setVehicleNumber(vehicleNumber);
                    slots[nearSlot].setColor(color);
                    slots[nearSlot].setOccupied(Boolean.TRUE);
                    this.numberOfAvailableSlots--;
                    response = "Allocated slot number: " + (nearSlot + 1);
                } else {
                    response = "Sorry, parking lot is full";
                }
            } else {
                response = "Sorry, parking lot is full";
            }
            System.out.println(response);
        } else {
            System.out.println("Sorry,parking lot is not created");
        }
    }

    public void releaseSlot(String slotNumber) {
        if (slots != null) {
            String response = "";
            int slot = Integer.parseInt(slotNumber);
            if (slot <= slots.length) {
                slots[slot - 1].setVehicleNumber("");
                slots[slot - 1].setColor("");
                slots[slot - 1].setOccupied(Boolean.FALSE);
                numberOfAvailableSlots++;
                response = "Slot number " + slotNumber + " is free";
            } else {
                response = "Error,Give slot number between " + 0 + " and " + (slots.length - 1);
            }
            System.out.println(response);
        } else {
            System.out.println("Sorry,parking lot is not created");
        }
    }


    public void printAllAllocated() {
        if (slots != null) {
        String list = "Slot No.\tRegistration No\tColour\n";
        for (int i = 0; i < this.slots.length; i++) {
            if (slots[i].getOccupied() == Boolean.TRUE) {
                list = list + (i + 1) + "\t" + slots[i].getVehicleNumber() + "\t" + slots[i].getColor() + "\n";
            }
        }
        System.out.print(list);
        } else {
            System.out.println("Sorry,parking lot is not created");
        }
    }


    public void printRegistrationNumbersFromColor(String vehicleColor) {
        String regNumbers = "";
        for (int i = 0; i < this.slots.length; i++) {
            if (slots[i].getOccupied() == Boolean.TRUE && slots[i].getColor().equals(vehicleColor.trim())) {
                regNumbers = regNumbers + slots[i].getVehicleNumber() + ", ";
            }
        }
        System.out.println(regNumbers.equals("")?"Not found":regNumbers.substring(0, regNumbers.length() - 2));
    }

    public void printSlotNumbersFromColor(String vehicleColor) {
        String slotNumbers = "";
        for (int i = 0; i < this.slots.length; i++) {
            if (slots[i].getOccupied() == Boolean.TRUE && slots[i].getColor().equals(vehicleColor.trim())) {
                slotNumbers = slotNumbers + (i + 1) + ", ";
            }
        }
        System.out.println(slotNumbers.equals("")?"Not found":slotNumbers.substring(0, slotNumbers.length() - 2));
    }

    public void printSlotNumberFromRegNo(String vehicleNumber) {
        int slotNumber = 0;
        for (int i = 0; i < this.slots.length; i++) {
            if (slots[i].getOccupied() == Boolean.TRUE && slots[i].getVehicleNumber().equals(vehicleNumber)) {
                slotNumber = i + 1;
                break;
            }
        }
        System.out.println(slotNumber != 0?slotNumber:"Not found");
    }
}
