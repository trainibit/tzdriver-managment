package com.trainibit.tzdriver_managment.controller;

import com.trainibit.tzdriver_managment.entity.Managment;
import com.trainibit.tzdriver_managment.response.ManagmentResponse;
import com.trainibit.tzdriver_managment.service.ManagmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@ComponentScan
@Validated
@RestController
@RequestMapping("/managment")
public class ManagmentController {
    @Autowired
    private ManagmentService managmentService;



    @GetMapping
    public ResponseEntity<List<ManagmentResponse>> getAll() {
        return ResponseEntity.ok(managmentService.findAll());
    }

    @GetMapping("{id}") //Permite realizar la busqueda por ID
    public ManagmentResponse obtenerManagmentPorId(@PathVariable UUID id) {
        return managmentService.findById(id);
    }
}
