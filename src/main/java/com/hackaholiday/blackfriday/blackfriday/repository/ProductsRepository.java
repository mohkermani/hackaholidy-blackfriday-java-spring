package com.hackaholiday.blackfriday.blackfriday.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.hackaholiday.blackfriday.blackfriday.entity.Products;

public interface ProductsRepository extends JpaRepository<Products, String> {
    public Products findByAsin(String asin);

    @SuppressWarnings("null")
    public List<Products> findAll();


    public List<Products> findByCategoryName(String categoryName);

}
