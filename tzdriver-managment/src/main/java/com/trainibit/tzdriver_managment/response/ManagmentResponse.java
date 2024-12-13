package com.trainibit.tzdriver_managment.response;

import lombok.Data;

import java.util.UUID;
@Data
public class ManagmentResponse {
    private String name;
    private String lastname;
    private String email;
    private String phone;
    private UUID uuid;
    private String password;
    private String username;
}
