package com.trainibit.tzdriver_managment.service.impl;

import com.trainibit.tzdriver_managment.entity.Incidence;
import com.trainibit.tzdriver_managment.mapper.IncidenceMapper;
import com.trainibit.tzdriver_managment.repository.IncidenceRepository;
import com.trainibit.tzdriver_managment.request.IncidenceRequest;
import com.trainibit.tzdriver_managment.response.IncidenceResponse;
import com.trainibit.tzdriver_managment.service.IncidenceService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@ComponentScan
@Service
public class IncidenceServiceImpl implements IncidenceService {
@Autowired
    private IncidenceMapper incidenceMapper;
@Autowired
private IncidenceRepository incidenceRepository;

    //Servicio implementado busqueda de todos los registros
    @Override
    public List<IncidenceResponse> findAll() {
        return incidenceMapper.mapListEntityToListDto(incidenceRepository.findAll());
    }

    @Override
    public IncidenceResponse save(IncidenceRequest incidenceRequest) {
        //Objeto request a entidad
        Incidence incidence = incidenceMapper.mapRequestToEntity(incidenceRequest);
        //Objeto entidad a objeto reponse
        // 3. Mapea la entidad Incidence guardada a un IncidenceResponse
        return incidenceMapper.mapEntityToResponse(incidenceRepository.save(incidence));
    }
    /*  public Usuario save(UsuarioRequest usuarioRequest) {
        // Crear una nueva instancia de Usuario desde usuarioRequest
        Usuario usuario = UsuarioMapper2.mapRequestToEntity(usuarioRequest);
        usuario.setNombrePlaneta(obtenerNombrePlanetaAleatorio());
        return usuarioRepository.save(usuario);*/

    @Override
    public IncidenceResponse update(Long id, IncidenceRequest incidenceRequest) {
        //bUscar la entidad
 Incidence incidence = incidenceRepository.findById(id).orElseThrow(EntityNotFoundException::new);
 //stetear todas sus campos
 incidence.setIncidenceType(incidence.getIncidenceType());
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
            throw new EntityNotFoundException("Usuario con id" + id + " no encontrado");
        }
        return null;
    }

}



