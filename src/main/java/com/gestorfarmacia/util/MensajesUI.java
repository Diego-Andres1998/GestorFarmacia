package com.gestorfarmacia.util;

import com.gestorfarmacia.view.VentanaPrincipal;
import javax.swing.*;

public class MensajesUI {

    // Mensajes de éxito
    public static void mostrarMedicamentoAgregado(VentanaPrincipal vista) {
        vista.mostrarMensaje("Medicamento agregado exitosamente",
                "Éxito", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void mostrarMedicamentoActualizado(VentanaPrincipal vista) {
        vista.mostrarMensaje("Medicamento actualizado exitosamente",
                "Éxito", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void mostrarMedicamentoEliminado(VentanaPrincipal vista) {
        vista.mostrarMensaje("Medicamento eliminado exitosamente",
                "Éxito", JOptionPane.INFORMATION_MESSAGE);
    }

    // Mensajes de error
    public static void mostrarCodigoDuplicado(VentanaPrincipal vista) {
        vista.mostrarMensaje("Ya existe un medicamento con ese código",
                "Error", JOptionPane.ERROR_MESSAGE);
    }

    public static void mostrarErrorActualizacion(VentanaPrincipal vista) {
        vista.mostrarMensaje("Error al actualizar medicamento",
                "Error", JOptionPane.ERROR_MESSAGE);
    }

    // Mensajes de advertencia
    public static void mostrarDebeSeleccionarFila(VentanaPrincipal vista) {
        vista.mostrarMensaje("Debe seleccionar un medicamento de la tabla",
                "Advertencia", JOptionPane.WARNING_MESSAGE);
    }

    // Diálogos de confirmación
    public static boolean confirmarEliminacion(VentanaPrincipal vista, String codigo) {
        int confirmacion = JOptionPane.showConfirmDialog(vista,
                "¿Está seguro de eliminar el medicamento con código: " + codigo + "?",
                "Confirmar Eliminación",
                JOptionPane.YES_NO_OPTION);
        return confirmacion == JOptionPane.YES_OPTION;
    }
}
