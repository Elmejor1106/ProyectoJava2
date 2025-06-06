package com.gestexpo.gestexpo.entidades;
import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;


@Entity
public class Cronograma {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String actividad; // <-- AGREGA ESTE CAMPO

    private LocalDate fecha;
    private LocalTime hora; // <-- CAMBIA ESTO SI PREFIERES SOLO UNA HORA

    @ManyToOne
    private Evento evento;

    // Getters y setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getActividad() { return actividad; }
    public void setActividad(String actividad) { this.actividad = actividad; }

    public LocalDate getFecha() { return fecha; }
    public void setFecha(LocalDate fecha) { this.fecha = fecha; }

    public LocalTime getHora() { return hora; }
    public void setHora(LocalTime hora) { this.hora = hora; }

    public Evento getEvento() { return evento; }
    public void setEvento(Evento evento) { this.evento = evento; }
}
