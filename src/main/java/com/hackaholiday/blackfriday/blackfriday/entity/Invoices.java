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
@Table(name = "Invoices",schema = "public")
@NamedQueries({
    @NamedQuery(name = "Invoices.findAll", query = "SELECT i FROM Invoices i"),
    @NamedQuery(name = "Invoices.findByBasketId", query = "SELECT i FROM Invoices i WHERE i.invoicesPK.basketId = :basketId"),
    @NamedQuery(name = "Invoices.findIt", query = "SELECT i FROM Invoices i WHERE i.invoicesPK.basketId = :basketId and  i.invoicesPK.userId = :userId"),
    @NamedQuery(name = "Invoices.findByUserId", query = "SELECT i FROM Invoices i WHERE i.invoicesPK.userId = :userId"),
    @NamedQuery(name = "Invoices.findByItems", query = "SELECT i FROM Invoices i WHERE i.items = :items")})
public class Invoices implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected InvoicesPK invoicesPK;
    @Basic(optional = false)
    @Column(name = "Items")
    private String items;

    public Invoices() {
    }

    public Invoices(InvoicesPK invoicesPK) {
        this.invoicesPK = invoicesPK;
    }

    public Invoices(InvoicesPK invoicesPK, String items) {
        this.invoicesPK = invoicesPK;
        this.items = items;
    }

    public Invoices(String basketId, String userId) {
        this.invoicesPK = new InvoicesPK(basketId, userId);
    }

    public InvoicesPK getInvoicesPK() {
        return invoicesPK;
    }

    public void setInvoicesPK(InvoicesPK invoicesPK) {
        this.invoicesPK = invoicesPK;
    }

    public String getItems() {
        return items;
    }

    public void setItems(String items) {
        this.items = items;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (invoicesPK != null ? invoicesPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Invoices)) {
            return false;
        }
        Invoices other = (Invoices) object;
        if ((this.invoicesPK == null && other.invoicesPK != null) || (this.invoicesPK != null && !this.invoicesPK.equals(other.invoicesPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.hackaholiday.blackfriday.blackfriday.entity.Invoices[ invoicesPK=" + invoicesPK + " ]";
    }
    
}
