package com.hackaholiday.blackfriday.blackfriday.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hackaholiday.blackfriday.blackfriday.entity.ProductCounts;

public interface ProductCountsRepository extends JpaRepository<ProductCounts, String> {
    public ProductCounts findByAsin(String asin);

}
