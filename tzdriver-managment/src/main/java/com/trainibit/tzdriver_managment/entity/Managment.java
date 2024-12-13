package com.trainibit.tzdriver_managment.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.sql.Timestamp;
import java.util.UUID;

@Data
@Getter
@Setter
@Entity
@Table(name = "manager")
public class Managment extends AuditableRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false, length = Integer.MAX_VALUE)
    private String name;

    @Column(name = "last_name", nullable = false, length = Integer.MAX_VALUE)
    private String lastname;

    @Column(name = "phone", nullable = false, length = 10)
    private String phone;

    @Column(name = "email", nullable = false, length = Integer.MAX_VALUE)
    private String email;

    @Column(name = "uuid", nullable = false)
    private UUID uuid;

    @Column(name = "password", nullable = false,length = Integer.MAX_VALUE)
    private String password;

    @Column (name = "user", nullable = false, length = Integer.MAX_VALUE)
    private String user;




}