package com.epam.geometry.generator;

import java.util.UUID;

public class IDGenerator {

    private static final IDGenerator instance = new IDGenerator();

    private IDGenerator() {}

    public String getID() {
        UUID uuid = UUID.randomUUID();
        return uuid.toString();
    }

    public static IDGenerator getInstance() {
        return instance;
    }
}
