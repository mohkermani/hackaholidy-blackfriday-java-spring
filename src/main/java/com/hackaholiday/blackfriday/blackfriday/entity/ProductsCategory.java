/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hackaholiday.blackfriday.blackfriday.entity;

import java.io.Serializable;
import jakarta.persistence.*;
import jakarta.persistence.Table;


/**
 *
 * @author HP
 */
@Entity
@Table(name = "Products",schema = "public")
@NamedQueries({
    @NamedQuery(name = "ProductsCategory.findAll", query = "SELECT p.categoryName FROM Products p group by categoryName")})
public class ProductsCategory implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "categoryName")
    private String categoryName;

    public ProductsCategory() {
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (categoryName != null ? categoryName.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProductsCategory)) {
            return false;
        }
        ProductsCategory other = (ProductsCategory) object;
        if ((this.categoryName == null && other.categoryName != null) || (this.categoryName != null && !this.categoryName.equals(other.categoryName))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.hackaholiday.blackfriday.blackfriday.entity.ProductsCategory[ name=" + categoryName + " ]";
    }
    
}
