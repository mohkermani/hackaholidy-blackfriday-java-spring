/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hackaholiday.blackfriday.blackfriday.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import jakarta.persistence.*;
import jakarta.persistence.Table;


/**
 *
 * @author HP
 */
@Entity
@Table(name = "Products",schema = "public")
@NamedQueries({
    @NamedQuery(name = "Products.findAll", query = "SELECT p FROM Products p"),
    @NamedQuery(name = "Products.findByAsin", query = "SELECT p FROM Products p WHERE p.asin = :asin"),
    @NamedQuery(name = "Products.findByTitle", query = "SELECT p FROM Products p WHERE p.title = :title"),
    @NamedQuery(name = "Products.findByImgUrl", query = "SELECT p FROM Products p WHERE p.imgUrl = :imgUrl"),
    @NamedQuery(name = "Products.findByProductUrl", query = "SELECT p FROM Products p WHERE p.productUrl = :productUrl"),
    @NamedQuery(name = "Products.findByStars", query = "SELECT p FROM Products p WHERE p.stars = :stars"),
    @NamedQuery(name = "Products.findByReviews", query = "SELECT p FROM Products p WHERE p.reviews = :reviews"),
    @NamedQuery(name = "Products.findByPrice", query = "SELECT p FROM Products p WHERE p.price = :price"),
    @NamedQuery(name = "Products.findByIsBestSeller", query = "SELECT p FROM Products p WHERE p.isBestSeller = :isBestSeller"),
    @NamedQuery(name = "Products.findByBoughtInLastMonth", query = "SELECT p FROM Products p WHERE p.boughtInLastMonth = :boughtInLastMonth"),
    @NamedQuery(name = "Products.findByCategoryName", query = "SELECT p FROM Products p WHERE p.categoryName = :categoryName")})
public class Products implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "asin")
    private String asin;
    @Column(name = "title")
    private String title;
    @Column(name = "imgUrl")
    private String imgUrl;
    @Column(name = "productUrl")
    private String productUrl;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "stars")
    private BigDecimal stars;
    @Column(name = "reviews")
    private Long reviews;
    @Column(name = "price")
    private BigDecimal price;
    @Column(name = "isBestSeller")
    private Boolean isBestSeller;
    @Column(name = "boughtInLastMonth")
    private Long boughtInLastMonth;
    @Column(name = "categoryName")
    private String categoryName;

    public Products() {
    }

    public Products(String asin) {
        this.asin = asin;
    }

    public String getAsin() {
        return asin;
    }

    public void setAsin(String asin) {
        this.asin = asin;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getProductUrl() {
        return productUrl;
    }

    public void setProductUrl(String productUrl) {
        this.productUrl = productUrl;
    }

    public BigDecimal getStars() {
        return stars;
    }

    public void setStars(BigDecimal stars) {
        this.stars = stars;
    }

    public Long getReviews() {
        return reviews;
    }

    public void setReviews(Long reviews) {
        this.reviews = reviews;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Boolean getIsBestSeller() {
        return isBestSeller;
    }

    public void setIsBestSeller(Boolean isBestSeller) {
        this.isBestSeller = isBestSeller;
    }

    public Long getBoughtInLastMonth() {
        return boughtInLastMonth;
    }

    public void setBoughtInLastMonth(Long boughtInLastMonth) {
        this.boughtInLastMonth = boughtInLastMonth;
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
        hash += (asin != null ? asin.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Products)) {
            return false;
        }
        Products other = (Products) object;
        if ((this.asin == null && other.asin != null) || (this.asin != null && !this.asin.equals(other.asin))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.hackaholiday.blackfriday.blackfriday.entity.Products[ asin=" + asin + " ]";
    }
    
}
