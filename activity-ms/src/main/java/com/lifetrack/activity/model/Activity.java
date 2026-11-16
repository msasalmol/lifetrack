package com.lifetrack.activity.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.Instant;

@Data
@Document("activities")
public class Activity {
    @Id
    private String id;
    @Indexed
    private String userId;          // hard-coded for now, will come from JWT later
    private ActivityType type;
    private String title;
    private double distanceKm;
    private long durationSeconds;
    private Instant startTime;
    private Integer avgHeartRate;   // Integer (not int) = optional
    private String notes;
    private Instant createdAt;
}
