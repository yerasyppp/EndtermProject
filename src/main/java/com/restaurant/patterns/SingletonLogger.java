package com.restaurant.patterns;

import java.time.LocalDateTime;

public class SingletonLogger {
    private static SingletonLogger instance;

    private SingletonLogger() {}

    public static synchronized SingletonLogger getInstance() {
        if (instance == null) {
            instance = new SingletonLogger();
        }
        return instance;
    }

    public void log(String message) {
        System.out.println("[LOG " + LocalDateTime.now() + "]: " + message);
    }
}