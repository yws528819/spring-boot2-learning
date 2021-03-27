package com.yws.endpoint;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.endpoint.annotation.WriteOperation;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.Map;

@Component
@Endpoint(id = "myService")
public class MyServiceEndPoint {


    @ReadOperation
    public Map getDockerInfo() {
        return Collections.singletonMap("dockerInfo", "docker started...");
    }

    @WriteOperation
    public void stopDocker() {
        System.out.println("docker stopped ...");
    }
}
