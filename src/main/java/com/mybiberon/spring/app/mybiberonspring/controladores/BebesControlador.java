package com.mybiberon.spring.app.mybiberonspring.controladores;

import com.mybiberon.spring.app.mybiberonspring.entidades.BebeEntidad;
import com.mybiberon.spring.app.mybiberonspring.modelos.BebeModelo;
import com.mybiberon.spring.app.mybiberonspring.servicios.BebesServicio;

import ch.qos.logback.core.model.Model;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BebesControlador {

    private final BebesServicio bebesServicio;

    public BebesControlador(BebesServicio bebesServicio) {
        this.bebesServicio = bebesServicio;
    }

    @PostMapping("/existeBebe")
    @ResponseBody
    public boolean existeBebe(@RequestBody BebeModelo bebeModelo) {
        boolean existe = bebesServicio.existeBebe(bebeModelo);
        return existe;
    }

    @PostMapping("/bebes")
    @ResponseBody
    public List<BebeEntidad> obtenerTodosLosBebes() {
        List<BebeEntidad> listaBebes = bebesServicio.obtenerTodosLosBebes();
        return listaBebes;
    }

    @GetMapping("/registrosDeAlimentacion")
    public String registrosDeAlimentacion(Model model) {

        return "registrosDeAlimentacion";
    }


}
