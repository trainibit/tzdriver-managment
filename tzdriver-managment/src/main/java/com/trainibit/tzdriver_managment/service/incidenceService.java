package com.trainibit.tzdriver_managment.service;

import com.trainibit.tzdriver_managment.entity.Incidence;
import com.trainibit.tzdriver_managment.request.IncidenceRequest;
import com.trainibit.tzdriver_managment.response.IncidenceResponse;

import java.util.List;
import java.util.UUID;

//Servicios que ofrece la tabla de incidencias
public interface incidenceService {
    //Se llevarà a cabo la creaciòn de una lista con los datos de incidencia Response a travès
    //del metodo getIncidence
    List<IncidenceResponse> getIncidences();
//Tipo de dato que va a devolver (Incidence), Metodo find(buscar), paràmetro que el metodo recibe (UUID)
    Incidence findIncidenceById(UUID uuid);
    //Servicio para gusardar una incidencia
    Incidence saveIncidence(IncidenceRequest incidenceRequest);
    Incidence update(Long id, IncidenceRequest incidenceRequest);
    Incidence deleteById(Long id);
}
