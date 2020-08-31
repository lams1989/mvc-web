package com.lesson.mvc.mvcweb.services;

import java.util.List;


import com.lesson.mvc.mvcweb.entities.CuantoGastas;
import com.lesson.mvc.mvcweb.entities.FilterDate;

public interface ICuantoGastasService {
	List<CuantoGastas> listAll();
	
	void save(CuantoGastas cuantogastas);
	
	CuantoGastas get(long id);
	
	void delete(long id);

	List<CuantoGastas> viewBetweenDates(FilterDate filterDate);
	
	



}
