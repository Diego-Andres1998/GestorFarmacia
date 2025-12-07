package com.gestorfarmacia.view.components;

import javax.swing.*;
import java.awt.*;

public class PanelFormularioMedicamento extends JPanel {
    // Componentes del formulario
    private JTextField txtCodigo;
    private JTextField txtNombreComercial;
    private JTextField txtLaboratorio;
    private JComboBox<String> cmbTipoVenta;
    private JRadioButton rbPastillas;
    private JRadioButton rbJarabe;
    private JRadioButton rbInyectable;
    private ButtonGroup grupoFormato;
    private JCheckBox chkRequiereFrio;

    public PanelFormularioMedicamento() {
        inicializarComponentes();
    }

    private void inicializarComponentes() {
        setLayout(new GridBagLayout());
        setBorder(BorderFactory.createTitledBorder("Datos del Medicamento"));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Campo Código
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(new JLabel("Código:"), gbc);
        gbc.gridx = 1;
        txtCodigo = new JTextField(15);
        add(txtCodigo, gbc);

        // Campo Nombre Comercial
        gbc.gridx = 2;
        add(new JLabel("Nombre Comercial:"), gbc);
        gbc.gridx = 3;
        txtNombreComercial = new JTextField(15);
        add(txtNombreComercial, gbc);

        // Campo Laboratorio
        gbc.gridx = 0;
        gbc.gridy = 1;
        add(new JLabel("Laboratorio:"), gbc);
        gbc.gridx = 1;
        txtLaboratorio = new JTextField(15);
        add(txtLaboratorio, gbc);

        // ComboBox Tipo de Venta
        gbc.gridx = 2;
        add(new JLabel("Tipo de Venta:"), gbc);
        gbc.gridx = 3;
        String[] tiposVenta = { "Libre", "Receta Simple", "Receta Retenida" };
        cmbTipoVenta = new JComboBox<>(tiposVenta);
        add(cmbTipoVenta, gbc);

        // RadioButtons para Formato
        gbc.gridx = 0;
        gbc.gridy = 2;
        add(new JLabel("Formato:"), gbc);
        gbc.gridx = 1;
        gbc.gridwidth = 3;
        JPanel panelFormato = new JPanel(new FlowLayout(FlowLayout.LEFT));
        rbPastillas = new JRadioButton("Pastillas");
        rbJarabe = new JRadioButton("Jarabe");
        rbInyectable = new JRadioButton("Inyectable");

        // Agrupar los radio buttons para que solo uno esté seleccionado
        grupoFormato = new ButtonGroup();
        grupoFormato.add(rbPastillas);
        grupoFormato.add(rbJarabe);
        grupoFormato.add(rbInyectable);
        panelFormato.add(rbPastillas);
        panelFormato.add(rbJarabe);
        panelFormato.add(rbInyectable);
        add(panelFormato, gbc);

        // CheckBox Requiere Frío
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        chkRequiereFrio = new JCheckBox("Requiere Refrigeración");
        add(chkRequiereFrio, gbc);
    }

    // Getters para acceder a los componentes
    public JTextField getTxtCodigo() {
        return txtCodigo;
    }

    public JTextField getTxtNombreComercial() {
        return txtNombreComercial;
    }

    public JTextField getTxtLaboratorio() {
        return txtLaboratorio;
    }

    public JComboBox<String> getCmbTipoVenta() {
        return cmbTipoVenta;
    }

    public JRadioButton getRbPastillas() {
        return rbPastillas;
    }

    public JRadioButton getRbJarabe() {
        return rbJarabe;
    }

    public JRadioButton getRbInyectable() {
        return rbInyectable;
    }

    public JCheckBox getChkRequiereFrio() {
        return chkRequiereFrio;
    }

    // Método para limpiar todos los campos
    public void limpiarCampos() {
        txtCodigo.setText("");
        txtNombreComercial.setText("");
        txtLaboratorio.setText("");
        cmbTipoVenta.setSelectedIndex(0);
        grupoFormato.clearSelection();
        chkRequiereFrio.setSelected(false);
    }
}
