package com.trainibit.tzdriver_managment.service;

import com.trainibit.tzdriver_managment.request.IncidenceRequest;
import com.trainibit.tzdriver_managment.response.IncidenceResponse;

import java.util.List;
import java.util.UUID;

//Servicios que ofrece la tabla de incidencias
public interface IncidenceService {
    List<IncidenceResponse> findAll();
    IncidenceResponse save(IncidenceRequest incidenceRequest);
    IncidenceResponse update(Long id, IncidenceRequest incidenceRequest);
    IncidenceResponse findById(UUID uuid);
    IncidenceResponse deleteById(Long id);
}
