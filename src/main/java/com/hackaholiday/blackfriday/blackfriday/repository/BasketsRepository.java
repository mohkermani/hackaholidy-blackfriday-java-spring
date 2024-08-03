package com.hackaholiday.blackfriday.blackfriday.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hackaholiday.blackfriday.blackfriday.entity.Baskets;

public interface BasketsRepository extends JpaRepository<Baskets, String> {
    public List<Baskets> findByBasketId(String basketId);
    
    public List<Baskets> findIt(String basketId, String userId);


}
