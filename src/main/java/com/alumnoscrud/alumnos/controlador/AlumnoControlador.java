package com.alumnoscrud.alumnos.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.alumnoscrud.alumnos.modelo.Alumno;
import com.alumnoscrud.alumnos.servicio.IAlumnoServicio;

@Controller

public class AlumnoControlador {
    
    @Autowired
    private IAlumnoServicio alumnoServicio;

    @GetMapping("/alumno/lista")
    public String listar(Model model){
        List<Alumno> listaAlumnos = alumnoServicio.listarAlumnos();
        model.addAttribute("alumno", listaAlumnos);
        return "listar";
    }

    @GetMapping("/alumno/crear")
    public String crear(Model model){
        model.addAttribute("alumno", new Alumno());
        return "crear";
    }

    @PostMapping("/alumno/guardar")
    public String guardar(@ModelAttribute("alumno") Alumno alumno) {
        alumnoServicio.guardar(alumno);
        return "redirect:/alumno/listar";
    }

    @GetMapping("/alumno/editar/{id}")
    public String editar(@PathVariable("id") Long id, Model model){
        Alumno alumno = alumnoServicio.buscarPorId(id);
        model.addAttribute("alumno", alumno);
        return "editar";
    }

    @PostMapping("/alumno/actualizar")
    public String actualizar(@ModelAttribute("alumno") Alumno alumno){
        alumnoServicio.guardar(alumno);
        return "redirect:/alumno/lista";
    }

    @GetMapping("/alumno/eliminar/{id}")
    public String eliminar(@PathVariable("id") Long id){
        alumnoServicio.eliminarPorId(id);
        return "redirect:/alumno/lista";
    }
}