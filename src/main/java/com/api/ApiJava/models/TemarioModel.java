package com.api.ApiJava.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;

@Entity
@Table(name = "temario")
public class TemarioModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "anio", nullable = false)
    private int anio;

    @Column(name = "estatus", nullable = false, length = 50)
    private String estatus;

    @Lob
    @Column(name = "temas", nullable = false)
    private String temas;

    @Lob
    @Column(name = "objetivo", nullable = false)
    private String objetivo;

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getAnio() {
        return this.anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public String getEstatus() {
        return this.estatus;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }

    public String getTemas() {
        return this.temas;
    }

    public void setTemas(String temas) {
        this.temas = temas;
    }

    public String getObjetivo() {
        return this.objetivo;
    }

    public void setObjetivo(String objetivo) {
        this.objetivo = objetivo;
    }
}
