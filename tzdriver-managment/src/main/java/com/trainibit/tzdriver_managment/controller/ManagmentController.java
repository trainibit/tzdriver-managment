package com.trainibit.tzdriver_managment.controller;

import com.trainibit.tzdriver_managment.entity.Incidence;
import com.trainibit.tzdriver_managment.entity.Managment;
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

import java.util.List;
import java.util.UUID;

@ComponentScan
@Validated
@RestController
@RequestMapping("/managment")
public class ManagmentController {


    @Autowired
    private ManagmentService managmentService;
//CRUDE DE INCIDENCIAS

    @GetMapping
    public ResponseEntity<List<ManagmentResponse>> getAllManager() {
        return ResponseEntity.ok(managmentService.findAll());
    }

    @PostMapping
    public ResponseEntity<ManagmentResponse> createManager(@Validated @RequestBody ManagmentRequest managmentRequest) {
        ManagmentResponse managerNuevo = managmentService.save(managmentRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(managerNuevo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ManagmentResponse> updateManager(@PathVariable Long id, @RequestBody ManagmentRequest managmentRequest) {
        try {
            ManagmentResponse managerActualizado = managmentService.update(id,managmentRequest);
            return ResponseEntity.ok(managerActualizado);

        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
}
@DeleteMapping("/{id}")
    public ResponseEntity<ManagmentResponse> deleteManager(@PathVariable Long id) {
        ManagmentResponse managerBorrado = managmentService.deleteById(id);
        return ResponseEntity.ok(managerBorrado);
}

}
