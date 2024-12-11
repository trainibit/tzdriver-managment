package com.trainibit.tzdriver_managment.service;

import com.trainibit.tzdriver_managment.request.ManagmentRequest;
import com.trainibit.tzdriver_managment.response.ManagmentResponse;

import java.util.List;
import java.util.UUID;

public interface ManagmentService {
    List<ManagmentResponse> findAll();
    ManagmentResponse findById(UUID id);
    ManagmentResponse save(ManagmentRequest managmentRequest);
    ManagmentResponse update(Long id, ManagmentRequest managmentRequest);
    ManagmentResponse deleteById(Long id);
}
