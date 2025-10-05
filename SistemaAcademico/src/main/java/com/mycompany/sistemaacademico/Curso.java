/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistemaacademico;

import java.util.Objects;

public class Curso {
    private String codigo;
    private String nombre;
    private Profesor profesor;

    public Curso(String codigo, String nombre) {
        if (codigo == null || codigo.isBlank()) throw new IllegalArgumentException("codigo vacío");
        if (nombre == null || nombre.isBlank()) throw new IllegalArgumentException("nombre vacío");
        this.codigo = codigo.trim();
        this.nombre = nombre.trim();
    }

    public String getCodigo() { return codigo; }
    public String getNombre() { return nombre; }
    public Profesor getProfesor() { return profesor; }

    public void setProfesor(Profesor p) {
        if (this.profesor == p) return;

        if (this.profesor != null) {
            this.profesor.eliminarCursoInterno(this);
        }

        this.profesor = p;

        if (p != null) {
            p.agregarCursoInterno(this);
        }
    }

    public void mostrarInfo() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        String prof = (profesor != null) ? profesor.getNombre() : "—";
        return "Curso{codigo='" + codigo + "', nombre='" + nombre + "', profesor='" + prof + "'}";
    }
}
