package com.api.ApiJava.controllers;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.ApiJava.models.ProfesorModel;
import com.api.ApiJava.services.ProfesorService;

@RestController
@RequestMapping("/Profesor")
public class ProfesorController {

    @Autowired
    private ProfesorService profesorService;


    @GetMapping
    public ArrayList<ProfesorModel> getProfesor(){

        return this.profesorService.getProfesor();

    }

    @PostMapping
    public ProfesorModel saveProfesor(@RequestBody ProfesorModel profesor){

        return this.profesorService.saveProfesor(profesor);

    }

    @GetMapping(path = "/{id}")
    public Optional<ProfesorModel> getAlumnoById(@PathVariable("id") Long id){

        return this.profesorService.getById(id);

    }

    @PutMapping(path = "{id}")
    public ProfesorModel updateProfesorById(@RequestBody ProfesorModel request, @PathVariable Long id){

        return this.profesorService.updateById(request, id);

    }

    @DeleteMapping(path = "/{id}")
    public String deleteProfesorById(@PathVariable("id") Long id){

        boolean ok = this.profesorService.deleteProfesor(id);

        if (ok) {
            
            return "El profesor con el id: " + id + "se elimin'o correctamente";

        } else {
            
            return "Hubo un error al eliminar el profesor";

        }

    }

}