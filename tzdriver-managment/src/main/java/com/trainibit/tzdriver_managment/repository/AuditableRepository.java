package com.trainibit.tzdriver_managment.repository;

import jakarta.persistence.Id;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuditableRepository<T, Id> extends JpaRepository<T, Id> {
    void borrarByIdActive(Id id);

    T actualizarAudit(T entity);

}
