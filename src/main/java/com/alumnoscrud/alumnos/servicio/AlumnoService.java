package com.alumnoscrud.alumnos.servicio;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import org.springframework.stereotype.Service;

import com.alumnoscrud.alumnos.dao.IAlumnoDao;
import com.alumnoscrud.alumnos.modelo.Alumno;

@Service
public class AlumnoService implements IAlumnoServicio {

    @Autowired
    private IAlumnoDao alumnoDao;

    @Override
    public List<Alumno> listarAlumnos() {
        return alumnoDao.findAll();
    }

    @Override
    public Alumno buscarPorId(Long id) {
        Optional<Alumno> alumnoOptional = alumnoDao.findById(id);
        if (alumnoOptional.isPresent()) {
            return alumnoOptional.get();
        } else {
            throw new NoSuchElementException("El alumno con el id " + id + " no existe");
        }
    }

    @Override
    public void guardar(Alumno alumno) {
        alumnoDao.save(alumno);
    }

    @Override
    public void eliminarPorId(Long id) {
        alumnoDao.deleteById(id);
    }

    @Override
    public void actualizar(Alumno alumno) {
        alumnoDao.save(alumno);
    }

    
    @Override
    public Page<Alumno> listarAlumnosPaginados(PageRequest pageRequest) {
        return alumnoDao.findAll(pageRequest);
    }

}