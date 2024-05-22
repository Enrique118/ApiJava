package com.api.ApiJava.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.ApiJava.models.CursoModel;
import com.api.ApiJava.repositores.ICursoRepository;

@Service
public class CursoService {

		@Autowired
		ICursoRepository cursoRepository;
	
		public ArrayList<CursoModel> getCursos() {
			return (ArrayList<CursoModel>) cursoRepository.findAll();
		}
	
		public CursoModel saveCurso(CursoModel curso) {
			return cursoRepository.save(curso);
		}
	
		public Optional<CursoModel> getById(Long id) {
			return cursoRepository.findById(id);
		}
	
		public CursoModel updateById(CursoModel request, Long id) {
			return cursoRepository.findById(id).map(curso -> {
				curso.setNombre(request.getNombre());
				curso.setHorario(request.getHorario());
				curso.setCupo(request.getCupo());
				curso.setDuracion(request.getDuracion());
				curso.setIdTemario(request.getIdTemario());
				curso.setIdProfesor(request.getIdProfesor());
				curso.setCosto(request.getCosto());
				curso.setIdCategoria(request.getIdCategoria());
				return cursoRepository.save(curso);
			}).orElseGet(() -> {
				request.setId(id);
				return cursoRepository.save(request);
			});
		}
	
		public boolean deleteCurso(Long id) {
			try {
				cursoRepository.deleteById(id);
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}