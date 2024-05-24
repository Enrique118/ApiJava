package com.api.ApiJava.repositores;

import org.springframework.data.jpa.repository.JpaRepository;
import com.api.ApiJava.models.Temario;

public interface TemarioRepository extends JpaRepository<Temario, Long> {
}
