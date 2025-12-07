package com.gestorfarmacia.util;

import javax.swing.*;
import java.awt.*;

public class DialogoAcercaDe {

    public static void mostrar(Component padre) {
        // Crear el contenido HTML centrado
        String htmlContent = "<html><body style='width: 300px; text-align: center; font-family: Arial, sans-serif;'>" +
                "<h2 style='color: #2C5F7C; margin: 10px 0;'>Gestor de Farmacia v1.0</h2>" +
                "<p style='margin: 5px 0;'>Sistema de Registro de Medicamentos</p>" +
                "<hr style='border: 1px solid #E0E0E0; margin: 15px 0;'>" +
                "<p style='margin: 5px 0;'><b>Desarrollado por:</b> Diego Vergara</p>" +
                "<p style='margin: 10px 0;'><a href='https://github.com/Diego-Andres1998/GestorFarmacia'>" +
                "github.com/Diego-Andres1998/GestorFarmacia</a></p>" +
                "<p style='margin: 10px 0; color: #666;'>© 2025</p>" +
                "</body></html>";

        // Crear un JEditorPane para mostrar HTML
        JEditorPane editorPane = new JEditorPane("text/html", htmlContent);
        editorPane.setEditable(false);
        editorPane.setOpaque(false);

        // Agregar listener para hacer clickeable el enlace
        editorPane.addHyperlinkListener(event -> {
            if (event.getEventType() == javax.swing.event.HyperlinkEvent.EventType.ACTIVATED) {
                try {
                    Desktop.getDesktop().browse(event.getURL().toURI());
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(padre,
                            "No se pudo abrir el navegador.\nURL: " + event.getURL(),
                            "Error",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // Mostrar el diálogo
        JOptionPane.showMessageDialog(padre,
                editorPane,
                "Acerca de",
                JOptionPane.INFORMATION_MESSAGE);
    }
}
