package com.api.ApiJava.repositores;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.ApiJava.models.CategoriaModel;

@Repository
public interface ICategoriaRepository extends JpaRepository<CategoriaModel, Long>{

    

}