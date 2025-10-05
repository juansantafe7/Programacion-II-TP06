/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistemaacademico;

public class MainUniversidad {
    public static void main(String[] args) {
        Universidad uni = new Universidad("Universidad Nacional");

        // 1) Crear al menos 3 profesores y 5 cursos
        Profesor pr1 = new Profesor("P01", "Ana Gómez", "Bases de Datos");
        Profesor pr2 = new Profesor("P02", "Luis Pérez", "Programación");
        Profesor pr3 = new Profesor("P03", "María Torres", "Redes");

        Curso cu1 = new Curso("BD101", "Introducción a BD");
        Curso cu2 = new Curso("PR201", "Programación II");
        Curso cu3 = new Curso("PR301", "POO Avanzada");
        Curso cu4 = new Curso("RD101", "Fundamentos de Redes");
        Curso cu5 = new Curso("IA101", "Introducción a IA");

        // 2) Agregar profesores y cursos a la universidad
        uni.agregarProfesor(pr1);
        uni.agregarProfesor(pr2);
        uni.agregarProfesor(pr3);

        uni.agregarCurso(cu1);
        uni.agregarCurso(cu2);
        uni.agregarCurso(cu3);
        uni.agregarCurso(cu4);
        uni.agregarCurso(cu5);

        // 3) Asignar profesores a cursos
        uni.asignarProfesorACurso("BD101", "P01");
        uni.asignarProfesorACurso("PR201", "P02");
        uni.asignarProfesorACurso("PR301", "P02");
        uni.asignarProfesorACurso("RD101", "P03");
        // cu5 (IA101) queda sin profesor de inicio

        // 4) Listar cursos con su profesor y profesores con sus cursos
        System.out.println("\n== Cursos ==");
        uni.listarCursos();
        System.out.println("\n== Profesores ==");
        uni.listarProfesores();
        System.out.println("\n== Listados por profesor ==");
        pr1.listarCursos();
        pr2.listarCursos();
        pr3.listarCursos();

        // 5) Cambiar el profesor de un curso (PR301 de P02 -> P03) y verificar sincronización
        System.out.println("\n== Reasignar PR301 a P03 ==");
        uni.asignarProfesorACurso("PR301", "P03");
        pr2.listarCursos();
        pr3.listarCursos();

        // 6) Remover un curso (PR201) y confirmar que ya no aparece en la lista del profesor
        System.out.println("\n== Eliminar curso PR201 ==");
        uni.eliminarCurso("PR201");
        pr2.listarCursos();
        uni.listarCursos();

        // 7) Remover un profesor (P01) y dejar profesor=null en sus cursos
        System.out.println("\n== Eliminar profesor P01 ==");
        uni.eliminarProfesor("P01");
        uni.listarProfesores();
        uni.listarCursos();

        // 8) Reporte: cantidad de cursos por profesor
        System.out.println();
        uni.reporteCantidadCursosPorProfesor();

        System.out.println("\n== FIN DEMO ==");
    }
}