package com.api.ApiJava.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.ApiJava.models.AlumnoModel;
import com.api.ApiJava.repositores.IAlumnoRepository;

@Service
public class AlumnoService {

    @Autowired
    IAlumnoRepository alumnoRepository;

    public ArrayList<AlumnoModel> getAlumnos(){

        return (ArrayList<AlumnoModel>) alumnoRepository.findAll();

    }

    public AlumnoModel saveAlumno(AlumnoModel alumno){

        return alumnoRepository.save(alumno);

    }

    public Optional<AlumnoModel> getById(Long id){

        return alumnoRepository.findById(id);

    }

    public AlumnoModel updateById(AlumnoModel request, Long id){

        AlumnoModel alumno = alumnoRepository.findById(id).get();

        alumno.setNombre(request.getNombre());
        alumno.setCorreo(request.getCorreo());
        alumno.setIdPago(request.getIdPago());
        alumno.setNoTelefono(request.getNoTelefono());
        alumnoRepository.save(alumno);

        return alumno;

    }

    public Boolean deleteAlumno(Long id){

        try {
            
            alumnoRepository.deleteById(id);
            return true;

        } catch (Exception e) {

            return false;
            
        }

    }


}
