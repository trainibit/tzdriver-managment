package com.trainibit.tzdriver_managment.entity;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;
import org.hibernate.annotations.ColumnDefault;

import java.sql.Timestamp;

@MappedSuperclass
    @Data
    public class AuditableRecord {



    @Column(name = "created", nullable = false, insertable = false, updatable = false)
    private Timestamp created;

    @Column(name = "updated", nullable = false, insertable = false)
    private Timestamp updated;

    @ColumnDefault("true")
    @Column(name = "active", nullable = false, insertable = false)
    private Boolean active;
    }

