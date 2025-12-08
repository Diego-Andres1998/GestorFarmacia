package com.gestorfarmacia.view.components;

import javax.swing.*;
import java.awt.*;

public class PanelFormularioMedicamento extends BasePanel {
    private JTextField txtCodigo, txtNombreComercial, txtLaboratorio;
    private JComboBox<String> cmbTipoVenta;
    private JRadioButton rbPastillas, rbJarabe, rbInyectable;
    private ButtonGroup grupoFormato;
    private JCheckBox chkRequiereFrio;

    @Override
    protected void inicializarComponentes() {
        setLayout(new GridBagLayout());
        configurarBorde("Datos del Medicamento");

        GridBagConstraints restricciones = new GridBagConstraints();
        restricciones.insets = new Insets(5, 5, 5, 5);
        restricciones.fill = GridBagConstraints.HORIZONTAL;

        // Fila 1
        agregarCampo(restricciones, 0, 0, "Código:", txtCodigo = new JTextField(15));
        agregarCampo(restricciones, 2, 0, "Nombre Comercial:", txtNombreComercial = new JTextField(15));

        // Fila 2
        agregarCampo(restricciones, 0, 1, "Laboratorio:", txtLaboratorio = new JTextField(15));

        String[] tiposVenta = { "Libre", "Receta Simple", "Receta Retenida" };
        agregarCampo(restricciones, 2, 1, "Tipo de Venta:", cmbTipoVenta = new JComboBox<>(tiposVenta));

        // Fila 3 - Radio Buttons
        restricciones.gridx = 0;
        restricciones.gridy = 2;
        add(new JLabel("Formato:"), restricciones);

        restricciones.gridx = 1;
        restricciones.gridwidth = 3;
        JPanel panelFormato = new JPanel(new FlowLayout(FlowLayout.LEFT));
        grupoFormato = new ButtonGroup();

        rbPastillas = crearRadioButton("Pastillas", grupoFormato, panelFormato);
        rbJarabe = crearRadioButton("Jarabe", grupoFormato, panelFormato);
        rbInyectable = crearRadioButton("Inyectable", grupoFormato, panelFormato);

        add(panelFormato, restricciones);

        // Fila 4 - CheckBox
        restricciones.gridx = 0;
        restricciones.gridy = 3;
        restricciones.gridwidth = 2;
        chkRequiereFrio = new JCheckBox("Requiere Refrigeración");
        add(chkRequiereFrio, restricciones);
    }

    private void agregarCampo(GridBagConstraints restricciones, int x, int y, String label, JComponent campo) {
        restricciones.gridx = x;
        restricciones.gridy = y;
        restricciones.gridwidth = 1;
        add(new JLabel(label), restricciones);
        restricciones.gridx = x + 1;
        add(campo, restricciones);
    }

    private JRadioButton crearRadioButton(String texto, ButtonGroup grupo, JPanel panel) {
        JRadioButton radioButton = new JRadioButton(texto);
        grupo.add(radioButton);
        panel.add(radioButton);
        return radioButton;
    }

    @Override
    public void limpiar() {
        txtCodigo.setText("");
        txtNombreComercial.setText("");
        txtLaboratorio.setText("");
        cmbTipoVenta.setSelectedIndex(0);
        grupoFormato.clearSelection();
        chkRequiereFrio.setSelected(false);
    }

    // Getters
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

    // Método legacy para compatibilidad
    public void limpiarCampos() {
        limpiar();
    }
}
