package com.pbd.gifty;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.io.File;

@ConfigurationProperties(prefix = "com.gifty")
public class GiftyProperties {

    private File gifLocation;

    public File getGifLocation() {
        return gifLocation;
    }

    public void setGifLocation(File gifLocation) {
        this.gifLocation = gifLocation;
    }
}
