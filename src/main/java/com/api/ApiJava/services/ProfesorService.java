package com.api.ApiJava.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.ApiJava.models.ProfesorModel;
import com.api.ApiJava.repositores.IProfesorRepository;

@Service
public class ProfesorService {

    @Autowired
    IProfesorRepository ProfesorRepository;

    public ArrayList<ProfesorModel> getProfesor(){

        return (ArrayList<ProfesorModel>) ProfesorRepository.findAll();

    }

    public ProfesorModel saveProfesor(ProfesorModel profesor){

        return ProfesorRepository.save(profesor);

    }

    public Optional<ProfesorModel> getById(Long cedula){

        return ProfesorRepository.findById(cedula);

    }

    public ProfesorModel updateById(ProfesorModel request, Long cedula){

        ProfesorModel profesor = ProfesorRepository.findById(cedula).get();

        profesor.setCedula(request.getCedula());
        profesor.setNombre(request.getNombre());
        profesor.setCorreo(request.getCorreo());
        profesor.setNoTelefono(request.getNoTelefono());
        ProfesorRepository.save(profesor);

        return profesor;

    }

    public Boolean deleteProfesor(Long cedula){

        try {
            
            ProfesorRepository.deleteById(cedula);
            return true;

        } catch (Exception e) {

            return false;
            
        }

    }


}
