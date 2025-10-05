/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistemagestionbiblioteca;

import java.util.List;

public class MainBiblioteca {
    public static void main(String[] args) {
        Biblioteca bib = new Biblioteca("Biblioteca Central");

        Autor a1 = new Autor("AU1", "Jorge Luis Borges", "Argentina");
        Autor a2 = new Autor("AU2", "Isabel Allende", "Chile");
        Autor a3 = new Autor("AU3", "Haruki Murakami", "Japón");

        bib.agregarLibro("ISBN-001", "Ficciones", 1944, a1);
        bib.agregarLibro("ISBN-002", "El Aleph", 1949, a1);
        bib.agregarLibro("ISBN-003", "La casa de los espíritus", 1982, a2);
        bib.agregarLibro("ISBN-004", "Tokio Blues (Norwegian Wood)", 1987, a3);
        bib.agregarLibro("ISBN-005", "Kafka en la orilla", 2002, a3);

        System.out.println("\n== Listado de libros ==");
        bib.listarLibros();

        System.out.println("\n== Buscar por ISBN 'ISBN-003' ==");
        Libro buscado = bib.buscarLibroPorIsbn("ISBN-003");
        System.out.println(buscado != null ? buscado : "No encontrado");

        int anio = 1987;
        System.out.println("\n== Libros del año " + anio + " ==");
        List<Libro> delAnio = bib.filtrarLibrosPorAnio(anio);
        if (delAnio.isEmpty()) System.out.println("Sin resultados.");
        for (Libro l : delAnio) System.out.println(l);

        System.out.println("\n== Eliminar 'ISBN-002' y listar restantes ==");
        boolean elim = bib.eliminarLibro("ISBN-002");
        System.out.println(elim ? "Eliminado OK" : "No existía ese ISBN");
        bib.listarLibros();

        System.out.println("\n== Cantidad total de libros ==");
        System.out.println(bib.obtenerCantidadLibros());

        System.out.println("\n== Autores disponibles ==");
        bib.mostrarAutoresDisponibles();

        System.out.println("\n== FIN DEMO ==");
    }
}