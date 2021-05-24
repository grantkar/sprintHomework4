package ru.geekbrains.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.demo.entites.Product;
import ru.geekbrains.demo.service.ProductService;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {
    private ProductService productService;

    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    @RequestMapping("/showProduct")
    public String hello(Model uiModel) {
        Product product = productService.getProductByID(1);
        uiModel.addAttribute("product", product);
        return "product";
    }

    @RequestMapping(value = "/showProductById", method = RequestMethod.GET)
    @ResponseBody
    public Product showProductById(int id) {
        return productService.getProductByID(id);
    }

    @RequestMapping(value = "/setProduct", method = RequestMethod.POST)
    public void setProduct(@RequestBody Product product) {
    }

    @RequestMapping(value = "/showForm", method = RequestMethod.GET)
    public String showSimpleForm(Model uiModel) {
        uiModel.addAttribute("product", new Product());
        return "product_form";
    }

    @RequestMapping(value = "/processForm", method = RequestMethod.POST)
    public String processForm(@ModelAttribute("product") Product product) {
        productService.getListProduct().add(product);
        return "product-form-result";
    }

    @RequestMapping(value = "/allProduct", method = RequestMethod.GET)
    public String showAllProduct(Model model) {
        List<Product> allProducts = productService.getListProduct();
        model.addAttribute("allProducts",allProducts);
        return "all-product";
    }
}

