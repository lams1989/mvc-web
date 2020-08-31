package com.lesson.mvc.mvcweb.services;


import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lesson.mvc.mvcweb.entities.CuantoGastas;
import com.lesson.mvc.mvcweb.entities.FilterDate;
import com.lesson.mvc.mvcweb.repositories.CuantoGastasRepository;

@Service
@Transactional
public class CuantoGastasService implements ICuantoGastasService {
	
	private final CuantoGastasRepository repo;
	
	public CuantoGastasService(CuantoGastasRepository repo) {
		this.repo=repo;
	}

	@Override
	public List<CuantoGastas> listAll() {
		return repo.findAll();
	}

	@Override
	public void save(CuantoGastas cuantogastas) {
		repo.save(cuantogastas);
	}

	@Override
	public CuantoGastas get(long id) {
		return repo.findById(id).get();
	}

	@Override
	public void delete(long id) {
		repo.deleteById(id);
	}

	@Override
	public List<CuantoGastas> viewBetweenDates(FilterDate filterDate) {
		return repo.listBetween(filterDate.getInitDate(), filterDate.getEndDate());
	}


	


	

}
