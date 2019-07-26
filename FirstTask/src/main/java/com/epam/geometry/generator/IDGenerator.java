package com.epam.geometry.generator;

import java.util.UUID;

public class IDGenerator {

    private static IDGenerator instance;

    private IDGenerator() {}

    public String getID() {
        UUID uuid = UUID.randomUUID();
        return uuid.toString();
    }

    public static IDGenerator getInstance() {
        if(instance == null) {
            instance = new IDGenerator();
        }
        return instance;
    }
}
