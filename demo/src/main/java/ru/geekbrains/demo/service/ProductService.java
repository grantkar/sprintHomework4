package ru.geekbrains.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import ru.geekbrains.demo.entites.Product;
import ru.geekbrains.demo.repositories.ProductRepo;


import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {
    private ProductRepo productRepository;

    @Autowired
    public void setProductRepository(ProductRepo productRepository) {
        this.productRepository = productRepository;
    }

    public Product getProductByID(int id) {
        Product product = productRepository.findOne(id);
        return product;
    }

//    public List<Product> getMinCostProduct(){
//        return productRepository.findAllByCostBetween(75,100);
//    }

    public Product getMinCost(){
        Product product = productRepository.minProduct();
        return product;
    }

    public Product getMaxCost(){
        Product product = productRepository.maxProduct();
        return product;
    }

    public List<Product> getListProduct(){
        return productRepository.findAll();
    }

    public ProductService() {
    }
}
