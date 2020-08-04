package com.lesson.mvc.mvcweb.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lesson.mvc.mvcweb.entities.Recipe;

public interface RecipeRepository extends JpaRepository<Recipe, Long>{

}
