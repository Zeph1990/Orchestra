/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.orchestra.portale.persistence.sql.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author mekko
 */
@Entity
@Table(name = "comp_poi_category", catalog = "Orchestra_Schema", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CompPoiCategory.findAll", query = "SELECT c FROM CompPoiCategory c"),
    @NamedQuery(name = "CompPoiCategory.findById", query = "SELECT c FROM CompPoiCategory c WHERE c.id = :id")})
public class CompPoiCategory implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @JoinColumn(name = "idpoi", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Poi idpoi;
    @JoinColumn(name = "idcategory", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Category idcategory;

    public CompPoiCategory() {
    }

    public CompPoiCategory(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Poi getIdpoi() {
        return idpoi;
    }

    public void setIdpoi(Poi idpoi) {
        this.idpoi = idpoi;
    }

    public Category getIdcategory() {
        return idcategory;
    }

    public void setIdcategory(Category idcategory) {
        this.idcategory = idcategory;
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
        if (!(object instanceof CompPoiCategory)) {
            return false;
        }
        CompPoiCategory other = (CompPoiCategory) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.orchestra.portale.persistence.sql.entities.CompPoiCategory[ id=" + id + " ]";
    }
    
}
