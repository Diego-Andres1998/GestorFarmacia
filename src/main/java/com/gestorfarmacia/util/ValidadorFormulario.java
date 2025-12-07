package com.gestorfarmacia.util;

import com.gestorfarmacia.view.VentanaPrincipal;
import javax.swing.*;

public class ValidadorFormulario {
    private VentanaPrincipal vista;

    public ValidadorFormulario(VentanaPrincipal vista) {
        this.vista = vista;
    }

    public boolean validarCampos() {
        // Validar código
        if (vista.getTxtCodigo().getText().trim().isEmpty()) {
            mostrarError("Debe ingresar un código");
            return false;
        }

        // Validar nombre comercial
        if (vista.getTxtNombreComercial().getText().trim().isEmpty()) {
            mostrarError("Debe ingresar un nombre comercial");
            return false;
        }

        // Validar laboratorio
        if (vista.getTxtLaboratorio().getText().trim().isEmpty()) {
            mostrarError("Debe ingresar un laboratorio");
            return false;
        }

        // Validar formato
        if (!vista.getRbPastillas().isSelected() &&
                !vista.getRbJarabe().isSelected() &&
                !vista.getRbInyectable().isSelected()) {
            mostrarError("Debe seleccionar un formato");
            return false;
        }

        return true;
    }

    private void mostrarError(String mensaje) {
        vista.mostrarMensaje(mensaje, "Error de Validación", JOptionPane.ERROR_MESSAGE);
    }
}
