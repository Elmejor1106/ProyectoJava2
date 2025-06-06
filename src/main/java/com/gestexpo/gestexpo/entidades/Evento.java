package com.gestexpo.gestexpo.entidades;
import jakarta.persistence.*;

@Entity
public class Evento {
      @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String fechas;
    private String lugar;

    // Getters y setters
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getFechas() {
        return fechas;
    }
    public void setFechas(String fechas) {
        this.fechas = fechas;
    }

    public String getLugar() {
        return lugar;
    }
    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

}
