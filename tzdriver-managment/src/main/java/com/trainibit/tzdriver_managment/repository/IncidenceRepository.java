package com.trainibit.tzdriver_managment.repository;

import com.trainibit.tzdriver_managment.entity.Incidence;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository

public interface IncidenceRepository extends AuditableRepository2<Incidence, Long> {

    Optional<Incidence> findByUuid(UUID uuid);

    }

