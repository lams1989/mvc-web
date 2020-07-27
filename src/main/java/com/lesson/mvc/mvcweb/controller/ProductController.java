package com.lesson.mvc.mvcweb.controller;

import com.lesson.mvc.mvcweb.entities.Product;
import com.lesson.mvc.mvcweb.services.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductController {

    private final IProductService service;

    @Autowired
    public ProductController(IProductService service) {
        this.service = service;
    }

    // http://localhost:8080/products
    @RequestMapping("")
    public String viewHomePage(Model model) {
        List<Product> listProducts = service.listAll();
        model.addAttribute("listProducts", listProducts);
        return "products/index";
    }

    // http://localhost:8080/products/new
    @RequestMapping("/new")
    public String showNewProductPage(Model model) {
        Product product = new Product();
        model.addAttribute("product", product);

        return "products/new_product";
    }

    // http://localhost:8080/products/save
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveProduct(@ModelAttribute("product") Product product) {
        service.save(product);
        return "redirect:/products";
    }

    // http://localhost:8080/products/edit/1
    @RequestMapping("/edit/{id}")
    public String showEditProductPage(@PathVariable(name = "id") int id, Model model) {
        Product product = service.get(id);
        model.addAttribute("product", product);

        return "products/edit-product";
    }

    // http://localhost:8080/products/delete/1
    @RequestMapping("/delete/{id}")
    public String deleteProduct(@PathVariable(name = "id") int id) {
        service.delete(id);
        return "redirect:/products";
    }
}
