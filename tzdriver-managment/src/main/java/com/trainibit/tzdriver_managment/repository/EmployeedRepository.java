package com.trainibit.tzdriver_managment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface EmployeedRepository /*extends JpaRepository<Employe, Long> */{
    /*
    Optional<Employee> findByEmailAddressAndPassword(String emailId, String password);
    Optional<Employee> findByEmailAddress(String emailId);
    Optional<Employee> findByUuid(UUID uuid);*/
}
