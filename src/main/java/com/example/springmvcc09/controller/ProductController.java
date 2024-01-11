package com.example.springmvcc09.controller;

import com.example.springmvcc09.model.Product;
import com.example.springmvcc09.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/products")
public class ProductController {
    ProductService productService = new ProductService();
    @GetMapping
    public ModelAndView findAll() {
        ModelAndView modelAndView = new ModelAndView("/product/list");
        modelAndView.addObject("list", productService.findAll());
        return modelAndView;
    }

    @GetMapping("/create")
    public String showFormCreate() {
        return "/product/create";
    }

    @PostMapping("/save")
    public ModelAndView save(Product product) {
        ModelAndView modelAndView = new ModelAndView("/product/create");
        productService.add(product);
        modelAndView.addObject("mess", "Thêm mới thành công!");
        return modelAndView;
    }
}
