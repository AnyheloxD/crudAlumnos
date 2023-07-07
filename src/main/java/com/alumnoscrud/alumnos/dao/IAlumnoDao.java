package com.alumnoscrud.alumnos.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alumnoscrud.alumnos.modelo.Alumno;

public interface IAlumnoDao extends JpaRepository<Alumno , Long>{
    
}
