package com.gestexpo.gestexpo.controlador;

import com.gestexpo.gestexpo.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AdminController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping("/admin/usuarios")
    public String usuarios(Model model) {
        model.addAttribute("usuarios", usuarioRepository.findAll());
        return "admin/usuarios";
    }

    @GetMapping("/admin/panelAdmin")
    public String panelAdmin() {
        return "admin/panelAdmin";
    }

    @GetMapping("/admin/usuarios/nuevo")
    public String nuevoUsuario(Model model) {
        model.addAttribute("usuario", new com.gestexpo.gestexpo.entidades.Usuario());
        return "admin/nuevoUsuario";
    }

    @PostMapping("/admin/usuarios/guardar")
    public String guardarUsuario(@ModelAttribute("usuario") com.gestexpo.gestexpo.entidades.Usuario usuario) {
        usuarioRepository.save(usuario);
        return "redirect:/admin/usuarios";
    }
}