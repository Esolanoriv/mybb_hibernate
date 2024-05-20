package com.mybiberon.spring.app.mybiberonspring.repositorios;

import org.springframework.data.repository.CrudRepository;
import com.mybiberon.spring.app.mybiberonspring.entidades.BebeEntidad;

import java.util.List;

public interface BebesRepositorio extends CrudRepository<BebeEntidad, Long> {
    List<BebeEntidad> findAll();
    BebeEntidad save(BebeEntidad bebe);
}
