package com.api.ApiJava.models;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "curso")
public class CursoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @JsonProperty("nombre")
    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;

    @JsonProperty("horario")
    @Column(name = "horario", length = 50)
    private String horario;

    @JsonProperty("cupo")
    @Column(name = "cupo")
    private int cupo;

    @JsonProperty("duracion")
    @Column(name = "duracion", length = 50)
    private String duracion;

    @JsonProperty("idTemario")
    @Column(name = "idTemario")
    private int idTemario;

    @JsonProperty("idProfesor")
    @Column(name = "idProfesor", length = 20)
    private String idProfesor;

    @JsonProperty("costo")
    @Column(name = "costo", precision = 10, scale = 2)
    private BigDecimal costo;

    @JsonProperty("idCategoria")
    @Column(name = "idCategoria")
    private Integer idCategoria;

    // Getters y setters

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getHorario() {
        return this.horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public Integer getCupo() {
        return this.cupo;
    }

    public void setCupo(Integer cupo) {
        this.cupo = cupo;
    }

    public String getDuracion() {
        return this.duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    public Integer getIdTemario() {
        return this.idTemario;
    }

    public void setIdTemario(Integer idTemario) {
        this.idTemario = idTemario;
    }

    public String getIdProfesor() {
        return this.idProfesor;
    }

    public void setIdProfesor(String idProfesor) {
        this.idProfesor = idProfesor;
    }

    public BigDecimal getCosto() {
        return this.costo;
    }

    public void setCosto(BigDecimal costo) {
        this.costo = costo;
    }

    public Integer getIdCategoria() {
        return this.idCategoria;
    }

    public void setIdCategoria(Integer idCategoria) {
        this.idCategoria = idCategoria;
    }
}
