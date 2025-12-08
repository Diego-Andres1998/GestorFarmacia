package com.gestorfarmacia.repository;

import java.util.List;

public interface Repositorio<EntidadModelo, TipoIdentificador> {

    boolean agregar(EntidadModelo entidad);

    boolean eliminar(TipoIdentificador id);

    EntidadModelo buscarPorId(TipoIdentificador id);

    List<EntidadModelo> obtenerTodos();

    int getCantidad();
}
