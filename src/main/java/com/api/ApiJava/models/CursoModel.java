package com.api.ApiJava.models;

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
    @Column(name = "ID")
    private Long id;

    @JsonProperty("Nombre")
    @Column(name = "Nombre", nullable = false, length = 100)
    private String nombre;

    @JsonProperty("Horario")
    @Column(name = "Horario", length = 50)
    private String horario;

    @JsonProperty("Cupo")
    @Column(name = "Cupo")
    private Integer cupo;

    @JsonProperty("Duracion")
    @Column(name = "Duracion", length = 50)
    private String duracion;

    @JsonProperty("idTemario")
    @Column(name = "idTemario")
    private Integer idTemario;

    @JsonProperty("idProfesor")
    @Column(name = "idProfesor", length = 20)
    private String idProfesor;

    @JsonProperty("Costo")
    @Column(name = "Costo", precision = 10, scale = 2)
    private Double costo;

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

    public Double getCosto() {
        return this.costo;
    }

    public void setCosto(Double costo) {
        this.costo = costo;
    }

    public Integer getIdCategoria() {
        return this.idCategoria;
    }

    public void setIdCategoria(Integer idCategoria) {
        this.idCategoria = idCategoria;
    }
}
