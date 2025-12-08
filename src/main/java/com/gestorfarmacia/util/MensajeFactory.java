package com.gestorfarmacia.util;

import javax.swing.*;
import java.awt.*;

public class MensajeFactory {

    public enum TipoMensaje {
        EXITO("Éxito", JOptionPane.INFORMATION_MESSAGE),
        ERROR("Error", JOptionPane.ERROR_MESSAGE),
        ADVERTENCIA("Advertencia", JOptionPane.WARNING_MESSAGE);

        private final String titulo;
        private final int tipoJOption;

        TipoMensaje(String titulo, int tipoJOption) {
            this.titulo = titulo;
            this.tipoJOption = tipoJOption;
        }
    }

    public static void mostrar(TipoMensaje tipo, String mensaje, Component parent) {
        JOptionPane.showMessageDialog(parent, mensaje, tipo.titulo, tipo.tipoJOption);
    }

    public static boolean confirmar(String mensaje, Component parent) {
        int resultado = JOptionPane.showConfirmDialog(
                parent,
                mensaje,
                "Confirmación",
                JOptionPane.YES_NO_OPTION);
        return resultado == JOptionPane.YES_OPTION;
    }
}
