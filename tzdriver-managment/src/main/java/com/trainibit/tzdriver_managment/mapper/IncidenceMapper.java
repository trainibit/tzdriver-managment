package com.trainibit.tzdriver_managment.mapper;

import com.trainibit.tzdriver_managment.entity.Incidence;
import com.trainibit.tzdriver_managment.entity.IncidenceType;
import com.trainibit.tzdriver_managment.request.IncidenceRequest;
import com.trainibit.tzdriver_managment.response.IncidenceResponse;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel ="spring")
public interface IncidenceMapper {
    IncidenceResponse mapEntityToResponse(Incidence incidence);
    Incidence mapRequestToEntity(IncidenceRequest incidenceRequest);
    List<IncidenceResponse> mapListEntityToListDto(List<Incidence> incidenceList);


    }
