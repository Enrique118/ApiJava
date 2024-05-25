package com.api.ApiJava.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.ApiJava.models.CategoriaModel;
import com.api.ApiJava.repositores.ICategoriaRepository;

@Service
public class CategoriaService {

    @Autowired
    ICategoriaRepository categoriaRepository;

    public ArrayList<CategoriaModel> getCategorias(){

        return (ArrayList<CategoriaModel>) categoriaRepository.findAll();

    }

    public CategoriaModel saveCategoria(CategoriaModel categoria){

        return categoriaRepository.save(categoria);

    }

    public Optional<CategoriaModel> getById(Long id){

        return categoriaRepository.findById(id);

    }

    public CategoriaModel updateById(CategoriaModel request, Long id){

        CategoriaModel categoria = categoriaRepository.findById(id).get();

        categoria.setNombreCategoria(request.getNombreCategoria());
        categoriaRepository.save(categoria);

        return categoria;

    }

    public Boolean deleteCategoria(Long id){

        try {
            
            categoriaRepository.deleteById(id);
            return true;

        } catch (Exception e) {

            return false;
            
        }

    }


}
