package com.api.ApiJava.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "profesor")
public class ProfesorModel {

    @Id
    @JsonProperty("cedula")
    @Column(name = "cedula", nullable = false, length = 100)
    private int cedula;

    @JsonProperty("nombre")
    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;

    @JsonProperty("correo")
    @Column(name = "correo", nullable = false, length = 100)
    private String correo;

    @JsonProperty("telefono")
    @Column(name = "telefono", length = 15)
    private String noTelefono;

    // Getters y setters
    

    public int getCedula() {
        return this.cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return this.correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }


    public String getNoTelefono() {
        return this.noTelefono;
    }

    public void setNoTelefono(String noTelefono) {
        this.noTelefono = noTelefono;
    }
}
