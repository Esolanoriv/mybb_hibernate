package com.mybiberon.spring.app.mybiberonspring.servicios;

import com.mybiberon.spring.app.mybiberonspring.interfaces.BebesServicioInterface;
import com.mybiberon.spring.app.mybiberonspring.modelos.BebeModelo;
import com.mybiberon.spring.app.mybiberonspring.repositorios.BebesRepositorio;
import com.mybiberon.spring.app.mybiberonspring.entidades.BebeEntidad;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BebesServicio implements BebesServicioInterface {

    @Autowired
    private final BebesRepositorio bebesRepositorio;
    
    public BebesServicio(BebesRepositorio bebesRepositorio) {
        this.bebesRepositorio = bebesRepositorio;
    }

    public boolean existeBebe(BebeModelo bebeModelo) {
        List<BebeEntidad> listaBebes = bebesRepositorio.findAll();
        
        for (BebeEntidad bebe : listaBebes) {
            if (bebe.getNombre_usuario().equals(bebeModelo.getNombre_usuario()) &&
                bebe.getContrasena_usuario().equals(bebeModelo.getContrasena_usuario())) {
                return true;
            }
        }
        
        return false;
    }

    public List<BebeEntidad> obtenerTodosLosBebes(){
       return bebesRepositorio.findAll();
    }

}
