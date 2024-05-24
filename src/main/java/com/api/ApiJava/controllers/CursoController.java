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

import com.api.ApiJava.models.CursoModel;
import com.api.ApiJava.services.CursoService;

@RestController
@RequestMapping("/curso")

public class CursoController {
   
    @Autowired
    private CursoService cursoService;

    @GetMapping
    public ArrayList<CursoModel> getCursos() {
        return this.cursoService.getCursos();
    }

    @PostMapping
    public CursoModel saveCurso(@RequestBody CursoModel curso) {
        return this.cursoService.saveCurso(curso);
    }

    @GetMapping(path = "/{id}")
    public Optional<CursoModel> getCursoById(@PathVariable("id") Long id) {
        return cursoService.getById(id);
    }

    @PutMapping(path = "/{id}")
    public CursoModel updateCursoById(@RequestBody CursoModel request, @PathVariable Long id) {
        return this.cursoService.updateById(request, id);
    }

    @DeleteMapping(path = "/{id}")
    public String deleteCursoById(@PathVariable("id") Long id) {
        boolean ok = this.cursoService.deleteCurso(id);
        if (ok) {
            return "El curso con el id: " + id + " se eliminó correctamente";
        } else {
            return "Hubo un error al eliminar el curso";
        }
    }
}
