package com.alumnoscrud.alumnos.modelo;


import jakarta.persistence.*;


@Entity
@Table(name="alumno")
public class Alumno {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nombre;

    private String Apellido;

    private String correo;

    private String dni;

    private String Direccion;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String apellido) {
        Apellido = apellido;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String direccion) {
        Direccion = direccion;
    }

    public Alumno(Integer id, String nombre, String apellido, String correo, String dni, String direccion) {
        this.id = id;
        this.nombre = nombre;
        Apellido = apellido;
        this.correo = correo;
        this.dni = dni;
        Direccion = direccion;
    }

    public Alumno(String nombre, String apellido, String correo, String dni, String direccion) {
        this.nombre = nombre;
        Apellido = apellido;
        this.correo = correo;
        this.dni = dni;
        Direccion = direccion;
    }

    public Alumno() {
    }

   
    
    

}
