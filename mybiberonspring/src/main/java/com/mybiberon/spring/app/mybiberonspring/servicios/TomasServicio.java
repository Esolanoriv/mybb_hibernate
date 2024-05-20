package com.mybiberon.spring.app.mybiberonspring.servicios;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import com.mybiberon.spring.app.mybiberonspring.interfaces.TomasServicioInterface;
import com.mybiberon.spring.app.mybiberonspring.modelos.TomaDto;

public class TomasServicio implements TomasServicioInterface {

 

    @Override
    public ResponseEntity<?> nuevaToma(@RequestBody TomaDto tomaModelo) {
        // TODO Auto-generated method stub
        String sms = "El usuario ha sido registrado correctamente";
            return ResponseEntity.ok(sms);
    }
    
}
