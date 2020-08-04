package com.lesson.mvc.mvcweb.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Recipe {

	private Long id;
	
	@NotNull
	@Size(min=2, max=30)
	private String name;
	
	@NotNull
	@Min(30)
	private int timepreparation;
	
	@NotNull
	@Size(min=2, max=50)
	private String ingredients;
	
	@NotNull
	@Size(min=20, max=100)
	private String process;
	
	@NotNull
	@Size(min=2, max=20)
	private String platedtype;
	
	
	public Recipe() {
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getProcess() {
		return process;
	}


	public void setProcess(String process) {
		this.process = process;
	}


	public String getPlatedtype() {
		return platedtype;
	}


	public void setPlatedtype(String platedtype) {
		this.platedtype = platedtype;
	}
	
	public String getIngredients() {
		return ingredients;
	}

	public void setIngredients(String ingredients) {
		this.ingredients = ingredients;
	}

	public int getTimepreparation() {
		return timepreparation;
	}

	public void setTimepreparation(int timepreparation) {
		this.timepreparation = timepreparation;
	}
	
	@Override
	public String toString() {
		return "Recipe [id=" + id + ", name=" + name + ", timepreparation=" + timepreparation + ", ingredients="
				+ ingredients + ", process=" + process + ", platedtype=" + platedtype + "]";
	}




	
	
	
}
