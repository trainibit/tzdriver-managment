package com.trainibit.tzdriver_managment.mapper;
import com.trainibit.tzdriver_managment.entity.Managment;
import com.trainibit.tzdriver_managment.request.ManagmentRequest;
import com.trainibit.tzdriver_managment.response.ManagmentResponse;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel ="spring")
public interface ManagmentMapper {
    ManagmentResponse mapEntityToDto(Managment managment);
    Managment requestToEntity(ManagmentRequest managmentRequest);
    List<ManagmentResponse> mapListEntityToListDto(List<Managment> managmentList);

}




