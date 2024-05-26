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

import com.api.ApiJava.models.TemarioModel;
import com.api.ApiJava.services.TemarioService;

@RestController
@RequestMapping("/temario")
public class TemarioController {

    @Autowired
    private TemarioService temarioService;

    @GetMapping
    public ArrayList<TemarioModel> getAllTemarios() {
        return this.temarioService.getAllTemarios();
    }

    @PostMapping
    public TemarioModel saveTemario(@RequestBody TemarioModel temario) {
        return this.temarioService.saveTemario(temario);
    }

    @GetMapping(path = "/{id}")
    public Optional<TemarioModel> getTemarioById(@PathVariable("id") Long id) {
        return this.temarioService.getTemarioById(id);
    }

    @PutMapping(path = "/{id}")
    public TemarioModel updateTemarioById(@RequestBody TemarioModel request, @PathVariable("id") Long id) {
        return this.temarioService.updateTemarioById(request, id);
    }

    @DeleteMapping(path = "/{id}")
    public String deleteTemarioById(@PathVariable("id") Long id) {
        boolean ok = this.temarioService.deleteTemario(id);
        if (ok) {
            return "El temario con el id: " + id + " se eliminó correctamente";
        } else {
            return "Hubo un error al eliminar el temario";
        }
    }
}
