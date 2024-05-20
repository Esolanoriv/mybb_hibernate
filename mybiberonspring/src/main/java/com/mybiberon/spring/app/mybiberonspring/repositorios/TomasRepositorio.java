package com.mybiberon.spring.app.mybiberonspring.repositorios;
import org.springframework.data.repository.CrudRepository;

import com.mybiberon.spring.app.mybiberonspring.entidades.TomaEntidad;


public interface TomasRepositorio extends CrudRepository<TomaEntidad, Long> {
    
    TomaEntidad save(TomaEntidad toma);
}






