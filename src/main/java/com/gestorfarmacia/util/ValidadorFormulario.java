package com.gestorfarmacia.util;

import com.gestorfarmacia.view.VentanaPrincipal;

public class ValidadorFormulario implements Validador {
    private final VentanaPrincipal vista;
    private String mensajeError;

    public ValidadorFormulario(VentanaPrincipal vista) {
        this.vista = vista;
    }

    @Override
    public boolean validar() {
        if (vista.getTxtCodigo().getText().trim().isEmpty()) {
            mensajeError = "Debe ingresar un código";
            return false;
        }
        if (vista.getTxtNombreComercial().getText().trim().isEmpty()) {
            mensajeError = "Debe ingresar un nombre comercial";
            return false;
        }
        if (vista.getTxtLaboratorio().getText().trim().isEmpty()) {
            mensajeError = "Debe ingresar un laboratorio";
            return false;
        }
        if (!vista.getRbPastillas().isSelected() &&
                !vista.getRbJarabe().isSelected() &&
                !vista.getRbInyectable().isSelected()) {
            mensajeError = "Debe seleccionar un formato";
            return false;
        }
        return true;
    }

    @Override
    public String getMensajeError() {
        return mensajeError;
    }

    // Método legacy para compatibilidad
    public boolean validarCampos() {
        boolean resultado = validar();
        if (!resultado) {
            MensajeFactory.mostrar(MensajeFactory.TipoMensaje.ERROR, mensajeError, vista);
        }
        return resultado;
    }
}
