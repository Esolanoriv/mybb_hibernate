package com.mybiberon.spring.app.mybiberonspring.entidades;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;
import java.math.BigDecimal;
import java.sql.Time;
import java.time.LocalDateTime;

import jakarta.persistence.ManyToOne;

@Entity
@Table(name = "tomas")
public class TomaEntidad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_toma")
    private Long id;

    @Column(name = "fecha_hora_toma")
    private LocalDateTime fechaHoraToma;

    @Column(name = "estado_bebe")
    private String estadoBebe;

    @Column(name = "cantidad_leche_consumida")
    private BigDecimal cantidadLecheConsumida;

    @Column(name = "duracion_toma")
    private Time duracionToma;

    @Column(name = "tipo_formula")
    private String tipoFormula;

    @Column(name = "marca_formula")
    private String marcaFormula;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private BebeEntidad bebeEntidad;

    // Constructor, getters y setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getFechaHoraToma() {
        return fechaHoraToma;
    }

    public void setFechaHoraToma(LocalDateTime fechaHoraToma) {
        this.fechaHoraToma = fechaHoraToma;
    }

    public String getEstadoBebe() {
        return estadoBebe;
    }

    public void setEstadoBebe(String estadoBebe) {
        this.estadoBebe = estadoBebe;
    }

    public BigDecimal getCantidadLecheConsumida() {
        return cantidadLecheConsumida;
    }

    public void setCantidadLecheConsumida(BigDecimal cantidadLecheConsumida) {
        this.cantidadLecheConsumida = cantidadLecheConsumida;
    }

    public Time getDuracionToma() {
        return duracionToma;
    }

    public void setDuracionToma(Time duracionToma) {
        this.duracionToma = duracionToma;
    }

    public String getTipoFormula() {
        return tipoFormula;
    }

    public void setTipoFormula(String tipoFormula) {
        this.tipoFormula = tipoFormula;
    }

    public String getMarcaFormula() {
        return marcaFormula;
    }

    public void setMarcaFormula(String marcaFormula) {
        this.marcaFormula = marcaFormula;
    }

    public BebeEntidad getBebe() {
        return bebeEntidad;
    }

    public void setBebe(BebeEntidad bebeEntidad) {
        this.bebeEntidad = bebeEntidad;
    }
}

