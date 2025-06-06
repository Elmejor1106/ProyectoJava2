package com.gestexpo.gestexpo.entidades;
import jakarta.persistence.*;

@Entity
public class Participacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "evento_id")
    private Evento evento;

    private String tipoParticipacion; // Ejemplo: "Visitante"

    // Getters y setters
    // ...
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }   
    public Usuario getUsuario() {
        return usuario;
    }   
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }


    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    public String getTipoParticipacion() {
        return tipoParticipacion;
    }

    public void setTipoParticipacion(String tipoParticipacion) {
        this.tipoParticipacion = tipoParticipacion;
    }
    
}
