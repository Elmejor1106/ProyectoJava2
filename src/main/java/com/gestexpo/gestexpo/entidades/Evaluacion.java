package com.gestexpo.gestexpo.entidades;

import jakarta.persistence.*;

@Entity
public class Evaluacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "evaluador_id")
    private Usuario evaluador;

    @ManyToOne
    @JoinColumn(name = "stand_id")
    private Stand stand;

    private Double nota;

    // Getters y setters
    // ...
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public Usuario getEvaluador() {
        return evaluador;
    }
    public void setEvaluador(Usuario evaluador) {
        this.evaluador = evaluador;
    }
    public Stand getStand() {
        return stand;
    }
    public void setStand(Stand stand) {
        this.stand = stand;
    }
    public Double getNota() {
        return nota;
    }
    public void setNota(Double nota) {
        this.nota = nota;
    }
    
    }
