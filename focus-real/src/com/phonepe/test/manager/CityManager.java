package com.phonepe.test.manager;

import com.phonepe.test.pojo.City;
import com.phonepe.test.service.TripService;

import java.util.HashMap;
import java.util.Map;

public class CityManager {
    private static final Map<Integer,City> cityMap = new HashMap<>();

    public static void registerNewCity(City city) {
        if (!cityMap.containsKey(city.getCityId())) {
            cityMap.put(city.getCityId(),city);
            TripService.registerNewCity(city);
        }
    }

    public static City getCity(int cityId)
    {
        return cityMap.get(cityId);
    }
}
