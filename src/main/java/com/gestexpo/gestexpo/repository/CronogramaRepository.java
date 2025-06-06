package com.gestexpo.gestexpo.repository;

import com.gestexpo.gestexpo.entidades.Cronograma;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CronogramaRepository extends JpaRepository<Cronograma, Long> {
}