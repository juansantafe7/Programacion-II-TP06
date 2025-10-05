/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistemagestionbiblioteca;

public class Libro {
    private String isbn;
    private String titulo;
    private int anioPublicacion;
    private Autor autor;

    public Libro(String isbn, String titulo, int anioPublicacion, Autor autor) {
        if (isbn == null || isbn.isBlank()) throw new IllegalArgumentException("isbn vacío");
        if (titulo == null || titulo.isBlank()) throw new IllegalArgumentException("titulo vacío");
        if (autor == null) throw new IllegalArgumentException("autor null");

        this.isbn = isbn.trim();
        this.titulo = titulo.trim();
        this.anioPublicacion = anioPublicacion;
        this.autor = autor;
    }

    public String getIsbn() { return isbn; }
    public String getTitulo() { return titulo; }
    public int getAnioPublicacion() { return anioPublicacion; }
    public Autor getAutor() { return autor; }

    public void mostrarInfo() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        return "Libro{isbn='" + isbn + "', titulo='" + titulo + "', anio=" + anioPublicacion +
               ", autor=" + (autor != null ? autor.getNombre() : "—") + "}";
    }
}