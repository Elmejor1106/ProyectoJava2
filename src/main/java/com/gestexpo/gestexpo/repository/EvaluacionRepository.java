package com.gestexpo.gestexpo.repository;

import com.gestexpo.gestexpo.entidades.Evaluacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EvaluacionRepository extends JpaRepository<Evaluacion, Long> {
}