package com.lesson.mvc.mvcweb.controller;

import com.lesson.mvc.mvcweb.entities.Product;
import com.lesson.mvc.mvcweb.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {

    private final ProductService service;

    @Autowired
    public ProductController(ProductService service) {
        this.service = service;
    }

    // http://localhost:8080/product/
    @RequestMapping("/")
    public String viewHomePage(Model model) {
        List<Product> listProducts = service.listAll();
        model.addAttribute("listProducts", listProducts);
        return "index";
    }

    // http://localhost:8080/product/new
    @RequestMapping("/new")
    public String showNewProductPage(Model model) {
        Product product = new Product();
        model.addAttribute("product", product);

        return "new_product";
    }

    // http://localhost:8080/product/save
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveProduct(@ModelAttribute("product") Product product) {
        service.save(product);
        return "redirect:/";
    }

    // http://localhost:8080/product/edit/1
    @RequestMapping("/edit/{id}")
    public String showEditProductPage(@PathVariable(name = "id") int id, Model model) {
        Product product = service.get(id);
        model.addAttribute("product", product);

        return "/edit-product";
    }

    // http://localhost:8080/product/delete/1
    @RequestMapping("/delete/{id}/{name}")
    public String deleteProduct(@PathVariable(name = "id") int id) {
        service.delete(id);
        return "redirect:/";
    }
}
