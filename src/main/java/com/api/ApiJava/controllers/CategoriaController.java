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

import com.api.ApiJava.models.CategoriaModel;
import com.api.ApiJava.services.CategoriaService;

@RestController
@RequestMapping("/categoria")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    @GetMapping
    public ArrayList<CategoriaModel> getCategorias(){

        return this.categoriaService.getCategorias();

    }

    @PostMapping
    public CategoriaModel saveCategoria(@RequestBody CategoriaModel categoria){

        return this.categoriaService.saveCategoria(categoria);

    }

    @GetMapping(path = "/{id}")
    public Optional<CategoriaModel> getCategoriaById(@PathVariable("id") Long id){

        return categoriaService.getById(id);

    }

    @PutMapping(path = "{id}")
    public CategoriaModel updateCategoriaById(@RequestBody CategoriaModel request, @PathVariable Long id){

        return this.categoriaService.updateById(request, id);

    }

    @DeleteMapping(path = "/{id}")
    public String deleteCategoriaById(@PathVariable("id") Long id){

        boolean ok = this.categoriaService.deleteCategoria(id);

        if (ok) {
            
            return "La categoría con el id: " + id + "se eliminó correctamente";

        } else {
            
            return "Hubo un error al eliminar la categoría";

        }

    }

}
