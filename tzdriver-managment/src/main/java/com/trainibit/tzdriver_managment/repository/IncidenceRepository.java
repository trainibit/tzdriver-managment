package com.trainibit.tzdriver_managment.repository;

import com.trainibit.tzdriver_managment.entity.Incidence;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository

public interface IncidenceRepository extends AuditableRepository2<Incidence, Long> {

    @Override
    default void borrarByIdActive(Long id) {
        Incidence entity = findById(id).orElseThrow(() -> new RuntimeException("Id not found"));
        entity.setActive(false);
        save(entity);
    }

    Optional<Incidence> findByUuid(UUID uuid);


    @Override
    default Incidence actualizarInci(Incidence entity) {
        entity.setUpdated(new Timestamp(System.currentTimeMillis()));
        return save(entity);
    }

    @Query("SELECT i FROM Incidence i WHERE i.incidenceDateFinish >= CURRENT_DATE")
    List<Incidence> findActiveIncidences();
}




//@Column(name = "incidence_date_start", nullable = false)
//    private LocalDate incidenceDateStart;
//
//    @Column(name = "incidence_date_finish", nullable = false)
//    private LocalDate incidenceDateFinish;

