package com.trainibit.tzdriver_managment.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;


import java.sql.Timestamp;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "incidence_types")


public class IncidenceType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false, length = Integer.MAX_VALUE)
    private String name;

    @Column(name = "uuid", nullable = false)
    private UUID uuid;


    @Column(name = "created", nullable = false, insertable = false, updatable = false)
    private Timestamp created;

    @Column(name = "updated", nullable = false, insertable = false)
    private Timestamp updated;

    @ColumnDefault("true")
    @Column(name = "active", nullable = false, insertable = false)
    private Boolean active;

}