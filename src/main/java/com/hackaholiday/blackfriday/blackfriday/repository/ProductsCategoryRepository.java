package com.hackaholiday.blackfriday.blackfriday.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.hackaholiday.blackfriday.blackfriday.entity.ProductsCategory;

public interface ProductsCategoryRepository extends JpaRepository<ProductsCategory, String> {
    

    @SuppressWarnings("null")
    public List<ProductsCategory> findAll();

}
