package com.mybiberon.spring.app.mybiberonspring.interfaces;

import org.springframework.http.ResponseEntity;
import com.mybiberon.spring.app.mybiberonspring.modelos.TomaDto;

public interface TomasServicioInterface {

    public ResponseEntity<?> nuevaToma(TomaDto tomaModelo);
} 


