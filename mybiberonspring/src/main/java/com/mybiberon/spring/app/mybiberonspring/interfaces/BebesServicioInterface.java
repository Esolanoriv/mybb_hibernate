// BebesServicioInterface.java
package com.mybiberon.spring.app.mybiberonspring.interfaces;

import org.springframework.http.ResponseEntity;
import com.mybiberon.spring.app.mybiberonspring.modelos.BebeDto;

public interface BebesServicioInterface {

    public boolean comprobarUsuarios(BebeDto bebeModelo);
    public boolean existeBebe(BebeDto bebeModelo);
    public ResponseEntity<?> nuevoBebe(BebeDto bebeModelo);
}
