package com.lesson.mvc.mvcweb.services;

import com.lesson.mvc.mvcweb.repositories.RecipeRepository;
import com.lesson.mvc.mvcweb.entities.Recipe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

	@Service
	@Transactional
	public class RecipeService implements IRecipeService {

		private final RecipeRepository repo;

		@Autowired
		public RecipeService(RecipeRepository repo) {
			this.repo = repo;
		}

		@Override
		public List<Recipe> listAll() {
			return repo.findAll();
		}

		@Override
		public void save(Recipe recipe) {
			repo.save(recipe);
		}

		@Override
		public Recipe get(long id) {
			return repo.findById(id).get();
		}

		@Override
		public void delete(long id) {
			repo.deleteById(id);
		}

	
	}
