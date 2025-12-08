package com.gestorfarmacia.util;

public interface Mapper<EntidadModelo> {

    EntidadModelo crearDesdeFormulario();

    void cargarEnFormulario(EntidadModelo entidad);
}
