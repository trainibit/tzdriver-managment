package com.trainibit.tzdriver_managment.request;

import com.trainibit.tzdriver_managment.entity.IncidenceType;
import lombok.Data;

import java.time.LocalDate;

@Data
public class IncidenceRequest {
    private String nameIncidence;
    private LocalDate incidenceDateStart;
    private LocalDate incidenceDateFinish;
    private IncidenceType incidenceType;
}
