package com.trainibit.tzdriver_managment.response;

import com.trainibit.tzdriver_managment.entity.IncidenceType;
import lombok.Data;

import java.time.LocalDate;
import java.util.UUID;

@Data
public class IncidenceResponse {
    private LocalDate incidenceDateStart;
    private LocalDate incidenceDateFinish;
    private IncidenceType incidenceType;
    private UUID uuid;
    private UUID driverUuid;

}
