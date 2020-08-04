package com.lesson.mvc.mvcweb.services;

import java.util.List;

import com.lesson.mvc.mvcweb.entities.Recipe;

public interface IRecipeService {
	List<Recipe> listAll();

	void save(Recipe recipe);

	void delete(long id);

	Recipe get(long id);


}
