package com.trainibit.tzdriver_managment.service.impl;

import com.trainibit.tzdriver_managment.entity.Managment;
import com.trainibit.tzdriver_managment.mapper.ManagmentMapper;
import com.trainibit.tzdriver_managment.repository.ManagmentRepository;
import com.trainibit.tzdriver_managment.request.ManagmentRequest;
import com.trainibit.tzdriver_managment.response.ManagmentResponse;
import com.trainibit.tzdriver_managment.service.ManagmentService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
@ComponentScan
@Service
public class ManagmentServiceImpl implements ManagmentService {
//inyeccciòn del mapeo
    @Autowired
    private ManagmentRepository managmentRepository;
@Autowired
private ManagmentMapper managmentMapper;

//mandar a llamar el mapeo de la lista creda en el mapeo
    @Override
    public List<ManagmentResponse> findAll() {
        return managmentMapper.mapListEntityToListDto(managmentRepository.findAll());
    }
    @Override
    public ManagmentResponse findById(UUID uuid) {
        return managmentMapper.mapEntityToDto(managmentRepository.findByUuid(uuid).
                orElseThrow(EntityNotFoundException::new));
    }
    @Override
    public Managment deleteById(Long id) {
        if (managmentRepository.existsById(id)) {
            managmentRepository.borrarByIdActive(id);
        } else {
            throw new EntityNotFoundException("Usuario con id" + id + " no encontrado");
        }
        return null;
    }

    @Override
    public Managment save(ManagmentRequest managmentRequest) {
        return null;
    }

    @Override
    public Managment update(Long id, ManagmentRequest managmentRequest) {
        return null;
    }


}

