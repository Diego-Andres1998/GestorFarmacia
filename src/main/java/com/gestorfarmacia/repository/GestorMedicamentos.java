package com.gestorfarmacia.repository;

import com.gestorfarmacia.model.Medicamento;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class GestorMedicamentos implements Repositorio<Medicamento, String> {
    private List<Medicamento> medicamentos;
    private final String rutaArchivo;

    public GestorMedicamentos(String rutaArchivo) {
        this.rutaArchivo = rutaArchivo;
        this.medicamentos = new ArrayList<>();
        cargarDatos();
    }

    @Override
    public boolean agregar(Medicamento medicamento) {
        if (buscarPorId(medicamento.getCodigo()) != null) {
            return false;
        }
        medicamentos.add(medicamento);
        guardarDatos();
        return true;
    }

    @Override
    public boolean eliminar(String id) {
        Medicamento medicamento = buscarPorId(id);
        if (medicamento != null) {
            medicamentos.remove(medicamento);
            guardarDatos();
            return true;
        }
        return false;
    }

    @Override
    public Medicamento buscarPorId(String id) {
        return medicamentos.stream()
                .filter(medicamento -> medicamento.getCodigo().equals(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Medicamento> obtenerTodos() {
        return new ArrayList<>(medicamentos);
    }

    @Override
    public int getCantidad() {
        return medicamentos.size();
    }

    // Métodos de compatibilidad con código existente
    public boolean agregarMedicamento(Medicamento medicamento) {
        return agregar(medicamento);
    }

    public boolean eliminarMedicamento(String codigo) {
        return eliminar(codigo);
    }

    public Medicamento buscarPorCodigo(String codigo) {
        return buscarPorId(codigo);
    }

    public void guardarDatos() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(rutaArchivo))) {
            oos.writeObject(medicamentos);
        } catch (IOException excepcion) {
            System.err.println("Error al guardar datos: " + excepcion.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    private void cargarDatos() {
        File archivo = new File(rutaArchivo);
        if (!archivo.exists()) {
            medicamentos = new ArrayList<>();
            return;
        }
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(rutaArchivo))) {
            medicamentos = (List<Medicamento>) ois.readObject();
        } catch (IOException | ClassNotFoundException excepcion) {
            System.err.println("Error al cargar datos: " + excepcion.getMessage());
            medicamentos = new ArrayList<>();
        }
    }
}
