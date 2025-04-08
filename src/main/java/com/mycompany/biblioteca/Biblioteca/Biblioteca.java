/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.biblioteca.Biblioteca;

import java.util.ArrayList;

/**
 *
 * @author EquipoDell
 */
    class Biblioteca {
    private final ArrayList<Libro> libros;

    public Biblioteca() {
        libros = new ArrayList<>();
    }

    public void agregarLibro(String titulo, String autor) {
        libros.add(new Libro(titulo, autor));
    }

    public void eliminarLibro(String titulo) {
        libros.removeIf(libro -> libro.getTitulo().equalsIgnoreCase(titulo));
    }

    public String listarLibros() {
        StringBuilder listado = new StringBuilder();
        for (Libro libro : libros) {
            listado.append(libro.getTitulo()).append(" - ").append(libro.getAutor()).append("\n");
        }
        return listado.toString();
    }

    public boolean buscarLibro(String titulo) {
        for (Libro libro : libros) {
            if (libro.getTitulo().equalsIgnoreCase(titulo)) {
                return true;
            }
        }
        return false;
    }
}

