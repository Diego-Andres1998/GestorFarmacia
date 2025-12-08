package com.gestorfarmacia.controller;

import com.gestorfarmacia.model.Medicamento;
import com.gestorfarmacia.repository.GestorMedicamentos;
import com.gestorfarmacia.util.MedicamentoMapper;
import com.gestorfarmacia.util.MensajeFactory;
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
        vista.getBtnAgregar().addActionListener(evento -> {
            if (modoEdicion) {
                actualizarMedicamento();
            } else {
                agregarMedicamento();
            }
        });

        // Evento del botón Eliminar
        vista.getBtnEliminar().addActionListener(evento -> eliminarMedicamento());

        // Evento del botón Editar
        vista.getBtnEditar().addActionListener(evento -> cargarMedicamentoSeleccionado());

        // Evento del botón Limpiar
        vista.getBtnLimpiar().addActionListener(evento -> cancelarEdicion());

        // Evento para guardar datos al cerrar la ventana
        vista.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent evento) {
                gestor.guardarDatos();
            }
        });
    }

    private void agregarMedicamento() {
        if (!validador.validarCampos()) {
            return;
        }

        Medicamento medicamento = mapper.crearDesdeFormulario();

        if (gestor.agregarMedicamento(medicamento)) {
            MensajeFactory.mostrar(MensajeFactory.TipoMensaje.EXITO,
                    "Medicamento agregado exitosamente", vista);
            vista.limpiarCampos();
            cargarDatosEnTabla();
        } else {
            MensajeFactory.mostrar(MensajeFactory.TipoMensaje.ERROR,
                    "Ya existe un medicamento con ese código", vista);
        }
    }

    private void eliminarMedicamento() {
        int filaSeleccionada = vista.getTablaMedicamentos().getSelectedRow();

        if (filaSeleccionada == -1) {
            MensajeFactory.mostrar(MensajeFactory.TipoMensaje.ADVERTENCIA,
                    "Debe seleccionar un medicamento de la tabla", vista);
            return;
        }

        String codigo = (String) vista.getModeloTabla().getValueAt(filaSeleccionada, 0);

        if (MensajeFactory.confirmar("¿Está seguro de eliminar el medicamento con código: " + codigo + "?", vista)) {
            if (gestor.eliminarMedicamento(codigo)) {
                MensajeFactory.mostrar(MensajeFactory.TipoMensaje.EXITO,
                        "Medicamento eliminado exitosamente", vista);
                cargarDatosEnTabla();
                vista.limpiarCampos();
            }
        }
    }

    private void cargarMedicamentoSeleccionado() {
        int filaSeleccionada = vista.getTablaMedicamentos().getSelectedRow();

        if (filaSeleccionada == -1) {
            MensajeFactory.mostrar(MensajeFactory.TipoMensaje.ADVERTENCIA,
                    "Debe seleccionar un medicamento de la tabla", vista);
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
        Medicamento medicamento = mapper.crearDesdeFormulario();

        if (gestor.agregarMedicamento(medicamento)) {
            MensajeFactory.mostrar(MensajeFactory.TipoMensaje.EXITO,
                    "Medicamento actualizado exitosamente", vista);
            cancelarEdicion();
            cargarDatosEnTabla();
        } else {
            MensajeFactory.mostrar(MensajeFactory.TipoMensaje.ERROR,
                    "Error al actualizar medicamento", vista);
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

        for (Medicamento medicamento : gestor.obtenerTodos()) {
            Object[] fila = {
                    medicamento.getCodigo(),
                    medicamento.getNombreComercial(),
                    medicamento.getLaboratorio(),
                    medicamento.getTipoVenta(),
                    medicamento.getFormato(),
                    medicamento.isRequiereFrio() ? "Sí" : "No"
            };
            modelo.addRow(fila);
        }
    }
}
