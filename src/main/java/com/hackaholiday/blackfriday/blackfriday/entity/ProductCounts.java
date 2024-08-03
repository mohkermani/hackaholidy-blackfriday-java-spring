/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hackaholiday.blackfriday.blackfriday.entity;

import java.io.Serializable;
import jakarta.persistence.*;

/**
 *
 * @author HP
 */
@Entity
@Table(name = "ProductCounts",schema = "public")
@NamedQueries({
    @NamedQuery(name = "ProductCounts.findAll", query = "SELECT p FROM ProductCounts p"),
    @NamedQuery(name = "ProductCounts.findByAsin", query = "SELECT p FROM ProductCounts p WHERE p.asin = :asin"),
    @NamedQuery(name = "ProductCounts.findByCount", query = "SELECT p FROM ProductCounts p WHERE p.count = :count")})
public class ProductCounts implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "Asin")
    private String asin;
    @Basic(optional = false)
    @Column(name = "Count")
    private int count;

    public ProductCounts() {
    }

    public ProductCounts(String asin) {
        this.asin = asin;
    }

    public ProductCounts(String asin, int count) {
        this.asin = asin;
        this.count = count;
    }

    public String getAsin() {
        return asin;
    }

    public void setAsin(String asin) {
        this.asin = asin;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (asin != null ? asin.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProductCounts)) {
            return false;
        }
        ProductCounts other = (ProductCounts) object;
        if ((this.asin == null && other.asin != null) || (this.asin != null && !this.asin.equals(other.asin))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.hackaholiday.blackfriday.blackfriday.entity.ProductCounts[ asin=" + asin + " ]";
    }
    
}
