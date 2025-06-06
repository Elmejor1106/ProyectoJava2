package com.gestexpo.gestexpo.repository;

import com.gestexpo.gestexpo.entidades.Stand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StandRepository extends JpaRepository<Stand, Long> {
}