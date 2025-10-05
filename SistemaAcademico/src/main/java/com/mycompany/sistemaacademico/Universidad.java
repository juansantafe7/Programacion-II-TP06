/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistemaacademico;

import java.util.ArrayList;
import java.util.List;

public class Universidad {
    private String nombre;
    private final List<Profesor> profesores = new ArrayList<>();
    private final List<Curso> cursos = new ArrayList<>();

    public Universidad(String nombre) {
        if (nombre == null || nombre.isBlank()) throw new IllegalArgumentException("nombre vacío");
        this.nombre = nombre.trim();
    }

    public String getNombre() { return nombre; }

    public void agregarProfesor(Profesor p) {
        if (p == null) return;
        if (!profesores.contains(p)) profesores.add(p);
    }

    public void agregarCurso(Curso c) {
        if (c == null) return;
        if (!cursos.contains(c)) cursos.add(c);
    }

    public Profesor buscarProfesorPorId(String id) {
        if (id == null) return null;
        for (Profesor p : profesores) {
            if (id.equalsIgnoreCase(p.getId())) return p;
        }
        return null;
    }

    public Curso buscarCursoPorCodigo(String codigo) {
        if (codigo == null) return null;
        for (Curso c : cursos) {
            if (codigo.equalsIgnoreCase(c.getCodigo())) return c;
        }
        return null;
    }

    public boolean asignarProfesorACurso(String codigoCurso, String idProfesor) {
        Curso c = buscarCursoPorCodigo(codigoCurso);
        Profesor p = buscarProfesorPorId(idProfesor);
        if (c == null || p == null) return false;
        c.setProfesor(p);
        return true;
    }

    public void listarProfesores() {
        if (profesores.isEmpty()) { System.out.println("No hay profesores."); return; }
        for (Profesor p : profesores) p.mostrarInfo();
    }

    public void listarCursos() {
        if (cursos.isEmpty()) { System.out.println("No hay cursos."); return; }
        for (Curso c : cursos) c.mostrarInfo();
    }

    /** Eliminar curso: rompe la relación con su profesor si la hubiera. */
    public boolean eliminarCurso(String codigo) {
        Curso c = buscarCursoPorCodigo(codigo);
        if (c == null) return false;
        // Romper relación bidireccional
        c.setProfesor(null);
        return cursos.remove(c);
    }

    public boolean eliminarProfesor(String id) {
        Profesor p = buscarProfesorPorId(id);
        if (p == null) return false;
        // Desasignar p de todos sus cursos
        for (Curso c : new ArrayList<>(p.getCursos())) {
            c.setProfesor(null);
        }
        return profesores.remove(p);
    }

    public void reporteCantidadCursosPorProfesor() {
        if (profesores.isEmpty()) {
            System.out.println("No hay profesores para reportar.");
            return;
        }
        System.out.println("== Cantidad de cursos por profesor ==");
        for (Profesor p : profesores) {
            System.out.println(p.getNombre() + " -> " + p.getCursos().size());
        }
    }
}
