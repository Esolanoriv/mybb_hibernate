package com.mybiberon.spring.app.mybiberonspring.servicios;

import com.mybiberon.spring.app.mybiberonspring.interfaces.BebesServicioInterface;
import com.mybiberon.spring.app.mybiberonspring.modelos.BebeDto;
import com.mybiberon.spring.app.mybiberonspring.repositorios.BebesRepositorio;
import com.mybiberon.spring.app.mybiberonspring.entidades.BebeEntidad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class BebesServicio implements BebesServicioInterface {

    private final BebesRepositorio bebesRepositorio;

    @Autowired
    public BebesServicio(BebesRepositorio bebesRepositorio) {
        this.bebesRepositorio = bebesRepositorio;
    }

    @Override
    public boolean existeBebe(BebeDto bebeModelo) {
        List<BebeEntidad> listaBebes = bebesRepositorio.findAll();
        return listaBebes.stream()
                .anyMatch(bebe -> bebe.getNombre_usuario().equals(bebeModelo.getNombre_usuario()) &&
                                  bebe.getContrasena_usuario().equals(bebeModelo.getContrasena_usuario()));
    }

    @Override
    public boolean comprobarUsuarios(BebeDto bebeModelo) {
        List<BebeEntidad> listaBebes = bebesRepositorio.findAll();
        listaBebes.removeIf(bebe -> bebe.getNombre_usuario() == null);

        return listaBebes.stream().anyMatch(bebe -> bebe.getNombre_usuario().equals(bebeModelo.getNombre_usuario()));
    }

@Override
public ResponseEntity<?> nuevoBebe(@RequestBody BebeDto bebeModelo) {
    try {
        boolean existeUsuario = comprobarUsuarios(bebeModelo);
        if (existeUsuario) {
            String sms = "El usuario ya existe";
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(sms);
        } else {
            BebeEntidad bebeEntidad = new BebeEntidad();
            // asignar valores a bebeEntidad
            bebeEntidad.setNombre_usuario(bebeModelo.getNombre_usuario());
            bebeEntidad.setContrasena_usuario(bebeModelo.getContrasena_usuario());
            bebeEntidad.setnombre_bebe(bebeModelo.getnombre_bebe());
            bebeEntidad.setFecha_nacimiento_bebe(bebeModelo.getFecha_nacimiento_bebe());
            bebeEntidad.setGenero_bebe(bebeModelo.getGenero_bebe());
            bebeEntidad.setPeso_inicial_bebe(bebeModelo.getPeso_inicial_bebe());
            bebeEntidad.setAltura_inicial_bebe(bebeModelo.getAltura_inicial_bebe());
            bebeEntidad.setSemana_gestacion_bebe(bebeModelo.getSemana_gestacion_bebe());
            bebeEntidad.setObservaciones_bebe(bebeModelo.getObservaciones_bebe());
            bebesRepositorio.save(bebeEntidad);
            String sms = "El usuario ha sido registrado correctamente";
            return ResponseEntity.ok(sms);
        }
    } catch (Exception e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al procesar la solicitud");
    }
}
}