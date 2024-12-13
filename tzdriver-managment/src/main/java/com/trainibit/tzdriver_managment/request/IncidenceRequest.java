package com.trainibit.tzdriver_managment.request;

import lombok.Data;
import java.time.LocalDate;
import java.util.UUID;

@Data
public class IncidenceRequest {
    private LocalDate incidenceDateStart;
    private LocalDate incidenceDateFinish;
    private UUID incidenceTypeUuid;
    private UUID driverUuid;
}
