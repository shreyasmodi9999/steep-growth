package com.phonepe.test.manager;

import com.phonepe.test.pojo.Cab;
import com.phonepe.test.pojo.CabState;
import com.phonepe.test.pojo.City;
import com.phonepe.test.service.TripService;

import java.util.HashMap;
import java.util.Map;

public class CabManager {
    private static final Map<String, Cab> cabsMap = new HashMap<>();

    public static void registerNewCab(Cab cab) {
        if (!cabsMap.containsKey(cab.getLicencePlate())) {
            City city = CityManager.getCity(cab.getCurrentCity().getCityId());
            if (city != null) {
                cabsMap.put(cab.getLicencePlate(), cab);
                TripService.registerNewCab(cab);
            }
        }
    }

    public static Cab getCab(String licencePlat) {
        return cabsMap.get(licencePlat);
    }

    public static void changeCity(String licencePlat, int cityId) {
        changeCity(getCab(licencePlat), CityManager.getCity(cityId));
    }

    public static void changeCity(Cab cab, City newCity) {
        if (cab != null && newCity != null) {
            if (getCab(cab.getLicencePlate()) != null &&
                    CityManager.getCity(newCity.getCityId()) != null) {
                TripService.changeCity(cab, newCity);
                cab.setCurrentCity(newCity);
            }
        }
    }

    public static void changeState(Cab cab, CabState newState, City destination) {
        if (cab != null && newState != null && cab.getCabState() != newState) {
            if (getCab(cab.getLicencePlate()) != null) {
                cab.setStateEventTimestamp(System.currentTimeMillis());
                TripService.changeState(cab, newState);
                cab.setCabState(newState);
                if (newState == CabState.ON_TRIP) {
                    cab.setDestination(destination);
                }
            }
        }
    }
}
