package com.mybiberon.spring.app.mybiberonspring.controladores;

import com.mybiberon.spring.app.mybiberonspring.entidades.BebeEntidad;
import com.mybiberon.spring.app.mybiberonspring.modelos.BebeDto;
import com.mybiberon.spring.app.mybiberonspring.servicios.BebesServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BebesControlador {

    private final BebesServicio bebesServicio;

    @Autowired
    public BebesControlador(BebesServicio bebesServicio) {
        this.bebesServicio = bebesServicio;
    }

    @PostMapping("/existeBebe")
    @ResponseBody
    public boolean existeBebe(@RequestBody BebeDto bebeModelo) {
        return bebesServicio.existeBebe(bebeModelo);
    }

    @PostMapping("/nuevoBebe")
    @ResponseBody
    public ResponseEntity<?> nuevoBebe(@RequestBody BebeDto bebeModelo) {
        return bebesServicio.nuevoBebe(bebeModelo);
    }

  

    // @GetMapping("/registrosDeAlimentacion")
    // public String registrosDeAlimentacion() {
    //     return "registrosDeAlimentacion";
    // }
}
