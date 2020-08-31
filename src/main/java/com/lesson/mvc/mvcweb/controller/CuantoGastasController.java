package com.lesson.mvc.mvcweb.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lesson.mvc.mvcweb.entities.CuantoGastas;
import com.lesson.mvc.mvcweb.entities.FilterDate;
import com.lesson.mvc.mvcweb.services.ICuantoGastasService;

@Controller
@RequestMapping("/cuantogastas")
public class CuantoGastasController {

	private final ICuantoGastasService service;

	@Autowired
	public CuantoGastasController(ICuantoGastasService service) {
		this.service = service;
	}

	@RequestMapping("")
	public String viewHomePage(Model model) {
		List<CuantoGastas> listCuantoGastas = service.listAll();
		FilterDate date = new FilterDate();
		int totalGastos = 0;
		int totalIngresos = 0;
		for (CuantoGastas cuantoGastas : listCuantoGastas) {
			totalIngresos += cuantoGastas.getIngresos();
			totalGastos += cuantoGastas.getGastosDia();
		}
		model.addAttribute("listcuantogastas", listCuantoGastas);
		model.addAttribute("totalIngresos", totalIngresos);
		model.addAttribute("totalGastos", totalGastos);
		model.addAttribute("filterDate", date);
		
		
		return "cuantogastas/index";
		
	}
	
	

	@RequestMapping("/new")
	public String ShowNuevoGastoPage(Model model) {
		CuantoGastas cuantogastas = new CuantoGastas();
		cuantogastas.setDia(new Date());
		model.addAttribute("cuantogastas", cuantogastas);

		return "cuantogastas/new_gasto";
	}
	

	@RequestMapping("/newingreso")
	public String ShowNuevoIngresoPage(Model model) {
		CuantoGastas cuantogastas = new CuantoGastas();
		cuantogastas.setDia(new Date());
		model.addAttribute("cuantogastas", cuantogastas);

		return "cuantogastas/new_ingreso";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveGasto(@ModelAttribute("cuantogastas") CuantoGastas cuantogastas) {
		cuantogastas.setDia(new Date());
		service.save(cuantogastas);
		return "redirect:/cuantogastas";
	}
	
	@RequestMapping(value = "/between", method = RequestMethod.POST )
	public String viewBetweenDates(@ModelAttribute("filterDate") FilterDate filterDate, Model model) {
		List <CuantoGastas> list = service.viewBetweenDates(filterDate);
		int totalGastos = 0;
		int totalIngresos = 0;
		for (CuantoGastas cuantoGastas : list) {
			totalIngresos += cuantoGastas.getIngresos();
			totalGastos += cuantoGastas.getGastosDia();
		}
		model.addAttribute("listcuantogastas", list);
		model.addAttribute("totalIngresos", totalIngresos);
		model.addAttribute("totalGastos", totalGastos);
		model.addAttribute("filterDate", filterDate);
		
		
		return "cuantogastas/index";
	}

	@RequestMapping("/edit/{id}")
	public String showEditGastoPage(@PathVariable(name = "id") int id, Model model) {
		CuantoGastas cuantogastas = service.get(id);
		cuantogastas.setDia(new Date());
		cuantogastas.getGastosDia();
		cuantogastas.getDescripcion();
		cuantogastas.getIngresos();
		model.addAttribute("cuantogastas", cuantogastas);
		return "cuantogastas/edit-cuantogastas";

	}

	@RequestMapping("/delete/{id}")
	public String deleteGasto(@PathVariable(name = "id") int id) {
		service.delete(id);
		return "redirect:/cuantogasta";

	}
}
