package com.mybiberon.spring.app.mybiberonspring.entidades;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name="BEBES")
public class BebeEntidad {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_usuario;
    
    private String nombre_usuario;
    private String contrasena_usuario;
    private String nombre_bebe;
    private LocalDate fecha_nacimiento_bebe;
    private String genero_bebe;
    private BigDecimal peso_inicial_bebe;
    private BigDecimal altura_inicial_bebe;
    private Integer semana_gestacion_bebe;
    private String observaciones_bebe;

    // Constructor
    public BebeEntidad() {
    }

    public Long getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(Long id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getNombre_usuario() {
        return nombre_usuario;
    }

    public void setNombre_usuario(String nombre_usuario) {
        this.nombre_usuario = nombre_usuario;
    }

    public String getContrasena_usuario() {
        return contrasena_usuario;
    }

    public void setContrasena_usuario(String contrasena_usuario) {
        this.contrasena_usuario = contrasena_usuario;
    }

    public String getnombre_bebe() {
        return nombre_bebe;
    }

    public void setnombre_bebe(String nombre_bebe) {
        this.nombre_bebe = nombre_bebe;
    }

    public LocalDate getFecha_nacimiento_bebe() {
        return fecha_nacimiento_bebe;
    }

    public void setFecha_nacimiento_bebe(LocalDate fecha_nacimiento_bebe) {
        this.fecha_nacimiento_bebe = fecha_nacimiento_bebe;
    }

    public String getGenero_bebe() {
        return genero_bebe;
    }

    public void setGenero_bebe(String genero_bebe) {
        this.genero_bebe = genero_bebe;
    }

    public BigDecimal getPeso_inicial_bebe() {
        return peso_inicial_bebe;
    }

    public void setPeso_inicial_bebe(BigDecimal peso_inicial_bebe) {
        this.peso_inicial_bebe = peso_inicial_bebe;
    }

    public BigDecimal getAltura_inicial_bebe() {
        return altura_inicial_bebe;
    }

    public void setAltura_inicial_bebe(BigDecimal altura_inicial_bebe) {
        this.altura_inicial_bebe = altura_inicial_bebe;
    }

    public Integer getSemana_gestacion_bebe() {
        return semana_gestacion_bebe;
    }

    public void setSemana_gestacion_bebe(Integer semana_gestacion_bebe) {
        this.semana_gestacion_bebe = semana_gestacion_bebe;
    }

    public String getObservaciones_bebe() {
        return observaciones_bebe;
    }

    public void setObservaciones_bebe(String observaciones_bebe) {
        this.observaciones_bebe = observaciones_bebe;
    }   
}
