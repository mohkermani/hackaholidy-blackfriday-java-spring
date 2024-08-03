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
@Embeddable
public class BasketsPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "BasketId")
    private String basketId;
    @Basic(optional = false)
    @Column(name = "ProductId")
    private String productId;
    @Basic(optional = false)
    @Column(name = "UserId")
    private String userId;

    public BasketsPK() {
    }

    public BasketsPK(String basketId, String productId, String userId) {
        this.basketId = basketId;
        this.productId = productId;
        this.userId = userId;
    }

    public String getBasketId() {
        return basketId;
    }

    public void setBasketId(String basketId) {
        this.basketId = basketId;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (basketId != null ? basketId.hashCode() : 0);
        hash += (productId != null ? productId.hashCode() : 0);
        hash += (userId != null ? userId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BasketsPK)) {
            return false;
        }
        BasketsPK other = (BasketsPK) object;
        if ((this.basketId == null && other.basketId != null) || (this.basketId != null && !this.basketId.equals(other.basketId))) {
            return false;
        }
        if ((this.productId == null && other.productId != null) || (this.productId != null && !this.productId.equals(other.productId))) {
            return false;
        }
        if ((this.userId == null && other.userId != null) || (this.userId != null && !this.userId.equals(other.userId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.hackaholiday.blackfriday.blackfriday.entity.BasketsPK[ basketId=" + basketId + ", productId=" + productId + ", userId=" + userId + " ]";
    }
    
}
