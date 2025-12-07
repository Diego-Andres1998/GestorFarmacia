package com.gestorfarmacia;

import com.gestorfarmacia.controller.ControladorMedicamentos;
import com.gestorfarmacia.repository.GestorMedicamentos;
import com.gestorfarmacia.view.VentanaPrincipal;

public class Main {
    public static void main(String[] args) {
        // Ejecutar la interfaz en el hilo de eventos de Swing
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                // Crear la vista
                VentanaPrincipal ventana = new VentanaPrincipal();
                // Crear el gestor de datos (modelo)
                GestorMedicamentos gestor = new GestorMedicamentos("medicamentos.dat");
                // Crear el controlador y conectar vista con modelo
                ControladorMedicamentos controlador = new ControladorMedicamentos(ventana, gestor);
                // Mostrar la ventana
                ventana.setVisible(true);
            }
        });
    }
}
