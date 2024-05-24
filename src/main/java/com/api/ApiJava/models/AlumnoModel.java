package com.api.ApiJava.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "alumno")
public class AlumnoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @JsonProperty("Nombre")
    @Column(name = "Nombre", nullable = false, length = 100)
    private String nombre;

    @JsonProperty("Correo")
    @Column(name = "Correo", nullable = false, length = 100)
    private String correo;

    @JsonProperty("idPago")
    @Column(name = "idPago")
    private Long idPago;

    @JsonProperty("noTelefono")
    @Column(name = "noTelefono", length = 15)
    private String noTelefono;

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

    public String getCorreo() {
        return this.correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public Long getIdPago() {
        return this.idPago;
    }

    public void setIdPago(Long idPago) {
        this.idPago = idPago;
    }

    public String getNoTelefono() {
        return this.noTelefono;
    }

    public void setNoTelefono(String noTelefono) {
        this.noTelefono = noTelefono;
    }
}
