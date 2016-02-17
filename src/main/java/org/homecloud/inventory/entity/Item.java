/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.homecloud.inventory.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import javax.persistence.*;

/**
 *
 * @author rene
 */
@Entity
public class Item implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    private String id;
    
    private String vendorId;
    private LocalDateTime time;
    private String unit;
    private int unitSize;
    private int amount;
    private String upc;
    @ManyToOne
    @JoinTable(name="contains_item",
        joinColumns = {@JoinColumn(name="item_id")},
        inverseJoinColumns = {@JoinColumn(name="container_id")}
    )
    private Container container;


    public String getVendorId() {
        return vendorId;
    }

    public void setVendorId(String vendorId) {
        this.vendorId = vendorId;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public int getUnitSize() {
        return unitSize;
    }

    public void setUnitSize(int unitSize) {
        this.unitSize = unitSize;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getUpc() {
        return upc;
    }

    public void setUpc(String upc) {
        this.upc = upc;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Item)) {
            return false;
        }
        Item other = (Item) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.homecloud.inventory.entity.Item[ id=" + id + " ]";
    }
    
}
