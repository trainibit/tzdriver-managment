package com.trainibit.tzdriver_managment.service;

import com.trainibit.tzdriver_managment.entity.Manager;
import com.trainibit.tzdriver_managment.request.ManagerRequest;
import com.trainibit.tzdriver_managment.response.ManagerResponse;

import java.util.List;
import java.util.UUID;

public interface ManagmentService {
    List<ManagerResponse> findAll();
    Manager findById(UUID id);
    Manager save(ManagerRequest managerRequest);
    Manager update(Long id, ManagerRequest managerRequest);
    Manager deleteById(Long id);
}
