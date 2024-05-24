package com.api.ApiJava.repositores;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.ApiJava.models.CursoModel;


@Repository
public interface ICursoRepository extends JpaRepository<CursoModel, Long> {


}



