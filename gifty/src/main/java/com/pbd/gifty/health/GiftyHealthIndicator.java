package com.pbd.gifty.health;

import com.pbd.gifty.GiftyProperties;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

import javax.inject.Inject;

@Component
public class GiftyHealthIndicator implements HealthIndicator {

    @Inject
    private GiftyProperties properties;

    @Override
    public Health health() {
        if(!properties.getGifLocation().canWrite()) {
            return Health.down().build();
        }

        return Health.up().build();
    }
}
