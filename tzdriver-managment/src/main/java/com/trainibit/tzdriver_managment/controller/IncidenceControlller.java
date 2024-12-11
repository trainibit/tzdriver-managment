package com.trainibit.tzdriver_managment.controller;

import com.trainibit.tzdriver_managment.entity.Incidence;
import com.trainibit.tzdriver_managment.request.IncidenceRequest;
import com.trainibit.tzdriver_managment.request.ManagmentRequest;
import com.trainibit.tzdriver_managment.response.IncidenceResponse;
import com.trainibit.tzdriver_managment.response.ManagmentResponse;

import com.trainibit.tzdriver_managment.service.IncidenceService;
import com.trainibit.tzdriver_managment.service.ManagmentService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;

import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@ComponentScan
@Validated
@RestController
@RequestMapping("/incidences")



public class IncidenceControlller {


    @Autowired
    private IncidenceService incidenceService;

//CRUDE DE INCIDENCIAS


    @GetMapping
    public ResponseEntity<List<IncidenceResponse>> getIncidences() {
        return ResponseEntity.ok(incidenceService.findAll());
    }

    @PostMapping
    public ResponseEntity<IncidenceResponse> createIncidence(@Validated @RequestBody IncidenceRequest incidenceRequest) {
        IncidenceResponse incidenceNew = incidenceService.save(incidenceRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(incidenceNew);
    }

    @PutMapping("/{id}")
    public ResponseEntity<IncidenceResponse> updateIncidence(@PathVariable Long id, @RequestBody IncidenceRequest incidenceRequest) {
        try {
            IncidenceResponse incidenceUpdate = incidenceService.update(id, incidenceRequest);
            return ResponseEntity.ok(incidenceUpdate);

        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

    }
    @DeleteMapping("/{id}")

    public ResponseEntity<IncidenceResponse> deleteIncidence(@PathVariable Long id) {
        IncidenceResponse incidenceDelete = incidenceService.deleteById(id);
        return ResponseEntity.ok(incidenceDelete);
    }

    @GetMapping("{uuid}")
    public ResponseEntity<IncidenceResponse> getIncidenceById(@PathVariable UUID uuid) {
        return ResponseEntity.ok(incidenceService.findById(uuid));
    }

    @GetMapping("/active")
    public List<Incidence> getActiveIncidences() {
        return incidenceService.getActiveIncidences();
    }
}
