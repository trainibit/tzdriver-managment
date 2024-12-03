package com.trainibit.tzdriver_managment.service;

import com.trainibit.tzdriver_managment.entity.Manager;
import com.trainibit.tzdriver_managment.response.ManagmentResponse;

import java.util.List;
import java.util.UUID;

public interface ManagmentService {
    List<ManagmentResponse> findAll();
    Manager findById(UUID id);
    Manager save(UsuarioRequest usuarioRequest);
    Manager update(Long id, UsuarioRequest usuarioRequest);
    Manager deleteById(Long id);
}
