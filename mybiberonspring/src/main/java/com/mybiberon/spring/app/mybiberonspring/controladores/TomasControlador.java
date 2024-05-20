package com.mybiberon.spring.app.mybiberonspring.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import com.mybiberon.spring.app.mybiberonspring.modelos.TomaDto;
import com.mybiberon.spring.app.mybiberonspring.servicios.TomasServicio;



public class TomasControlador {

    private final TomasServicio tomasServicio;

    @Autowired
    public TomasControlador(TomasServicio tomasServicio) {
        this.tomasServicio = tomasServicio;
    }

    @PostMapping("/registroTomas")
    @ResponseBody
    public ResponseEntity<?> nuevaToma(@RequestBody TomaDto tomaModelo) {
        return tomasServicio.nuevaToma(tomaModelo);
    }
    
}
