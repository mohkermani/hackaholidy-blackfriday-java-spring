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
@Table(name = "Baskets",schema = "public")
@NamedQueries({
    @NamedQuery(name = "Baskets.findAll", query = "SELECT b FROM Baskets b"),
    @NamedQuery(name = "Baskets.findByBasketId", query = "SELECT b FROM Baskets b WHERE b.basketsPK.basketId = :basketId"),
    @NamedQuery(name = "Baskets.findIt", query = "SELECT b FROM Baskets b WHERE b.basketsPK.basketId = :basketId and b.basketsPK.userId = :userId and b.isCheckedOut=false"),
    @NamedQuery(name = "Baskets.findByProductId", query = "SELECT b FROM Baskets b WHERE b.basketsPK.productId = :productId"),
    @NamedQuery(name = "Baskets.findByUserId", query = "SELECT b FROM Baskets b WHERE b.basketsPK.userId = :userId"),
    @NamedQuery(name = "Baskets.findByIsCheckedOut", query = "SELECT b FROM Baskets b WHERE b.isCheckedOut = :isCheckedOut")})
public class Baskets implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected BasketsPK basketsPK;
    @Basic(optional = false)
    @Column(name = "IsCheckedOut")
    private boolean isCheckedOut;

    public Baskets() {
    }

    public Baskets(BasketsPK basketsPK) {
        this.basketsPK = basketsPK;
    }

    public Baskets(BasketsPK basketsPK, boolean isCheckedOut) {
        this.basketsPK = basketsPK;
        this.isCheckedOut = isCheckedOut;
    }

    public Baskets(String basketId, String productId, String userId) {
        this.basketsPK = new BasketsPK(basketId, productId, userId);
    }

    public BasketsPK getBasketsPK() {
        return basketsPK;
    }

    public void setBasketsPK(BasketsPK basketsPK) {
        this.basketsPK = basketsPK;
    }

    public boolean getIsCheckedOut() {
        return isCheckedOut;
    }

    public void setIsCheckedOut(boolean isCheckedOut) {
        this.isCheckedOut = isCheckedOut;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (basketsPK != null ? basketsPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Baskets)) {
            return false;
        }
        Baskets other = (Baskets) object;
        if ((this.basketsPK == null && other.basketsPK != null) || (this.basketsPK != null && !this.basketsPK.equals(other.basketsPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.hackaholiday.blackfriday.blackfriday.entity.Baskets[ basketsPK=" + basketsPK + " ]";
    }
    
}
