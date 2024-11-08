package com.demodj.demo_examen.Controller;

import com.demodj.demo_examen.Entity.Estudiante;
import com.demodj.demo_examen.Service.EstudianteService;
import com.demodj.demo_examen.Service.Impl.EstudianteServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequestMapping("/estudiante")
public class EstudianteController {

    private final EstudianteService estudianteService;

    @Autowired
    public EstudianteController(EstudianteService estudianteService) {
        this.estudianteService=estudianteService;

    }
    @GetMapping("/listar-estudiante")
    public String listEstudiante(Model model){
        model.addAttribute("title","lista de estudiante");
        model.addAttribute("listaEstudiante", estudianteService.getAllEstudiante());
        return "pages/list-Estudiante";
    }

    @GetMapping("/nuevo")
    public String addEstudiante(Model model){
        Estudiante estudiante = new Estudiante();
        model.addAttribute("title", "Agregar Estudiante");
        model.addAttribute("estudiantes", estudiante); // Cambio aquí: el nombre debe ser "estudiantes"
        return "pages/form-estudiante/formAgregar_estudiante";
    }

    @PostMapping("/save")
    public String saveEstudiante(@ModelAttribute("estudiantes") Estudiante estudiante){ // Asegúrate de usar "estudiantes" aquí
        estudianteService.addEstudiante(estudiante);
        return "redirect:/estudiante/listar-estudiante"; // Asegúrate de que la ruta coincide
    }
    // Método para mostrar el formulario de actualización
    @GetMapping("/update/{id}")
    public String mostrarFormularioActualizar(@PathVariable("id") Long id, Model model) {
        // Obtener el estudiante por su ID
        Estudiante estudiante = estudianteService.buscarPorId(id);
        if (estudiante != null) {
            model.addAttribute("estudiante", estudiante);
            return "pages/form-updateEstudiante"; // Nombre de la plantilla Thymeleaf
        }
        return "redirect:/list-estudiante"; // Redirigir si el estudiante no se encuentra
    }

    // Método para eliminar un estudiante
    @GetMapping("/eliminar/{id}")
    public String eliminarEstudiante(@PathVariable("id") Long id) {
        // Llamamos al servicio para eliminar al estudiante
        estudianteService.deleteEstudiante(id);
        // Redirigimos al listado de estudiantes después de eliminar
        return "redirect:/estudiante/listar-estudiante";
    }
}



