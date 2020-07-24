package com.lesson.mvc.mvcweb.repositories;

import com.lesson.mvc.mvcweb.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
