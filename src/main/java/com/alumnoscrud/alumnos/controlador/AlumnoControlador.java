package com.alumnoscrud.alumnos.controlador;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.alumnoscrud.alumnos.modelo.Alumno;
import com.alumnoscrud.alumnos.servicio.IAlumnoServicio;

@Controller
@RequestMapping("/alumno")
public class AlumnoControlador {
    
    @Autowired
    private IAlumnoServicio alumnoServicio;

     @GetMapping("/lista")
    public String listar(Model model, @RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "5") int size) {
        Page<Alumno> listaAlumnos = alumnoServicio.listarAlumnosPaginados(PageRequest.of(page, size));
        model.addAttribute("alumnos", listaAlumnos.getContent());
        model.addAttribute("totalPages", listaAlumnos.getTotalPages());
        model.addAttribute("currentPage", page);
        model.addAttribute("size", size);
        return "listar";
    }
    @GetMapping("/crear")
    public String crear(Model model){
        model.addAttribute("alumno", new Alumno());
        return "crear";
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute("alumno") Alumno alumno) {
        alumnoServicio.guardar(alumno);
        return "redirect:/alumno/lista"; // Corregido: usar "lista" en lugar de "listar"
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable("id") Long id, Model model){
        Alumno alumno = alumnoServicio.buscarPorId(id);
        model.addAttribute("alumno", alumno);
        return "editar";
    }

    @PostMapping("/actualizar")
    public String actualizar(@ModelAttribute("alumno") Alumno alumno){
        alumnoServicio.guardar(alumno);
        return "redirect:/alumno/lista";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable("id") Long id){
        alumnoServicio.eliminarPorId(id);
        return "redirect:/alumno/lista";
    }
}