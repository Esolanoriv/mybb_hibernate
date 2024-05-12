// BebesServicioInterface.java
package com.mybiberon.spring.app.mybiberonspring.interfaces;
import java.util.List;

import com.mybiberon.spring.app.mybiberonspring.entidades.BebeEntidad;
import com.mybiberon.spring.app.mybiberonspring.modelos.BebeModelo;

public interface BebesServicioInterface {

    List<BebeEntidad> obtenerTodosLosBebes();
    boolean existeBebe(BebeModelo bebeModelo);
}
