package com.trainibit.tzdriver_managment.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "incidences")
public class Incidence {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "fecha_inci", nullable = false)
    private LocalDate fechaInci;

    @Column(name = "uuid")
    private UUID uuid;

    @ManyToOne(fetch = FetchType.LAZY)
    //columna relacionada en la base de datos
    @JoinColumn(name = "incidence_type_id")
    private IncidendeType incidenceType;

    @Column(name = "created", nullable = false)
    private Instant created;

}