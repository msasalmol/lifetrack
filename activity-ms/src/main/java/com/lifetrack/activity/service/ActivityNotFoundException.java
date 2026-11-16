package com.lifetrack.activity.service;

public class ActivityNotFoundException extends RuntimeException {
    public ActivityNotFoundException(String id) {
        super("Activity not found: " + id);
    }
}