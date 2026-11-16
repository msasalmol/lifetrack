package com.lifetrack.activity.service;

import com.lifetrack.activity.dto.ActivityResponse;
import com.lifetrack.activity.dto.CreateActivityRequest;
import com.lifetrack.activity.model.Activity;
import com.lifetrack.activity.repository.ActivityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

@Service
@RequiredArgsConstructor   // Lombok: constructor injection for final fields
public class ActivityService {

    private static final String DEMO_USER = "demo-user"; // replaced by JWT user later

    private final ActivityRepository repository;

    public ActivityResponse create(CreateActivityRequest req) {
        Activity a = new Activity();
        a.setUserId(DEMO_USER);
        a.setType(req.type());
        a.setTitle(req.title());
        a.setDistanceKm(req.distanceKm());
        a.setDurationSeconds(req.durationSeconds());
        a.setStartTime(req.startTime());
        a.setAvgHeartRate(req.avgHeartRate());
        a.setNotes(req.notes());
        a.setCreatedAt(Instant.now());
        return ActivityResponse.from(repository.save(a));
    }

    public ActivityResponse getById(String id) {
        return repository.findById(id)
                .map(ActivityResponse::from)
                .orElseThrow(() -> new ActivityNotFoundException(id));
    }

    public List<ActivityResponse> listMine() {
        return repository.findByUserIdOrderByStartTimeDesc(DEMO_USER)
                .stream().map(ActivityResponse::from).toList();
    }
}