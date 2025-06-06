package com.gestexpo.gestexpo.controlador;

import com.gestexpo.gestexpo.entidades.Evaluacion;
import com.gestexpo.gestexpo.repository.EvaluacionRepository;
import com.gestexpo.gestexpo.repository.StandRepository;
import com.gestexpo.gestexpo.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/evaluaciones")
public class EvaluacionController {

    @Autowired
    private EvaluacionRepository evaluacionRepository;
    @Autowired
    private StandRepository standRepository;
    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping
    public String listarEvaluaciones(Model model) {
        List<Evaluacion> evaluaciones = evaluacionRepository.findAll();
        model.addAttribute("evaluaciones", evaluaciones);
        return "evaluador/evaluacion";
    }

    @GetMapping("/editar/{id}")
    public String editarEvaluacion(@PathVariable Long id, Model model) {
        model.addAttribute("evaluacion", evaluacionRepository.findById(id).orElse(null));
        model.addAttribute("stands", standRepository.findAll());
        model.addAttribute("evaluadores", usuarioRepository.findAll());
        return "evaluador/nuevaEvaluacion";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarEvaluacion(@PathVariable Long id) {
        evaluacionRepository.deleteById(id);
        return "redirect:/evaluaciones";
    }

    @GetMapping("/nueva")
    public String mostrarFormularioNueva(Model model) {
        model.addAttribute("evaluacion", new Evaluacion());
        model.addAttribute("stands", standRepository.findAll());
        model.addAttribute("evaluadores", usuarioRepository.findAll());
        return "evaluador/nuevaEvaluacion";
    }

    @PostMapping("/guardar")
    public String guardarEvaluacion(@ModelAttribute Evaluacion evaluacion) {
        evaluacionRepository.save(evaluacion);
        return "redirect:/evaluaciones";
    }
}