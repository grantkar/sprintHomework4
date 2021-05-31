package ru.geekbrains.demo.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import ru.geekbrains.demo.entites.Product;

import java.util.List;

@Repository
public interface ProductRepo extends PagingAndSortingRepository<Product, Integer> {

    List<Product> findAll();

   @Query(value = "select id, title, cost from products where cost = (select MIN(cost) from products)", nativeQuery = true)
    Product minProduct();

    @Query(value = "select id, title, cost from products where cost = (select max(cost) from products)", nativeQuery = true)
    Product maxProduct();
}
