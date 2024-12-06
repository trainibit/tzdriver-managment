package com.trainibit.tzdriver_managment.entity;

import com.trainibit.tzdriver_managment.response.IncidenceResponse;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "incidences")
public class Incidence extends IncidenceResponse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "incidence_date", nullable = false)
    private LocalDate incidendeDate;

    @Column(name = "uuid")
    private UUID uuid;

    @ManyToOne(fetch = FetchType.LAZY)
    //columna relacionada en la base de datos
    @JoinColumn(name = "incidence_type_id")
    private IncidenceType incidenceType;



}