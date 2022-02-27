package com.phonepe.test.pojo;

import java.util.Comparator;
import java.util.Objects;

public class Cab implements Comparable<Cab> {
    // cabId
    private String licencePlate;
    private CabState cabState;
    private City currentCity;
    private Long stateEventTimestamp;
    private City destination;

    public Cab(String licencePlate, City currentCity) {
        this.licencePlate = licencePlate;
        this.cabState = CabState.IDLE;
        this.currentCity = currentCity;
        this.stateEventTimestamp = System.currentTimeMillis();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cab cab = (Cab) o;
        return Objects.equals(licencePlate, cab.licencePlate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(licencePlate);
    }

    public String getLicencePlate() {
        return licencePlate;
    }

    public CabState getCabState() {
        return cabState;
    }

    public City getCurrentCity() {
        return currentCity;
    }

    public Long getStateEventTimestamp() {
        return stateEventTimestamp;
    }

    public void setCabState(CabState cabState) {
        this.cabState = cabState;
    }

    public void setCurrentCity(City currentCity) {
        this.currentCity = currentCity;
    }

    public void setStateEventTimestamp(Long stateEventTimestamp) {
        this.stateEventTimestamp = stateEventTimestamp;
    }

    public City getDestination() {
        return destination;
    }

    public void setDestination(City destination) {
        this.destination = destination;
    }

    @Override
    public int compareTo(Cab o) {

        int compare = this.stateEventTimestamp.compareTo(o.getStateEventTimestamp());
        return compare != 0 ? compare : this.licencePlate.compareTo(o.getLicencePlate());
    }

    @Override
    public String toString() {
        return "Cab{" +
                "licencePlate='" + licencePlate + '\'' +
                ", cabState=" + cabState +
                ", currentCity=" + currentCity +
                ", stateEventTimestamp=" + stateEventTimestamp +
                ", destination=" + destination +
                "}\n";
    }
}
