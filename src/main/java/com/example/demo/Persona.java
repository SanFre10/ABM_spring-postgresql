package com.example.demo;

import java.io.Serial;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "personas_abm")
public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Integer id;

    public String nombre;
    public String apellido;
    public String telefono;
    public String email;

    public Persona() {
        this.id = null;
        this.nombre = null;
        this.apellido = null;
        this.telefono = null;
        this.email = null;
    }

    public Persona(String nombre, String apellido, String telefono, String email) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.email = email;
    }

    public void setId(Integer id) {
        this.id = id;
    }

}
