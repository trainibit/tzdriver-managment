package com.trainibit.tzdriver_managment.mapper;

import com.trainibit.tzdriver_managment.entity.Managment;
import com.trainibit.tzdriver_managment.request.ManagmentRequest;
import com.trainibit.tzdriver_managment.response.ManagmentResponse;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ManagmentMapper2 {
    /*public static ManagmentResponse mapEntityToDto(Managment managment) {

        ManagmentResponse managmentResponse = new ManagmentResponse();
        managmentResponse.setUuid(managment.getUuid());
        managmentResponse.setName(managment.getName());
        managmentResponse.setEmail(managment.getEmail());
        managmentResponse.setUsername(managment.getUser());
        managmentResponse.setPassword(managment.getPassword());
        managmentResponse.setPhone(managment.getPhone());
        return managmentResponse;
    }
    public static List<ManagmentResponse> mapListEntitytoListDto(List<Managment> manager) {
        List<ManagmentResponse> managmentResponses = new ArrayList<>();
        for (Managment managment : manager) {
            managmentResponses.add(mapEntityToDto(managment));
        }
        return managmentResponses;

    }
    public static Managment mapRequestToEntity(ManagmentRequest managmentRequest) {
        // Crear una nueva instancia de Usuario
        Managment managment = new Managment();

        // Mapear los datos de UsuarioRequest a Usuario
        managment.setPhone(managmentRequest.getPhone());
        managment.setName(managment.getName());
        managment.setLastName(managmentRequest.getLast_name());
        managment.setEmail(managment.getEmail());
        managment.setPassword(managment.getPassword());
        managment.setUuid(UUID.randomUUID()); // Asignar un UUID aleatorio
        //usuario.setNombrePlaneta(usuarioRequest.getNombreDePlaneta()); // Usar el nombre de planeta del request

        // Retornar el usuario mapeado
        return managment;
    }*/
}
