package com.gestorfarmacia.view;

import com.gestorfarmacia.util.DialogoAcercaDe;
import com.gestorfarmacia.view.components.PanelFormularioMedicamento;
import com.gestorfarmacia.view.components.PanelTablaMedicamentos;
import com.gestorfarmacia.view.components.PanelBotonesCRUD;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class VentanaPrincipal extends JFrame {
    // Componentes principales
    private PanelFormularioMedicamento panelFormulario;
    private PanelTablaMedicamentos panelTabla;
    private PanelBotonesCRUD panelBotones;

    public VentanaPrincipal() {
        configurarVentana();
        crearMenuSuperior();
        crearPanelNorte();
        crearPanelCentro();
        crearPanelSur();
    }

    private void configurarVentana() {
        setTitle("Gestor de Farmacia - Registro de Medicamentos");
        setSize(900, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Centrar la ventana
        setLayout(new BorderLayout(10, 10));
    }

    private void crearMenuSuperior() {
        JMenuBar menuBar = new JMenuBar();

        // Menú Ayuda
        JMenu menuAyuda = new JMenu("Ayuda");
        JMenuItem itemAcercaDe = new JMenuItem("Acerca de");
        itemAcercaDe.addActionListener(e -> DialogoAcercaDe.mostrar(this));
        menuAyuda.add(itemAcercaDe);

        menuBar.add(menuAyuda);
        setJMenuBar(menuBar);
    }

    private void crearPanelNorte() {
        panelFormulario = new PanelFormularioMedicamento();
        add(panelFormulario, BorderLayout.NORTH);
    }

    private void crearPanelCentro() {
        panelTabla = new PanelTablaMedicamentos();
        add(panelTabla, BorderLayout.CENTER);
    }

    private void crearPanelSur() {
        panelBotones = new PanelBotonesCRUD();
        add(panelBotones, BorderLayout.SOUTH);
    }

    // Getters que delegan al panel del formulario
    public JTextField getTxtCodigo() {
        return panelFormulario.getTxtCodigo();
    }

    public JTextField getTxtNombreComercial() {
        return panelFormulario.getTxtNombreComercial();
    }

    public JTextField getTxtLaboratorio() {
        return panelFormulario.getTxtLaboratorio();
    }

    public JComboBox<String> getCmbTipoVenta() {
        return panelFormulario.getCmbTipoVenta();
    }

    public JRadioButton getRbPastillas() {
        return panelFormulario.getRbPastillas();
    }

    public JRadioButton getRbJarabe() {
        return panelFormulario.getRbJarabe();
    }

    public JRadioButton getRbInyectable() {
        return panelFormulario.getRbInyectable();
    }

    public JCheckBox getChkRequiereFrio() {
        return panelFormulario.getChkRequiereFrio();
    }

    // Getters que delegan a los paneles
    public JTable getTablaMedicamentos() {
        return panelTabla.getTablaMedicamentos();
    }

    public DefaultTableModel getModeloTabla() {
        return panelTabla.getModeloTabla();
    }

    public JButton getBtnAgregar() {
        return panelBotones.getBtnAgregar();
    }

    public JButton getBtnEditar() {
        return panelBotones.getBtnEditar();
    }

    public JButton getBtnEliminar() {
        return panelBotones.getBtnEliminar();
    }

    public JButton getBtnLimpiar() {
        return panelBotones.getBtnLimpiar();
    }

    public void limpiarCampos() {
        panelFormulario.limpiarCampos();
    }

    public void mostrarMensaje(String mensaje, String titulo, int tipo) {
        JOptionPane.showMessageDialog(this, mensaje, titulo, tipo);
    }
}
