package com.mybiberon.spring.app.mybiberonspring.modelos;

import java.math.BigDecimal;
import java.sql.Time;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TomaDto {

    @JsonProperty("id_toma")
    private Long id;

    @JsonProperty("fecha_hora_toma")
    private LocalDateTime fecha_hora_toma;

    @JsonProperty("estado_bebe")
    private String estado_bebe;

    @JsonProperty("cantidad_leche_consumida")
    private BigDecimal cantidad_leche_consumida;

    @JsonProperty("duracion_toma")
    private Time duracion_toma;

    @JsonProperty("tipo_formula")
    private String tipo_formula;

    @JsonProperty("marca_formula")
    private String marca_formula;

    @JsonProperty("id_usuario")
    private Long id_usuario;

    // Constructor, getters y setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getFecha_hora_toma() {
        return fecha_hora_toma;
    }

    public void setFecha_hora_toma(LocalDateTime fecha_hora_toma) {
        this.fecha_hora_toma = fecha_hora_toma;
    }

    public String getEstado_bebe() {
        return estado_bebe;
    }

    public void setEstado_bebe(String estado_bebe) {
        this.estado_bebe = estado_bebe;
    }

    public BigDecimal getCantidad_leche_consumida() {
        return cantidad_leche_consumida;
    }

    public void setCantidad_leche_consumida(BigDecimal cantidad_leche_consumida) {
        this.cantidad_leche_consumida = cantidad_leche_consumida;
    }

    public Time getDuracion_toma() {
        return duracion_toma;
    }

    public void setDuracion_toma(Time duracion_toma) {
        this.duracion_toma = duracion_toma;
    }

    public String getTipo_formula() {
        return tipo_formula;
    }

    public void setTipo_formula(String tipo_formula) {
        this.tipo_formula = tipo_formula;
    }

    public String getMarca_formula() {
        return marca_formula;
    }

    public void setMarca_formula(String marca_formula) {
        this.marca_formula = marca_formula;
    }

    public Long getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(Long id_usuario) {
        this.id_usuario = id_usuario;
    }
}
