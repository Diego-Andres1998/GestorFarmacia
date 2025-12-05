package com.gestorfarmacia.model;
import java.io.Serializable;
public class Medicamento implements Serializable {
    // Atributos del medicamento
    private String codigo;
    private String nombreComercial;
    private String laboratorio;
    private String tipoVenta; // Libre, Receta Simple, Receta Retenida
    private String formato; // Pastillas, Jarabe, Inyectable
    private boolean requiereFrio; // Indica si necesita refrigeración
    public Medicamento() {
    }
    public Medicamento(String codigo, String nombreComercial, String laboratorio,
            String tipoVenta, String formato, boolean requiereFrio) {
        this.codigo = codigo;
        this.nombreComercial = nombreComercial;
        this.laboratorio = laboratorio;
        this.tipoVenta = tipoVenta;
        this.formato = formato;
        this.requiereFrio = requiereFrio;
    }
    // Getters y Setters
    public String getCodigo() {
        return codigo;
    }
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    public String getNombreComercial() {
        return nombreComercial;
    }
    public void setNombreComercial(String nombreComercial) {
        this.nombreComercial = nombreComercial;
    }
    public String getLaboratorio() {
        return laboratorio;
    }
    public void setLaboratorio(String laboratorio) {
        this.laboratorio = laboratorio;
    }
    public String getTipoVenta() {
        return tipoVenta;
    }
    public void setTipoVenta(String tipoVenta) {
        this.tipoVenta = tipoVenta;
    }
    public String getFormato() {
        return formato;
    }
    public void setFormato(String formato) {
        this.formato = formato;
    }
    public boolean isRequiereFrio() {
        return requiereFrio;
    }
    public void setRequiereFrio(boolean requiereFrio) {
        this.requiereFrio = requiereFrio;
    }
    @Override
    public String toString() {
        return "Medicamento{" +
                "codigo='" + codigo + '\'' +
                ", nombreComercial='" + nombreComercial + '\'' +
                ", laboratorio='" + laboratorio + '\'' +
                ", tipoVenta='" + tipoVenta + '\'' +
                ", formato='" + formato + '\'' +
                ", requiereFrio=" + requiereFrio +
                '}';
    }
}
