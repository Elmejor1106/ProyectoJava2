package com.gestexpo.gestexpo.controlador;

import com.gestexpo.gestexpo.entidades.Stand;
import com.gestexpo.gestexpo.repository.StandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/stands")
public class StandController {

    @Autowired
    private StandRepository standRepository;

    @GetMapping
    public String listarStands(Model model) {
        List<Stand> stands = standRepository.findAll();
        model.addAttribute("stands", stands);
        return "organizador/stands";
    }

    @GetMapping("/nuevo")
    public String mostrarFormularioNuevo(Model model) {
        model.addAttribute("stand", new Stand());
        return "organizador/nuevoStand";
    }

    @PostMapping("/guardar")
    public String guardarStand(@ModelAttribute Stand stand) {
        standRepository.save(stand);
        return "redirect:/stands";
    }

    @GetMapping("/editar/{id}")
    public String editarStand(@PathVariable Long id, Model model) {
        Stand stand = standRepository.findById(id).orElse(null);
        model.addAttribute("stand", stand);
        return "organizador/nuevoStand";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarStand(@PathVariable Long id) {
        standRepository.deleteById(id);
        return "redirect:/stands";
    }
}