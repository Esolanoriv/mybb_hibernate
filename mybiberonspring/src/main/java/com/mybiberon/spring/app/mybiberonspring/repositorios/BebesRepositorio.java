package com.mybiberon.spring.app.mybiberonspring.repositorios;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import com.mybiberon.spring.app.mybiberonspring.entidades.*;

public interface BebesRepositorio extends CrudRepository<BebeEntidad, Long>{
    List<BebeEntidad> findAll();
}
