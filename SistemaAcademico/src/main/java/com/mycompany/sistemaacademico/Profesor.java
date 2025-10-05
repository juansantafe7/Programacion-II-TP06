/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.sistemaacademico;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Profesor {
    private String id;
    private String nombre;
    private String especialidad;
    private final List<Curso> cursos = new ArrayList<>();

    public Profesor(String id, String nombre, String especialidad) {
        if (id == null || id.isBlank()) throw new IllegalArgumentException("id vacío");
        if (nombre == null || nombre.isBlank()) throw new IllegalArgumentException("nombre vacío");
        this.id = id.trim();
        this.nombre = nombre.trim();
        this.especialidad = (especialidad == null) ? "" : especialidad.trim();
    }

    public String getId() { return id; }
    public String getNombre() { return nombre; }
    public String getEspecialidad() { return especialidad; }
    public List<Curso> getCursos() { return new ArrayList<>(cursos); }

    public void agregarCurso(Curso c) {
        Objects.requireNonNull(c, "curso null");
        if (!cursos.contains(c)) {
            cursos.add(c);
        }
        // sincroniza el lado del curso
        if (c.getProfesor() != this) {
            c.setProfesor(this);
        }
    }

    public void eliminarCurso(Curso c) {
        if (c == null) return;
        if (cursos.remove(c)) {
            if (c.getProfesor() == this) {
                c.setProfesor(null);
            }
        }
    }

    void agregarCursoInterno(Curso c) {
        if (!cursos.contains(c)) cursos.add(c);
    }

    void eliminarCursoInterno(Curso c) {
        cursos.remove(c);
    }

    public void listarCursos() {
        if (cursos.isEmpty()) {
            System.out.println(nombre + " no dicta cursos.");
            return;
        }
        System.out.println("Cursos de " + nombre + ":");
        for (Curso c : cursos) {
            System.out.println(" - " + c.getCodigo() + " | " + c.getNombre());
        }
    }

    public void mostrarInfo() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        return "Profesor{id='" + id + "', nombre='" + nombre +
               "', especialidad='" + especialidad + "', cursos=" + cursos.size() + "}";
    }
}
