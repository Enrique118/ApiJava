package com.api.ApiJava.repositores;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.ApiJava.models.AlumnoModel;

@Repository
public interface IAlumnoRepository extends JpaRepository<AlumnoModel, Long>{

    

}
