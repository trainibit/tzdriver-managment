package com.trainibit.tzdriver_managment.controller;

import com.trainibit.tzdriver_managment.entity.Incidence;
import com.trainibit.tzdriver_managment.entity.Managment;
import com.trainibit.tzdriver_managment.request.IncidenceRequest;
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

import java.util.List;
import java.util.UUID;

@ComponentScan
@Validated
@RestController
@RequestMapping("/managment")
public class ManagmentController {
    @Autowired
    private ManagmentService managmentService;
    @Autowired
    private IncidenceService incidenceService;


    @GetMapping
    public ResponseEntity<List<IncidenceResponse>> getAllIncidences() {
        return ResponseEntity.ok(incidenceService.findAll());
    }
    @GetMapping
    public ResponseEntity<List<ManagmentResponse>> getAll() {
        return ResponseEntity.ok(managmentService.findAll());
    }

    @GetMapping("{id}") //Permite realizar la busqueda por ID
    public ManagmentResponse obtenerManagmentPorId(@PathVariable UUID id) {
        return managmentService.findById(id);
    }
    @GetMapping("{id}") //Permite realizar la busqueda por ID
    public IncidenceResponse obtenerIncidencePorId(@PathVariable UUID id) {
        return incidenceService.findById(id);
    }

    @PostMapping
    public ResponseEntity<IncidenceResponse> createIncidence(@Validated @RequestBody IncidenceRequest incidenceRequest) {
        IncidenceResponse nuevaIncidencia = incidenceService.save(incidenceRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevaIncidencia);
    }

    @PutMapping("/{id}")
    public ResponseEntity<IncidenceResponse> updateUsuario(@PathVariable Long id, @RequestBody IncidenceRequest incidenceRequest) {
        try {
            IncidenceResponse incidenceActualizado = incidenceService.update(id,incidenceRequest);
            return ResponseEntity.ok(incidenceActualizado);

        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
}
@DeleteMapping("/{id}")
    public ResponseEntity<IncidenceResponse> deleteIncidence(@PathVariable Long id) {
        IncidenceResponse incidenceBorrado = incidenceService.deleteById(id);
        return ResponseEntity.ok(incidenceBorrado);
}
}
