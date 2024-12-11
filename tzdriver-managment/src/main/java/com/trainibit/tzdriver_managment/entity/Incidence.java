package com.trainibit.tzdriver_managment.entity;

import com.trainibit.tzdriver_managment.response.IncidenceResponse;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;
import java.sql.Timestamp;
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

    @Column(name = "uuid")
    private UUID uuid;

    @Column(name = "incidence_date_start", nullable = false)
    private LocalDate incidenceDateStart;

    @Column(name = "incidence_date_finish", nullable = false)
    private LocalDate incidenceDateFinish;
    //Notaciopn para el guardado en cascada @OneToOne(cascade = CascadeType.ALL)
    @ManyToOne//(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    //columna relacionada en la base de datos
    @JoinColumn(name = "incidence_type_id")
    private IncidenceType incidenceType;


    @Column (name= "driver_uuid", nullable = false)
    private UUID driverUuid;


    @Column(name = "created", nullable = false, insertable = false, updatable = false)
    private Timestamp created;

    @Column(name = "updated", nullable = false, insertable = false)
    private Timestamp updated;

    @ColumnDefault("true")
    @Column(name = "active", nullable = false, insertable = false)
    private Boolean active;



}