package com.gestexpo.gestexpo.controlador;

import com.gestexpo.gestexpo.entidades.SolicitudStand;
import com.gestexpo.gestexpo.repository.SolicitudStandRepository;
import com.gestexpo.gestexpo.repository.StandRepository;
import com.gestexpo.gestexpo.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/expositor/solicitudes")
public class SolicitudStandController {

    @Autowired
    private SolicitudStandRepository solicitudStandRepository;
    @Autowired
    private StandRepository standRepository;
    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping
    public String listarSolicitudes(Model model) {
        model.addAttribute("solicitudes", solicitudStandRepository.findAll());
        return "expositor/solicitudStand";
    }

    @GetMapping("/nueva")
    public String nuevaSolicitud(Model model) {
        model.addAttribute("solicitud", new SolicitudStand());
        model.addAttribute("stands", standRepository.findAll());
        model.addAttribute("expositores", usuarioRepository.findAll()); // O solo los de rol expositor
        return "expositor/nuevaSolicitudStand";
    }

    @PostMapping("/guardar")
    public String guardarSolicitud(@ModelAttribute SolicitudStand solicitud) {
        solicitudStandRepository.save(solicitud);
        return "redirect:/expositor/solicitudes";
    }

    @GetMapping("/editar/{id}")
    public String editarSolicitud(@PathVariable Long id, Model model) {
        model.addAttribute("solicitud", solicitudStandRepository.findById(id).orElse(null));
        model.addAttribute("stands", standRepository.findAll());
        model.addAttribute("expositores", usuarioRepository.findAll());
        return "expositor/nuevaSolicitudStand";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarSolicitud(@PathVariable Long id) {
        solicitudStandRepository.deleteById(id);
        return "redirect:/expositor/solicitudes";
    }
}