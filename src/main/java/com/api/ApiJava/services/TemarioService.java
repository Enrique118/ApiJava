package com.api.ApiJava.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.ApiJava.models.TemarioModel;
import com.api.ApiJava.repositores.ITemarioRepository;

@Service
public class TemarioService {

    @Autowired
    ITemarioRepository temarioRepository;

    public ArrayList<TemarioModel> getAllTemarios() {
        return (ArrayList<TemarioModel>) temarioRepository.findAll();
    }

    public TemarioModel saveTemario(TemarioModel temario) {
        return temarioRepository.save(temario);
    }

    public Optional<TemarioModel> getTemarioById(Long id) {
        return temarioRepository.findById(id);
    }

    public TemarioModel updateTemarioById(TemarioModel request, Long id) {
        TemarioModel temario = temarioRepository.findById(id).orElse(null);

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
