package com.lifetrack.activity.dto;

import com.lifetrack.activity.model.ActivityType;
import jakarta.validation.constraints.*;

import java.time.Instant;

public record CreateActivityRequest(
        @NotNull ActivityType type,
        @NotBlank @Size(max = 100) String title,
        @Positive double distanceKm,
        @Positive long durationSeconds,
        @NotNull @PastOrPresent Instant startTime,
        @Min(30) @Max(250) Integer avgHeartRate,
        @Size(max = 1000) String notes
) {}