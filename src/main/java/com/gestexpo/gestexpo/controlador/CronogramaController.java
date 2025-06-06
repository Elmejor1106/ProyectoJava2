package com.gestexpo.gestexpo.controlador;

import com.gestexpo.gestexpo.entidades.Cronograma;
import com.gestexpo.gestexpo.repository.CronogramaRepository;
import com.gestexpo.gestexpo.repository.EventoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/cronograma")
public class CronogramaController {

    @Autowired
    private CronogramaRepository cronogramaRepository;
    @Autowired
    private EventoRepository eventoRepository;

    @GetMapping
    public String listarCronograma(Model model) {
        model.addAttribute("cronogramas", cronogramaRepository.findAll());
        return "organizador/cronograma";
    }

    @GetMapping("/nuevo")
    public String nuevoCronograma(Model model) {
        model.addAttribute("cronograma", new Cronograma());
        model.addAttribute("eventos", eventoRepository.findAll());
        return "organizador/cronogramaForm";
    }

    @PostMapping("/guardar")
    public String guardarCronograma(@ModelAttribute Cronograma cronograma) {
        cronogramaRepository.save(cronograma);
        return "redirect:/cronograma";
    }

    @GetMapping("/editar/{id}")
    public String editarCronograma(@PathVariable Long id, Model model) {
        model.addAttribute("cronograma", cronogramaRepository.findById(id).orElse(null));
        model.addAttribute("eventos", eventoRepository.findAll());
        return "organizador/cronogramaForm";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarCronograma(@PathVariable Long id) {
        cronogramaRepository.deleteById(id);
        return "redirect:/cronograma";
    }
}