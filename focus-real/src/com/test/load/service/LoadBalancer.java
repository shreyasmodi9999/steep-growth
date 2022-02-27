package com.test.load.service;

import java.util.ArrayList;
import java.util.List;

public class LoadBalancer {

    private long totalActive;
    private List<ServerInfo> underLoad;
    private List<ServerInfo> overLoad;
    private List<ServerInfo> allServers;

    /**
     * Selects optimal server based on load and recalculates load for each server
     */
    public void handleRequestForLoad() {
        ServerInfo pickedServer = pickServer();
        increamentTotalActiveRequest();
        pickedServer.increaseActiveRequest();
        reCalculateLoad();
        reBalance();
    }

    private void increamentTotalActiveRequest() {
        totalActive++;
    }

    private void reBalance() {
        underLoad.clear();
        overLoad.clear();
        for (ServerInfo serverInfo : allServers) {
            if (serverInfo.getCurrentLoad() < serverInfo.getExpectedLoad()) {
                underLoad.add(serverInfo);
            } else {
                overLoad.add(serverInfo);
            }
        }
        if (!underLoad.isEmpty()) {
            underLoad.sort(ServerInfo::compareTo);
        }
        if (!overLoad.isEmpty()) {
            overLoad.sort(ServerInfo::compareTo);
        }
    }

    private void reCalculateLoad() {
        for (ServerInfo serverInfo : allServers) {
            serverInfo.calculateNewLoadPercentage(getTotalActive());
        }
    }

    private ServerInfo pickServer() {
        if (!underLoad.isEmpty()) {
            return underLoad.get(0);
        }
        return overLoad.get(0);
    }


    public long getTotalActive() {
        return totalActive;
    }

    public void setTotalActive(long totalActive) {
        this.totalActive = totalActive;
    }

    public LoadBalancer(List<ServerInfo> all) {
        underLoad = new ArrayList<>();
        overLoad = new ArrayList<>();
        totalActive = 0;
        this.allServers = all;
        for (ServerInfo serverInfo : all) {
            underLoad.add(serverInfo);
        }
        underLoad.sort(ServerInfo::compareTo);
    }

    public void printCurrentLoad() {
        for (ServerInfo serverInfo : allServers) {
            System.out.println("ServerName=" + serverInfo.getHostName() + ",CurrentLoad=" + serverInfo.getCurrentLoad());
        }
    }
}
