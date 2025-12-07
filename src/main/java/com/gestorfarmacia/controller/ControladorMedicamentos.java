package com.gestorfarmacia.controller;

import com.gestorfarmacia.model.Medicamento;
import com.gestorfarmacia.repository.GestorMedicamentos;
import com.gestorfarmacia.util.MedicamentoMapper;
import com.gestorfarmacia.util.MensajesUI;
import com.gestorfarmacia.util.ValidadorFormulario;
import com.gestorfarmacia.view.VentanaPrincipal;
import javax.swing.table.DefaultTableModel;

public class ControladorMedicamentos {
    private boolean modoEdicion = false;
    private String codigoOriginal = null;
    private VentanaPrincipal vista;
    private GestorMedicamentos gestor;

    // Clases helper
    private ValidadorFormulario validador;
    private MedicamentoMapper mapper;

    public ControladorMedicamentos(VentanaPrincipal vista, GestorMedicamentos gestor) {
        this.vista = vista;
        this.gestor = gestor;
        this.validador = new ValidadorFormulario(vista);
        this.mapper = new MedicamentoMapper(vista);

        inicializarEventos();
        cargarDatosEnTabla();
    }

    private void inicializarEventos() {
        // Evento del botón Agregar/Actualizar
        vista.getBtnAgregar().addActionListener(e -> {
            if (modoEdicion) {
                actualizarMedicamento();
            } else {
                agregarMedicamento();
            }
        });

        // Evento del botón Eliminar
        vista.getBtnEliminar().addActionListener(e -> eliminarMedicamento());

        // Evento del botón Editar
        vista.getBtnEditar().addActionListener(e -> cargarMedicamentoSeleccionado());

        // Evento del botón Limpiar
        vista.getBtnLimpiar().addActionListener(e -> cancelarEdicion());

        // Evento para guardar datos al cerrar la ventana
        vista.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent e) {
                gestor.guardarDatos();
            }
        });
    }

    private void agregarMedicamento() {
        if (!validador.validarCampos()) {
            return;
        }

        Medicamento medicamento = mapper.crearDesdeFformulario();

        if (gestor.agregarMedicamento(medicamento)) {
            MensajesUI.mostrarMedicamentoAgregado(vista);
            vista.limpiarCampos();
            cargarDatosEnTabla();
        } else {
            MensajesUI.mostrarCodigoDuplicado(vista);
        }
    }

    private void eliminarMedicamento() {
        int filaSeleccionada = vista.getTablaMedicamentos().getSelectedRow();

        if (filaSeleccionada == -1) {
            MensajesUI.mostrarDebeSeleccionarFila(vista);
            return;
        }

        String codigo = (String) vista.getModeloTabla().getValueAt(filaSeleccionada, 0);

        if (MensajesUI.confirmarEliminacion(vista, codigo)) {
            if (gestor.eliminarMedicamento(codigo)) {
                MensajesUI.mostrarMedicamentoEliminado(vista);
                cargarDatosEnTabla();
                vista.limpiarCampos();
            }
        }
    }

    private void cargarMedicamentoSeleccionado() {
        int filaSeleccionada = vista.getTablaMedicamentos().getSelectedRow();

        if (filaSeleccionada == -1) {
            MensajesUI.mostrarDebeSeleccionarFila(vista);
            return;
        }

        String codigo = (String) vista.getModeloTabla().getValueAt(filaSeleccionada, 0);
        Medicamento medicamento = gestor.buscarPorCodigo(codigo);

        if (medicamento != null) {
            activarModoEdicion(medicamento);
        }
    }

    private void activarModoEdicion(Medicamento medicamento) {
        modoEdicion = true;
        codigoOriginal = medicamento.getCodigo();
        vista.getBtnAgregar().setText("Actualizar");
        vista.getTxtCodigo().setEnabled(false);
        mapper.cargarEnFormulario(medicamento);
    }

    private void actualizarMedicamento() {
        if (!validador.validarCampos()) {
            return;
        }

        gestor.eliminarMedicamento(codigoOriginal);

        Medicamento medicamento = mapper.crearDesdeFformulario();

        if (gestor.agregarMedicamento(medicamento)) {
            MensajesUI.mostrarMedicamentoActualizado(vista);
            cancelarEdicion();
            cargarDatosEnTabla();
        } else {
            MensajesUI.mostrarErrorActualizacion(vista);
        }
    }

    private void cancelarEdicion() {
        modoEdicion = false;
        codigoOriginal = null;
        vista.getBtnAgregar().setText("Agregar");
        vista.getTxtCodigo().setEnabled(true);
        vista.limpiarCampos();
    }

    private void cargarDatosEnTabla() {
        DefaultTableModel modelo = vista.getModeloTabla();
        modelo.setRowCount(0);

        for (Medicamento med : gestor.obtenerTodos()) {
            Object[] fila = {
                    med.getCodigo(),
                    med.getNombreComercial(),
                    med.getLaboratorio(),
                    med.getTipoVenta(),
                    med.getFormato(),
                    med.isRequiereFrio() ? "Sí" : "No"
            };
            modelo.addRow(fila);
        }
    }
}
