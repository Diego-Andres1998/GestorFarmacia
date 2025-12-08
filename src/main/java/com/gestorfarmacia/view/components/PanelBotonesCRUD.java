package com.gestorfarmacia.view.components;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class PanelBotonesCRUD extends BasePanel {
    private Map<String, JButton> botones;

    @Override
    protected void inicializarComponentes() {
        // Inicializar el Map aquí para evitar NullPointerException
        botones = new HashMap<>();

        setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
        setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

        // Crear botones usando un mapa para reducir código repetitivo
        String[] nombresBotones = { "Agregar", "Editar", "Eliminar", "Limpiar" };
        for (String nombre : nombresBotones) {
            JButton boton = new JButton(nombre);
            botones.put(nombre, boton);
            add(boton);
        }
    }

    @Override
    public void limpiar() {
        // Los botones no necesitan limpieza, pero se implementa por contrato
    }

    // Getters específicos para compatibilidad con código existente
    public JButton getBtnAgregar() {
        return botones.get("Agregar");
    }

    public JButton getBtnEditar() {
        return botones.get("Editar");
    }

    public JButton getBtnEliminar() {
        return botones.get("Eliminar");
    }

    public JButton getBtnLimpiar() {
        return botones.get("Limpiar");
    }

    // Método genérico usando polimorfismo
    public JButton getBoton(String nombre) {
        return botones.get(nombre);
    }
}
