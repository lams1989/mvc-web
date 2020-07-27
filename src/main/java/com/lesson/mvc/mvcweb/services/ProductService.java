package com.lesson.mvc.mvcweb.services;

import com.lesson.mvc.mvcweb.entities.Product;
import com.lesson.mvc.mvcweb.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ProductService implements IProductService {

    private final ProductRepository repo;

    @Autowired
    public ProductService(ProductRepository repo) {
        this.repo = repo;
    }

    @Override
    public List<Product> listAll() {
        return repo.findAll();
    }

    @Override
    public void save(Product product) {
        repo.save(product);
    }

    @Override
    public Product get(long id) {
        return repo.findById(id).get();
    }

    @Override
    public void delete(long id) {
        repo.deleteById(id);
    }
}
