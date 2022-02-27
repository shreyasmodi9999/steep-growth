package com.phonepe.test.service;

import com.phonepe.test.manager.CabManager;
import com.phonepe.test.manager.CityManager;
import com.phonepe.test.pojo.Cab;
import com.phonepe.test.pojo.CabState;
import com.phonepe.test.pojo.City;

import java.util.*;

public class TripService {
    //For cabs chosen tree set in place of queue to facilitate quick check on cab existence as well
    private static final Map<City, Map<CabState, Set<Cab>>> tripRegister = new HashMap<>();

    public static void registerNewCab(Cab cab) {
        if (tripRegister.containsKey(cab.getCurrentCity())) {
            tripRegister.get(cab.getCurrentCity()).get(cab.getCabState()).add(cab);
        }
    }

    public static void registerNewCity(City city) {
        if (!tripRegister.containsKey(city)) {
            HashMap<CabState, Set<Cab>> cabStateTreeSetHashMap = new HashMap<>();
            for (CabState cabState : CabState.values()) {
                cabStateTreeSetHashMap.put(cabState, new TreeSet<>());
            }
            tripRegister.put(city, cabStateTreeSetHashMap);
        }
    }

    public static void changeCity(Cab cab, City newCity) {
        Map<CabState, Set<Cab>> cabStateSetMap = tripRegister.get(cab.getCurrentCity());
        cabStateSetMap.get(cab.getCabState()).remove(cab);
        cabStateSetMap = tripRegister.get(newCity);
        cabStateSetMap.get(cab.getCabState()).add(cab);
    }

    public static void changeState(Cab cab, CabState newState) {
        Map<CabState, Set<Cab>> cabStateSetMap = tripRegister.get(cab.getCurrentCity());
        cabStateSetMap.get(cab.getCabState()).remove(cab);
        cabStateSetMap.get(newState).add(cab);
    }

    public static Cab bookTrip(City source, City destination) {
        if (CityManager.getCity(source.getCityId()) == null ||
                CityManager.getCity(destination.getCityId()) == null) {
            return null;
        }
        if (source == destination) {
            return null;
        }
        Set<Cab> cabs = tripRegister.get(source).get(CabState.IDLE);
        if (cabs.isEmpty()) {
            return null;
        }
        Cab cab = cabs.iterator().next();
        CabManager.changeState(cab, CabState.ON_TRIP, destination);
        return cab;
    }

    public static void completeTrip(Cab cab) {
        if (cab != null && cab.getCabState() == CabState.ON_TRIP) {
            CabManager.changeCity(cab, cab.getDestination());
            CabManager.changeState(cab, CabState.IDLE, null);
        }
    }

    public static void printCurrentCabStatesPerCity() {
        System.out.println(tripRegister);
    }
}
