package com.api.ApiJava.repositores;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.ApiJava.models.ProfesorModel;


@Repository
public interface IProfesorRepository extends JpaRepository<ProfesorModel, Long> {


}
