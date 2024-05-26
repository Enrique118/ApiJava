package com.api.ApiJava.repositores;

import org.springframework.data.jpa.repository.JpaRepository;
import com.api.ApiJava.models.TemarioModel;

public interface ITemarioRepository extends JpaRepository<TemarioModel, Long> {
}
