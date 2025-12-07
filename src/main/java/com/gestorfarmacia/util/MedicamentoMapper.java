package com.gestorfarmacia.util;

import com.gestorfarmacia.model.Medicamento;
import com.gestorfarmacia.view.VentanaPrincipal;

public class MedicamentoMapper {
    private VentanaPrincipal vista;

    public MedicamentoMapper(VentanaPrincipal vista) {
        this.vista = vista;
    }

    public Medicamento crearDesdeFformulario() {
        String codigo = vista.getTxtCodigo().getText().trim();
        String nombre = vista.getTxtNombreComercial().getText().trim();
        String laboratorio = vista.getTxtLaboratorio().getText().trim();
        String tipoVenta = (String) vista.getCmbTipoVenta().getSelectedItem();
        String formato = obtenerFormatoSeleccionado();
        boolean requiereFrio = vista.getChkRequiereFrio().isSelected();

        return new Medicamento(codigo, nombre, laboratorio, tipoVenta, formato, requiereFrio);
    }

    public void cargarEnFormulario(Medicamento medicamento) {
        vista.getTxtCodigo().setText(medicamento.getCodigo());
        vista.getTxtNombreComercial().setText(medicamento.getNombreComercial());
        vista.getTxtLaboratorio().setText(medicamento.getLaboratorio());
        vista.getCmbTipoVenta().setSelectedItem(medicamento.getTipoVenta());

        // Seleccionar el formato correcto
        switch (medicamento.getFormato()) {
            case "Pastillas":
                vista.getRbPastillas().setSelected(true);
                break;
            case "Jarabe":
                vista.getRbJarabe().setSelected(true);
                break;
            case "Inyectable":
                vista.getRbInyectable().setSelected(true);
                break;
        }

        vista.getChkRequiereFrio().setSelected(medicamento.isRequiereFrio());
    }

    private String obtenerFormatoSeleccionado() {
        if (vista.getRbPastillas().isSelected()) {
            return "Pastillas";
        } else if (vista.getRbJarabe().isSelected()) {
            return "Jarabe";
        } else if (vista.getRbInyectable().isSelected()) {
            return "Inyectable";
        }
        return "";
    }
}
