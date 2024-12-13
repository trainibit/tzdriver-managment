package com.trainibit.tzdriver_managment.service.impl;

import com.trainibit.tzdriver_managment.entity.AuditableRecord;
import com.trainibit.tzdriver_managment.entity.Incidence;
import com.trainibit.tzdriver_managment.entity.IncidenceType;
import com.trainibit.tzdriver_managment.mapper.IncidenceMapper;
import com.trainibit.tzdriver_managment.repository.IncidenceRepository;
import com.trainibit.tzdriver_managment.repository.IncidenceTypeRepository;
import com.trainibit.tzdriver_managment.request.IncidenceRequest;
import com.trainibit.tzdriver_managment.response.IncidenceResponse;
import com.trainibit.tzdriver_managment.service.IncidenceService;
import jakarta.persistence.Column;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.UUID;

@ComponentScan
@Service
public class IncidenceServiceImpl implements IncidenceService {
    @Autowired
    private IncidenceMapper incidenceMapper;
    @Autowired
    private IncidenceRepository incidenceRepository;
    @Autowired
    private IncidenceTypeRepository incidenceTypeRepository;
    @Autowired
    private RestTemplate restTemplate;

    //Servicio implementado busqueda de todos los registros
    @Override  //Salida de objeto incide response en lista     //nombreado del metodo
    public List<IncidenceResponse> findAll() {
        //parece ser una interfaz que extiende de JpaRepository o CrudRepository, ambos de Spring Data,
        // que proporcionan métodos automáticos para interactuar con la base de datos.
        //Este es un metodo proporcionado por Spring Data que se usa
        // para obtener todos los registros de una entidad en la base de datos
        return incidenceMapper.mapListEntityToListDto(incidenceRepository.findAll());
        //realizar la conversión entre entidades de la base de datos y objetos DTO
        //maplistEntityToDto Su propósito es transformar una lista de entidades (List<Incidence>)
        // en una lista de objetos de tipo DTO (List<IncidenceResponse>).
    }//Entrada: La entrada para este metodo es la lista de entidades Incidence que se
    // obtiene de la base de datos con findAll().

    //Salida: La salida es una lista de objetos IncidenceResponse, que son
    //los objetos que se devolverán al cliente (probablemente a través de una API REST).

    @Override
    public IncidenceResponse save(IncidenceRequest incidenceRequest) {
        //Objeto request a entidad
        Incidence incidence = incidenceMapper.mapRequestToEntity(incidenceRequest);
        incidence.setUuid(UUID.randomUUID());
        IncidenceType incidenceType = incidenceTypeRepository.findByUuid(incidenceRequest.getIncidenceTypeUuid()).orElseThrow(EntityNotFoundException::new);
        incidence.setIncidenceType(incidenceType);
        //Objeto entidad a objeto reponse
        // 3. Mapea la entidad Incidence guardada a un IncidenceResponse
        return incidenceMapper.mapEntityToResponse(incidenceRepository.save(incidence));
    }

    @Override
    public IncidenceResponse update(Long id, IncidenceRequest incidenceRequest) {
        //bUscar la entidad
        Incidence incidence = incidenceRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        //setear todas sus campos
        incidence.setIncidenceType(incidence.getIncidenceType());
        incidence.setIncidenceDateStart(incidence.getIncidenceDateStart());
        incidence.setIncidenceDateFinish(incidence.getIncidenceDateFinish());
//guaradar los cambios como un entidad y regresa el reponse
        return incidenceMapper.mapEntityToResponse(incidenceRepository.save(incidence));
    }



    @Override
    public IncidenceResponse findById(UUID uuid) {
        return incidenceMapper.mapEntityToResponse(incidenceRepository.findByUuid(uuid).
                orElseThrow(EntityNotFoundException::new));
    }

    @Override
    public IncidenceResponse deleteById(Long id) {
        if (incidenceRepository.existsById(id)) {
            incidenceRepository.borrarByIdActive(id);
        } else {
            throw new EntityNotFoundException("Incidencia con id" + id + " no encontrado");
        }
        return null;
    }


    public List<Incidence> getActiveIncidences() {
        return incidenceRepository.findActiveIncidences();
    }
}



