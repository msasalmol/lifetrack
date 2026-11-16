package com.lifetrack.activity.dto;

import com.lifetrack.activity.model.Activity;
import com.lifetrack.activity.model.ActivityType;

import java.time.Instant;

public record ActivityResponse(String id, ActivityType type, String title, double distanceKm, long durationSeconds,
                               String pace, Instant startTime, Integer avgHeartRate, String notes, Instant createdAt) {
    public static ActivityResponse from(Activity a) {
        long secPerKm = Math.round(a.getDurationSeconds() / a.getDistanceKm());
        String pace = "%d:%02d /km".formatted(secPerKm / 60, secPerKm % 60);
        return new ActivityResponse(a.getId(), a.getType(), a.getTitle(), a.getDistanceKm(), a.getDurationSeconds(), pace, a.getStartTime(), a.getAvgHeartRate(), a.getNotes(), a.getCreatedAt());
    }
}