package com.lesson.mvc.mvcweb.services;

import com.lesson.mvc.mvcweb.entities.Product;

import java.util.List;

public interface IProductService {
    List<Product> listAll();

    void save(Product product);

    Product get(long id);

    void delete(long id);
}
