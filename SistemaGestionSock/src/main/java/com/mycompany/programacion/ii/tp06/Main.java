/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.programacion.ii.tp06;

public class Main {
    public static void main(String[] args) {
        Inventario inv = new Inventario();

        System.out.println("===== 1) Creamos 5 productos =====");
        inv.agregarProducto(new Producto("A1", "Arroz 1kg",     950.0,  15, CategoriaProducto.ALIMENTOS));
        inv.agregarProducto(new Producto("E1", "Auriculares",  5200.0,  8,  CategoriaProducto.ELECTRONICA));
        inv.agregarProducto(new Producto("R1", "Remera",       3200.0,  20, CategoriaProducto.ROPA));
        inv.agregarProducto(new Producto("H1", "Almohada",     2800.0,  12, CategoriaProducto.HOGAR));
        inv.agregarProducto(new Producto("A2", "Galletitas",    750.0,  30, CategoriaProducto.ALIMENTOS));

        System.out.println("\n===== 2) Listamos los productos =====");
        inv.listarProductos();

        System.out.println("\n===== 3) Buscamos producto por ID ('E1') =====");
        Producto buscado = inv.buscarProductoPorId("E1");
        System.out.println(buscado != null ? buscado : "No existe el producto con ID E1");

        System.out.println("\n===== 4) Filtramos por categoría ELECTRONICA =====");
        inv.filtrarPorCategoria(CategoriaProducto.ELECTRONICA)
                .forEach(System.out::println);

        System.out.println("\n===== 5) Eliminamos producto por ID ('A2') =====");
        boolean eliminado = inv.eliminarProducto("A2");
        System.out.println(eliminado ? "Eliminado OK" : "No se encontró 'A2'");
        inv.listarProductos();

        System.out.println("\n===== 6) Actualizamos stock de 'H1' a 50 unidades =====");
        System.out.println(inv.actualizarStock("H1", 50) ? "Stock actualizado" : "No se encontró 'H1'");
        System.out.println(inv.buscarProductoPorId("H1"));

        System.out.println("\n===== 7) Mostramos total de stock =====");
        System.out.println("Total stock = " + inv.obtenerTotalStock());

        System.out.println("\n===== 8) Producto con mayor stock =====");
        System.out.println(inv.obtenerProductoConMayorStock());

        System.out.println("\n===== 9) Filtramos productos entre $1000 y $3000 =====");
        inv.filtrarProductosPorPrecio(1000, 3000)
                .forEach(System.out::println);

        System.out.println("\n===== 10) Categorías disponibles =====");
        inv.mostrarCategoriasDisponibles();

        System.out.println("\n===== FIN DEMO =====");
    }
}