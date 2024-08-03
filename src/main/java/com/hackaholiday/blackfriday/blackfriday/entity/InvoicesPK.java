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
public class InvoicesPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "BasketId")
    private String basketId;
    @Basic(optional = false)
    @Column(name = "UserId")
    private String userId;

    public InvoicesPK() {
    }

    public InvoicesPK(String basketId, String userId) {
        this.basketId = basketId;
        this.userId = userId;
    }

    public String getBasketId() {
        return basketId;
    }

    public void setBasketId(String basketId) {
        this.basketId = basketId;
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
        hash += (userId != null ? userId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof InvoicesPK)) {
            return false;
        }
        InvoicesPK other = (InvoicesPK) object;
        if ((this.basketId == null && other.basketId != null) || (this.basketId != null && !this.basketId.equals(other.basketId))) {
            return false;
        }
        if ((this.userId == null && other.userId != null) || (this.userId != null && !this.userId.equals(other.userId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.hackaholiday.blackfriday.blackfriday.entity.InvoicesPK[ basketId=" + basketId + ", userId=" + userId + " ]";
    }
    
}
