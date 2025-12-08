package com.gestorfarmacia.util;

import com.gestorfarmacia.model.Medicamento;
import com.gestorfarmacia.view.VentanaPrincipal;

public class MedicamentoMapper implements Mapper<Medicamento> {
    private final VentanaPrincipal vista;

    public MedicamentoMapper(VentanaPrincipal vista) {
        this.vista = vista;
    }

    @Override
    public Medicamento crearDesdeFormulario() {
        return new Medicamento(
                vista.getTxtCodigo().getText().trim(),
                vista.getTxtNombreComercial().getText().trim(),
                vista.getTxtLaboratorio().getText().trim(),
                (String) vista.getCmbTipoVenta().getSelectedItem(),
                obtenerFormatoSeleccionado(),
                vista.getChkRequiereFrio().isSelected());
    }

    @Override
    public void cargarEnFormulario(Medicamento medicamento) {
        vista.getTxtCodigo().setText(medicamento.getCodigo());
        vista.getTxtNombreComercial().setText(medicamento.getNombreComercial());
        vista.getTxtLaboratorio().setText(medicamento.getLaboratorio());
        vista.getCmbTipoVenta().setSelectedItem(medicamento.getTipoVenta());
        seleccionarFormato(medicamento.getFormato());
        vista.getChkRequiereFrio().setSelected(medicamento.isRequiereFrio());
    }

    private String obtenerFormatoSeleccionado() {
        if (vista.getRbPastillas().isSelected())
            return "Pastillas";
        if (vista.getRbJarabe().isSelected())
            return "Jarabe";
        if (vista.getRbInyectable().isSelected())
            return "Inyectable";
        return "";
    }

    private void seleccionarFormato(String formato) {
        switch (formato) {
            case "Pastillas" -> vista.getRbPastillas().setSelected(true);
            case "Jarabe" -> vista.getRbJarabe().setSelected(true);
            case "Inyectable" -> vista.getRbInyectable().setSelected(true);
        }
    }

    // Método legacy para compatibilidad
    public Medicamento crearDesdeFformulario() {
        return crearDesdeFormulario();
    }
}
