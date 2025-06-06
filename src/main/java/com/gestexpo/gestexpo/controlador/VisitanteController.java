package com.gestexpo.gestexpo.controlador;

import com.gestexpo.gestexpo.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class VisitanteController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping("/visitante/panelVisitante")
    public String panelVisitante() {
        return "visitante/panelVisitante";
    }

    @GetMapping("/visitante/visitantes")
    public String listarVisitantes(Model model) {
        model.addAttribute("visitantes", usuarioRepository.findByRol("Visitante"));
        return "visitante/visitante";
    }
}