package com.lifetrack.activity.controller;

import com.lifetrack.activity.dto.ActivityResponse;
import com.lifetrack.activity.dto.CreateActivityRequest;
import com.lifetrack.activity.service.ActivityService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/v1/activities")
@RequiredArgsConstructor
public class ActivityController {

    private final ActivityService service;

    @PostMapping
    public ResponseEntity<ActivityResponse> create(@Valid @RequestBody CreateActivityRequest req) {
        ActivityResponse created = service.create(req);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(created.id()).toUri();
        return ResponseEntity.created(location).body(created);   // 201 + Location header
    }

    @GetMapping("/{id}")
    public ActivityResponse getById(@PathVariable String id) {
        return service.getById(id);
    }

    @GetMapping
    public List<ActivityResponse> listMine() {
        return service.listMine();
    }
}