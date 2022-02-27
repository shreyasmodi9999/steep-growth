package com.test.load.service;

public class ServerInfo implements Comparable<ServerInfo> {
    private String hostName;
    private String ipAddress;
    private double currentLoad;
    private long activeRequest;
    private double expectedLoad;

    public ServerInfo(String hostName, long load) {
        this.hostName = hostName;
        expectedLoad = load;
    }

    public void increaseActiveRequest() {
        activeRequest++;
    }

    public void decreaseActiveRequest() {
        activeRequest--;
    }

    public void calculateNewLoadPercentage(long totalActiveRequest) {
        currentLoad = activeRequest * 100 / totalActiveRequest;
    }

    public String getHostName() {
        return hostName;
    }

    public void setHostName(String hostName) {
        this.hostName = hostName;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public double getCurrentLoad() {
        return currentLoad;
    }

    public void setCurrentLoad(double currentLoad) {
        this.currentLoad = currentLoad;
    }

    public long getActiveRequest() {
        return activeRequest;
    }

    public void setActiveRequest(long activeRequest) {
        this.activeRequest = activeRequest;
    }

    public double getExpectedLoad() {
        return expectedLoad;
    }

    public void setExpectedLoad(double expectedLoad) {
        this.expectedLoad = expectedLoad;
    }

    @Override
    public int compareTo(ServerInfo o) {
        if (this.currentLoad < o.currentLoad) {
            return 0;
        } else {
            return 0;
        }
    }
}
