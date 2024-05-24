package com.api.ApiJava.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "Profesor")
public class ProfesorModel {

   
    @JsonProperty("Cedula")
    @Column(name = "Cedula", nullable = false, length = 100)
    private String cedula;

    @JsonProperty("Nombre")
    @Column(name = "Nombre", nullable = false, length = 100)
    private String nombre;

    @JsonProperty("Correo")
    @Column(name = "Correo", nullable = false, length = 100)
    private String correo;

    @JsonProperty("noTelefono")
    @Column(name = "noTelefono", length = 15)
    private String noTelefono;

    // Getters y setters
    

    public String getCedula() {
        return this.cedula;
    }

    public void setCedula(String cedula) {
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
