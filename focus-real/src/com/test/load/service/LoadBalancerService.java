package com.test.load.service;

import java.util.ArrayList;
import java.util.List;

public class LoadBalancerService {
    public static void main(String[] args) {
        List<ServerInfo> serverInfos = new ArrayList<>();
        serverInfos.add(new ServerInfo("s1", 30l));
        serverInfos.add(new ServerInfo("s2", 30l));
        serverInfos.add(new ServerInfo("s3", 40l));
        LoadBalancer lb = new LoadBalancer(serverInfos);
        int count = 10;
        for (int i = 1; i <= count; i++) {
            lb.handleRequestForLoad();

        }
        lb.printCurrentLoad();
    }

}
