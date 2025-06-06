package com.gestexpo.gestexpo.controlador;

import com.gestexpo.gestexpo.entidades.Usuario;
import com.gestexpo.gestexpo.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping("/registro")
    public String mostrarFormularioRegistro(Model model) {
        model.addAttribute("usuario", new Usuario());
        return "registro";
    }

    @PostMapping("/registro")
    public String registrarUsuario(@ModelAttribute Usuario usuario) {
        usuarioRepository.save(usuario);
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String mostrarFormularioLogin() {
        return "login";
    }

    @PostMapping("/login")
    public String loginUsuario(@RequestParam String correo, @RequestParam String contrasena, Model model) {
        Usuario usuario = usuarioRepository.findAll()
            .stream()
            .filter(u -> u.getCorreo().equals(correo) && contrasena.equals(u.getContrasena()))
            .findFirst()
            .orElse(null);

        if (usuario != null) {
            // Redirección según rol
            switch (usuario.getRol()) {
                case "Administrador":
                    return "redirect:/admin/panelAdmin";
                case "Organizador":
                    return "redirect:/organizador/panelOrganizador";
                case "Expositor":
                    return "redirect:/expositor/panelExpositor";
                case "Visitante":
                    return "redirect:/visitante/panelVisitante";
                case "Evaluador":
                    return "redirect:/evaluador/panelEvaluador";
                default:
                    return "redirect:/";
            }
        } else {
            model.addAttribute("error", "Credenciales incorrectas");
            return "login";
        }
    }

    @GetMapping("/")
    public String inicio() {
        return "index";
    }

}