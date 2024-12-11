package com.trainibit.tzdriver_managment.repository;

import com.trainibit.tzdriver_managment.entity.Incidence;
import com.trainibit.tzdriver_managment.entity.IncidenceType;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.Optional;
import java.util.UUID;

@Repository

public interface IncidenceTypeRepository extends AuditableRepository2<IncidenceType, Long> {

    @Override
    default void borrarByIdActive(Long id) {
        IncidenceType entity = findById(id).orElseThrow(() -> new RuntimeException("Id not found"));
        entity.setActive(false);
        save(entity);
    }

    Optional<IncidenceType> findByUuid(UUID uuid);


    @Override
    default IncidenceType actualizarInci(IncidenceType entity){
        entity.setUpdated(new Timestamp(System.currentTimeMillis()));
        return save(entity);
    }
}

