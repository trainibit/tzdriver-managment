package com.trainibit.tzdriver_managment.service;

import com.trainibit.tzdriver_managment.request.IncidenceTypeRequest;
import com.trainibit.tzdriver_managment.response.IncidenceTypeResponse;

import java.util.List;
import java.util.UUID;

public interface IncidenceTypeService {
    List<IncidenceTypeResponse> findAll();
    IncidenceTypeResponse save(IncidenceTypeRequest incidenceTypeRequest);
    IncidenceTypeResponse update(Long id, IncidenceTypeRequest incidenceTypeRequest);
    IncidenceTypeResponse findById(UUID uuid);
}
