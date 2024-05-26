package com.api.ApiJava.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.ApiJava.models.Temario;
import com.api.ApiJava.repositores.TemarioRepository;

@Service
public class TemarioService {

    @Autowired
    TemarioRepository temarioRepository;

    public ArrayList<Temario> getAllTemarios() {
        return (ArrayList<Temario>) temarioRepository.findAll();
    }

    public Temario saveTemario(Temario temario) {
        return temarioRepository.save(temario);
    }

    public Optional<Temario> getTemarioById(Long id) {
        return temarioRepository.findById(id);
    }

    public Temario updateTemarioById(Temario request, Long id) {
        Temario temario = temarioRepository.findById(id).orElse(null);

        if (temario != null) {
            temario.setAnio(request.getAnio());
            temario.setEstatus(request.getEstatus());
            temario.setTemas(request.getTemas());
            temario.setObjetivo(request.getObjetivo());
            temarioRepository.save(temario);
        }

        return temario;
    }

    public Boolean deleteTemario(Long id) {
        try {
            temarioRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
