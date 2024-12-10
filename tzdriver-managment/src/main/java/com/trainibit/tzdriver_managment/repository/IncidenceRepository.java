package com.trainibit.tzdriver_managment.repository;

import com.trainibit.tzdriver_managment.entity.Incidence;
import com.trainibit.tzdriver_managment.entity.Managment;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.Optional;
import java.util.UUID;

@Repository

public interface IncidenceRepository extends AuditableRepository2<Incidence, Long> {

    @Override
    default void borrarByIdActiveInci(Long id) {
        Incidence entity = findById(id).orElseThrow(() -> new RuntimeException("Id not found"));
        entity.setActive(false);
        save(entity);
    }
    Optional<Incidence> findByUuid(UUID uuid);


    @Override
    default Incidence actualizarInci(Incidence entity){
        entity.setUpdated(new Timestamp(System.currentTimeMillis()));
        return save(entity);
    }
    }

