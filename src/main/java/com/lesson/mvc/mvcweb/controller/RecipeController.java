package com.lesson.mvc.mvcweb.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.lesson.mvc.mvcweb.entities.Recipe;
import com.lesson.mvc.mvcweb.services.IRecipeService;

@Controller
@RequestMapping("/recipes")
public class RecipeController {

	private final IRecipeService service;

	@Autowired
	public RecipeController(IRecipeService service) {
		this.service = service;
	}

	@RequestMapping("")
	public String viewHomePage(Model model) {
		List<Recipe> listRecipes = service.listAll();
		model.addAttribute("listRecipes", listRecipes);
		return "recipes/index";
	}

	@RequestMapping("/new")
	public String showNewRecipePage(Model model) {
		Recipe recipe = new Recipe();
		model.addAttribute("recipe", recipe);

		return "recipes/new_recipe";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveRecipe(@Valid @ModelAttribute("recipe") Recipe recipe, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return "recipes/new_recipe";
		}
		service.save(recipe);

		return "redirect:/recipes";
	}

	@RequestMapping("/edit/{id}")
	public String showEditRecipePage(@PathVariable(name = "id") int id, Model model) {
		Recipe recipe = service.get(id);
		model.addAttribute("recipe", recipe);

		return "recipes/edit-recipe";
	}

	@RequestMapping("/delete/{id}")
	public String deleteRecipet(@PathVariable(name = "id") int id) {
		service.delete(id);
		return "redirect:/recipes";
	}
}
