package com.gojek.parkinglot.models;

import com.gojek.parkinglot.commons.Constants;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Mohan Kotla on 02/June/2019
 */

//Class that maps query string to method
public class Queries {
    public Map<String, Method> queriesMap;

    public Queries () {
        queriesMap = new HashMap<String, Method>();
        try {
            queriesMap.put(Constants.CREATE_PARKING_LOT, ParkingLot.class.getMethod("createParkingLot", String.class));
            queriesMap.put(Constants.PARK, ParkingLot.class.getMethod("allocateSlot", String.class, String.class));
            queriesMap.put(Constants.LEAVE, ParkingLot.class.getMethod("releaseSlot", String.class));
            queriesMap.put(Constants.STATUS, ParkingLot.class.getMethod("printAllAllocated"));
            queriesMap.put(Constants.CAR_REG_NUMBERS_WITH_COLOR, ParkingLot.class.getMethod("printRegistrationNumbersFromColor", String.class));
            queriesMap.put(Constants.CAR_SLOT_NUMBER_WITH_COLOR, ParkingLot.class.getMethod("printSlotNumbersFromColor", String.class));
            queriesMap.put(Constants.SLOT_NUMBER_FOR_REG_NUMBER, ParkingLot.class.getMethod("printSlotNumberFromRegNo", String.class));
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
}
