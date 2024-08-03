package com.hackaholiday.blackfriday.blackfriday.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hackaholiday.blackfriday.blackfriday.entity.Invoices;

public interface InvoicesRepository extends JpaRepository<Invoices, String> {
    public List<Invoices> findIt(String basketId, String userId);

}
