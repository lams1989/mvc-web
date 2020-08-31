package com.lesson.mvc.mvcweb.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CuantoGastas {
	private Long id;
	private Date dia;
	private int ingresos;
	private int gastosDia;
	private String descripcion;
	

	public CuantoGastas() {
	}

	public CuantoGastas(Date dia, int ingresos, int gastosDia, String descripcion) {
		super();
		this.dia = dia;
		this.ingresos = ingresos;
		this.gastosDia = gastosDia;
		this.descripcion = descripcion;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDia() {
		return dia;
	}

	public void setDia(Date dia) {
		this.dia = dia;
	}

	public int getIngresos() {
		return ingresos;
	}

	public void setIngresos(int ingresos) {
		this.ingresos = ingresos;
	}

	public int getGastosDia() {
		return gastosDia;
	}

	public void setGastosDia(int gastosDia) {
		this.gastosDia = gastosDia;
	}



}
