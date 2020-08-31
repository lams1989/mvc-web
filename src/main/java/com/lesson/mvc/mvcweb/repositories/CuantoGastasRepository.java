package com.lesson.mvc.mvcweb.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.lesson.mvc.mvcweb.entities.CuantoGastas;

public interface CuantoGastasRepository extends JpaRepository<CuantoGastas, Long>{

	@Query (value = "SELECT * FROM `cuanto_gastas` WHERE dia BETWEEN :inicial AND :fin", nativeQuery = true)
	List<CuantoGastas> listBetween(@Param("inicial") Date initDate, @Param("fin")Date endDate);
	

}
