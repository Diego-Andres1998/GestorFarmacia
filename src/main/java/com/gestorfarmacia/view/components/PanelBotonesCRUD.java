package com.gestorfarmacia.view.components;

import javax.swing.*;
import java.awt.*;

public class PanelBotonesCRUD extends JPanel {
    private JButton btnAgregar;
    private JButton btnEditar;
    private JButton btnEliminar;
    private JButton btnLimpiar;

    public PanelBotonesCRUD() {
        inicializarComponentes();
    }

    private void inicializarComponentes() {
        setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
        setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

        // Crear los botones CRUD
        btnAgregar = new JButton("Agregar");
        btnEditar = new JButton("Editar");
        btnEliminar = new JButton("Eliminar");
        btnLimpiar = new JButton("Limpiar");

        // Agregar los botones al panel
        add(btnAgregar);
        add(btnEditar);
        add(btnEliminar);
        add(btnLimpiar);
    }

    // Getters
    public JButton getBtnAgregar() {
        return btnAgregar;
    }

    public JButton getBtnEditar() {
        return btnEditar;
    }

    public JButton getBtnEliminar() {
        return btnEliminar;
    }

    public JButton getBtnLimpiar() {
        return btnLimpiar;
    }
}
