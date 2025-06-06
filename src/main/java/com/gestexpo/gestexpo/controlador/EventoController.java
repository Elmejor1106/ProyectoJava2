package com.gestexpo.gestexpo.controlador;

import com.gestexpo.gestexpo.entidades.Evento;
import com.gestexpo.gestexpo.repository.EventoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/eventos")
public class EventoController {

    @Autowired
    private EventoRepository eventoRepository;

    @GetMapping
    public String listarEventos(Model model) {
        model.addAttribute("eventos", eventoRepository.findAll());
        return "evento/lista";
    }

    @GetMapping("/nuevo")
    public String nuevoEvento(Model model) {
        model.addAttribute("evento", new Evento());
        return "evento/form";
    }

    @PostMapping("/guardar")
    public String guardarEvento(@ModelAttribute Evento evento) {
        eventoRepository.save(evento);
        return "redirect:/eventos";
    }

    @GetMapping("/editar/{id}")
    public String editarEvento(@PathVariable Long id, Model model) {
        model.addAttribute("evento", eventoRepository.findById(id).orElse(null));
        return "evento/form";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarEvento(@PathVariable Long id) {
        eventoRepository.deleteById(id);
        return "redirect:/eventos";
    }
}