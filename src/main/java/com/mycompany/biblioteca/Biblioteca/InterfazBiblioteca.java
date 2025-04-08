/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.biblioteca.Biblioteca;
import javax.swing.*;
import java.awt.*;

/**
 * 
 * Autor: Denisse Joya
 */
public class InterfazBiblioteca extends JFrame {

    private static final long serialVersionUID = 1L;
    private final Biblioteca biblioteca;
    private JTextArea textArea;

    public InterfazBiblioteca() {
        biblioteca = new Biblioteca();
        initUI();
    }

    private void initUI() {
        setTitle("Gestión de Biblioteca");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Panel de entrada
        JPanel inputPanel = new JPanel(new GridLayout(5, 2));

        JLabel tituloLabel = new JLabel("Título:");
        JTextField tituloField = new JTextField();
        JLabel autorLabel = new JLabel("Autor:");
        JTextField autorField = new JTextField();

        JButton agregarButton = new JButton("Agregar Libro");
        JButton eliminarButton = new JButton("Eliminar Libro");
        JButton listarButton = new JButton("Listar Libros");
        JButton buscarButton = new JButton("Buscar Libro");
        JButton salirButton = new JButton("Salir");

        inputPanel.add(tituloLabel);
        inputPanel.add(tituloField);
        inputPanel.add(autorLabel);
        inputPanel.add(autorField);
        inputPanel.add(agregarButton);
        inputPanel.add(eliminarButton);
        inputPanel.add(listarButton);
        inputPanel.add(buscarButton);
        inputPanel.add(new JLabel()); // Espacio vacío
        inputPanel.add(salirButton);

        // Área de texto para mostrar resultados
        textArea = new JTextArea();
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);

        add(inputPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);

        // Acciones de los botones
        agregarButton.addActionListener(e -> {
            String titulo = tituloField.getText();
            String autor = autorField.getText();
            biblioteca.agregarLibro(titulo, autor);
            textArea.append("Libro agregado: " + titulo + " - " + autor + "\n");
        });

        eliminarButton.addActionListener(e -> {
            String titulo = tituloField.getText();
            biblioteca.eliminarLibro(titulo);
            textArea.append("Libro eliminado: " + titulo + "\n");
        });

        listarButton.addActionListener(e -> {
            String listado = biblioteca.listarLibros();
            textArea.setText("Listado de libros:\n" + listado);
        });

        buscarButton.addActionListener(e -> {
            String titulo = tituloField.getText();
            boolean encontrado = biblioteca.buscarLibro(titulo);
            if (encontrado) {
                textArea.append("Libro encontrado: " + titulo + "\n");
            } else {
                textArea.append("Libro no encontrado: " + titulo + "\n");
            }
        });

        salirButton.addActionListener(e -> System.exit(0));
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new InterfazBiblioteca().setVisible(true));
    }
}