package com.gestexpo.gestexpo.controlador;

import com.gestexpo.gestexpo.entidades.Participacion;
import com.gestexpo.gestexpo.repository.ParticipacionRepository;
import com.gestexpo.gestexpo.repository.UsuarioRepository;
import com.gestexpo.gestexpo.repository.EventoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/visitante/inscripcion")
public class ParticipacionController {

    @Autowired
    private ParticipacionRepository participacionRepository;
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private EventoRepository eventoRepository;

    @GetMapping
    public String mostrarFormulario(Model model) {
        model.addAttribute("participacion", new Participacion());
        model.addAttribute("usuarios", usuarioRepository.findAll()); // O solo los de rol Visitante
        model.addAttribute("eventos", eventoRepository.findAll());
        return "visitante/inscripcion";
    }

    @PostMapping("/guardar")
    public String guardarParticipacion(@ModelAttribute Participacion participacion) {
        participacion.setTipoParticipacion("Visitante");
        participacionRepository.save(participacion);
        return "redirect:/visitante/visitantes";
    }
    
    
     }

    