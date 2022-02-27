package com.phonepe.test.main;

import com.phonepe.test.manager.CabManager;
import com.phonepe.test.manager.CityManager;
import com.phonepe.test.pojo.Cab;
import com.phonepe.test.pojo.City;
import com.phonepe.test.service.TripService;

import java.util.ArrayList;
import java.util.List;

public class Main {
    //City names can be duplicate but not in same state
    public static void main(String[] args) {
        List<City> cities = new ArrayList<>();
        int citiesCount = 10;
        for (int i = 0; i < citiesCount; i++) {
            City city = new City(i, "CityName" + i, "StateName" + i);
            cities.add(city);
            CityManager.registerNewCity(city);
        }
        List<Cab> cabs = new ArrayList<>();
        int cabsCount = 10;
        for (int i = 0; i < cabsCount; i++) {
            for (int j = 0; j < 3; j++) {
                Cab cab = new Cab("licencePlate" + i + j, cities.get(i));
                cabs.add(cab);
                CabManager.registerNewCab(cab);
            }
        }

        Cab cab1 = TripService.bookTrip(cities.get(0), cities.get(9));
        Cab cab2 = TripService.bookTrip(cities.get(0), cities.get(9));
        TripService.completeTrip(cab1);
        TripService.completeTrip(cab2);
        TripService.printCurrentCabStatesPerCity();
    }
}
