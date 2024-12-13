package com.trainibit.tzdriver_managment.response;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.UUID;
//Creación del constructor
@Getter
@Setter

public class DriverResponse implements Serializable {
    private String name;
    private String phoneNumber;
    private Float averageReview;

    private Long idState;
    private Long idVehicle;
    private UUID uuid;
}
