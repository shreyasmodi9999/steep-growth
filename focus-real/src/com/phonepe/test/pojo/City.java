package com.phonepe.test.pojo;

import java.util.Objects;

public class City {
    private int cityId;
    private String cityName;
    private String cityState;

    public City(int cityId, String cityName, String cityState) {
        this.cityId = cityId;
        this.cityName = cityName;
        this.cityState = cityState;
    }

    public int getCityId() {
        return cityId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        City city = (City) o;
        return cityId == city.cityId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(cityId);
    }

    @Override
    public String toString() {
        return "City{" +
                "cityId=" + cityId +
                ", cityName='" + cityName + '\'' +
                ", cityState='" + cityState + '\'' +
                '}';
    }
}
