package com.trainibit.tzdriver_managment.repository;

import com.trainibit.tzdriver_managment.entity.Managment;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.Optional;
import java.util.UUID;

@Repository

    public interface ManagmentRepository extends AuditableRepository<Managment, Long> {

    Optional<Managment> findByUuid(UUID uuid);

}
