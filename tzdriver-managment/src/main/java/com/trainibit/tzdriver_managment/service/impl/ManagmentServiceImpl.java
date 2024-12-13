package com.trainibit.tzdriver_managment.service.impl;

import com.trainibit.tzdriver_managment.entity.Incidence;
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
    public ManagmentResponse deleteById(Long id) {
        if (managmentRepository.existsById(id)) {
            managmentRepository.borrarByIdActive(id);
        } else {
            throw new EntityNotFoundException("Manager con id" + id + " no encontrado");
        }
        return null;
    }

    @Override
    public ManagmentResponse save(ManagmentRequest managmentRequest) {
        //Objeto request a entidad
        Managment managment = managmentMapper.requestToEntity(managmentRequest);
        managment.setUuid(UUID.randomUUID());
        //Objeto entidad a objeto reponse
        // 3. Mapea la entidad Incidence guardada a un IncidenceResponse
        return managmentMapper.mapEntityToDto(managmentRepository.save(managment));
    }

    @Override
    public ManagmentResponse update(Long id, ManagmentRequest managmentRequest) {
        //bUscar la entidad
        Managment managment = managmentRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        //setear todas sus campos
        managment.setName(managmentRequest.getName());
        managment.setLastname(managmentRequest.getLastname());
        managment.setEmail(managmentRequest.getEmail());
        managment.setPassword(managmentRequest.getPassword());
        managment.setUser(managmentRequest.getUser());
        managment.setPhone(managmentRequest.getPhone());

//guaradar los cambios como un entidad y regresa el reponse
        return managmentMapper.mapEntityToDto(managmentRepository.save(managment));
    }


}

