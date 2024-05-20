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

import com.api.ApiJava.models.AlumnoModel;
import com.api.ApiJava.services.AlumnoService;

@RestController
@RequestMapping("/alumno")
public class AlumnoController {

    @Autowired
    private AlumnoService alumnoService;

    @GetMapping
    public ArrayList<AlumnoModel> getAlumnos(){

        return this.alumnoService.getAlumnos();

    }

    @PostMapping
    public AlumnoModel saveAlumno(@RequestBody AlumnoModel alumno){

        return this.alumnoService.saveAlumno(alumno);

    }

    @GetMapping(path = "/{id}")
    public Optional<AlumnoModel> getAlumnoById(@PathVariable("id") Long id){

        return alumnoService.getById(id);

    }

    @PutMapping(path = "{id}")
    public AlumnoModel updateAlumnoById(@RequestBody AlumnoModel request, @PathVariable Long id){

        return this.alumnoService.updateById(request, id);

    }

    @DeleteMapping(path = "/{id}")
    public String deleteAlumnoById(@PathVariable("id") Long id){

        boolean ok = this.alumnoService.deleteAlumno(id);

        if (ok) {
            
            return "El alumno con el id: " + id + "se elimin'o correctamente";

        } else {
            
            return "Hubo un error al eliminar el alumno";

        }

    }

}
