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
@RequestMapping("/profesor")
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

    @GetMapping(path = "/{cedula}")
    public Optional<ProfesorModel> getProfesorById(@PathVariable("cedula") Long cedula){

        return this.profesorService.getById(cedula);

    }

    @PutMapping(path = "{cedula}")
    public ProfesorModel updateProfesorById(@RequestBody ProfesorModel request, @PathVariable Long cedula){

        return this.profesorService.updateById(request, cedula);

    }

    @DeleteMapping(path = "/{cedula}")
    public String deleteProfesorById(@PathVariable("cedula") Long cedula){

        boolean ok = this.profesorService.deleteProfesor(cedula);

        if (ok) {
            
            return "El profesor con el id: " + cedula + "se elimin'o correctamente";

        } else {
            
            return "Hubo un error al eliminar el profesor";

        }

    }

}