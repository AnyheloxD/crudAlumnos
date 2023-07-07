package com.alumnoscrud.alumnos.servicio;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import com.alumnoscrud.alumnos.modelo.Alumno;

public interface IAlumnoServicio {
    
    List<Alumno> listarAlumnos();
    
    Alumno buscarPorId(Long id);
    
    void guardar(Alumno alumno);
    
    void eliminarPorId(Long id);
    
    void actualizar(Alumno alumno);

     Page<Alumno> listarAlumnosPaginados(PageRequest pageRequest);
}