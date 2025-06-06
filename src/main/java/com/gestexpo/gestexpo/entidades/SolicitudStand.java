package com.gestexpo.gestexpo.entidades;

import jakarta.persistence.*;

@Entity
public class SolicitudStand {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String descripcion;

    @ManyToOne
    private Usuario expositor;

    @ManyToOne
    private Stand stand;

    // Getters y setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public Usuario getExpositor() { return expositor; }
    public void setExpositor(Usuario expositor) { this.expositor = expositor; }

    public Stand getStand() { return stand; }
    public void setStand(Stand stand) { this.stand = stand; }
}