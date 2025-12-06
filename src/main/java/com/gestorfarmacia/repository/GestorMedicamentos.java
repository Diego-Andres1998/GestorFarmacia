package com.gestorfarmacia.repository;
import com.gestorfarmacia.model.Medicamento;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
public class GestorMedicamentos {
    private List<Medicamento> medicamentos;
    private String rutaArchivo;
    public GestorMedicamentos(String rutaArchivo) {
        this.rutaArchivo = rutaArchivo;
        this.medicamentos = new ArrayList<>();
        cargarDatos();
    }
    public boolean agregarMedicamento(Medicamento medicamento) {
        // Verificar que no exista un medicamento con el mismo código
        if (buscarPorCodigo(medicamento.getCodigo()) != null) {
            return false;
        }
        medicamentos.add(medicamento);
        guardarDatos();
        return true;
    }
    public boolean eliminarMedicamento(String codigo) {
        Medicamento medicamento = buscarPorCodigo(codigo);
        if (medicamento != null) {
            medicamentos.remove(medicamento);
            guardarDatos();
            return true;
        }
        return false;
    }
    public Medicamento buscarPorCodigo(String codigo) {
        for (Medicamento med : medicamentos) {
            if (med.getCodigo().equals(codigo)) {
                return med;
            }
        }
        return null;
    }
    public List<Medicamento> obtenerTodos() {
        return new ArrayList<>(medicamentos);
    }
    public void guardarDatos() {
        try (ObjectOutputStream oos = new ObjectOutputStream(
                new FileOutputStream(rutaArchivo))) {
            oos.writeObject(medicamentos);
        } catch (IOException e) {
            System.err.println("Error al guardar datos: " + e.getMessage());
        }
    }
    @SuppressWarnings("unchecked")
    public void cargarDatos() {
        File archivo = new File(rutaArchivo);
        // Si el archivo no existe, inicializar con lista vacía
        if (!archivo.exists()) {
            medicamentos = new ArrayList<>();
            return;
        }
        try (ObjectInputStream ois = new ObjectInputStream(
                new FileInputStream(rutaArchivo))) {
            medicamentos = (List<Medicamento>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error al cargar datos: " + e.getMessage());
            medicamentos = new ArrayList<>();
        }
    }
    public int getCantidad() {
        return medicamentos.size();
    }
}
