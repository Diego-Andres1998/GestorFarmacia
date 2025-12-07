package com.gestorfarmacia.view.components;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class PanelTablaMedicamentos extends JScrollPane {
    private JTable tablaMedicamentos;
    private DefaultTableModel modeloTabla;

    public PanelTablaMedicamentos() {
        inicializarComponentes();
    }

    private void inicializarComponentes() {
        // Definir las columnas de la tabla
        String[] columnas = { "Código", "Nombre Comercial", "Laboratorio",
                "Tipo Venta", "Formato", "Refrigeración" };

        // Crear el modelo de la tabla
        modeloTabla = new DefaultTableModel(columnas, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // No permitir edición directa en la tabla
            }
        };

        // Crear la tabla con el modelo
        tablaMedicamentos = new JTable(modeloTabla);
        tablaMedicamentos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        // Configurar el scroll pane
        setViewportView(tablaMedicamentos);
        setBorder(BorderFactory.createTitledBorder("Lista de Medicamentos"));
    }

    // Getters
    public JTable getTablaMedicamentos() {
        return tablaMedicamentos;
    }

    public DefaultTableModel getModeloTabla() {
        return modeloTabla;
    }
}
