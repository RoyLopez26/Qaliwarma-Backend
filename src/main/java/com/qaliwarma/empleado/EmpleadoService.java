package com.qaliwarma.empleado;

import java.util.Map;

public interface EmpleadoService {

    Map<String, String> loginPlataforma(String usuario, String password);
}
