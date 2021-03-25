package com.yws.health;

import org.springframework.boot.actuate.health.AbstractHealthIndicator;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.Status;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class MyComHealthIndicator extends AbstractHealthIndicator {
    @Override
    protected void doHealthCheck(Health.Builder builder) throws Exception {
        builder.status(Status.UP);

        Map<String, Object> map = new HashMap<>();
        map.put("key1", "value1");

        builder.withDetail("key2", "value2").withDetails(map);
    }
}
