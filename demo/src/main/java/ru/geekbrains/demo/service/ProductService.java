package ru.geekbrains.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.geekbrains.demo.entites.Product;
import ru.geekbrains.demo.repositories.ProductRepository;

import java.util.List;

@Service
public class ProductService {
    private ProductRepository productRepository;

    @Autowired
    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product getProductByID(int id) {
        Product product = productRepository.getProductById(id);
        return product;
    }

    public List<Product> getListProduct(){
        return productRepository.productList();
    }

    public ProductService() {
    }
}
