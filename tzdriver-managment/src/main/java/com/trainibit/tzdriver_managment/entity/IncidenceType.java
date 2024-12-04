package com.trainibit.tzdriver_managment.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.util.*;

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

    @Column(name = "created", nullable = false)
    private Instant created;

    @Column(name = "updated", nullable = false)
    private Instant updated;

    @OneToMany(mappedBy = "incidenceType")
    private List<Incidence> incidences = new ArrayList<>();

}