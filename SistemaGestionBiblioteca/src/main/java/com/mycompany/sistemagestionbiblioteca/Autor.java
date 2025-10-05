/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.sistemagestionbiblioteca;

public class Autor {
    private String id;
    private String nombre;
    private String nacionalidad;

    public Autor(String id, String nombre, String nacionalidad) {
        if (id == null || id.isBlank()) throw new IllegalArgumentException("id vacío");
        if (nombre == null || nombre.isBlank()) throw new IllegalArgumentException("nombre vacío");
        this.id = id.trim();
        this.nombre = nombre.trim();
        this.nacionalidad = (nacionalidad == null) ? "" : nacionalidad.trim();
    }

    public String getId() { return id; }
    public String getNombre() { return nombre; }
    public String getNacionalidad() { return nacionalidad; }

    public void mostrarInfo() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        return "Autor{id='" + id + "', nombre='" + nombre + "', nacionalidad='" + nacionalidad + "'}";
    }
}