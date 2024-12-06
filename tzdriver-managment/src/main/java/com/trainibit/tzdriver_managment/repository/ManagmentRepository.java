package com.trainibit.tzdriver_managment.repository;

import com.trainibit.tzdriver_managment.entity.Managment;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.Optional;
import java.util.UUID;

@Repository

    public interface ManagmentRepository extends AuditableRepository<Managment, Long> {
    @Override
    default void borrarByIdActive(Long id) {
        Managment entity = findById(id).orElseThrow(() -> new RuntimeException("Id not found"));
        entity.setActive(false);
        save(entity);
    }
    Optional<Managment> findByUuid(UUID uuid);

    @Override
    default Managment actualizarAudit(Managment entity){
        entity.setUpdatedat(new Timestamp(System.currentTimeMillis()));
        return save(entity);
    }

}
