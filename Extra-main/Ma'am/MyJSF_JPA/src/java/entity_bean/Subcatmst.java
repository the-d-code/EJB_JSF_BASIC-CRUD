/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity_bean;

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
 * @author Admin
 */
@Entity
@Table(name = "subcatmst")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Subcatmst.findAll", query = "SELECT s FROM Subcatmst s")
    , @NamedQuery(name = "Subcatmst.findBySubcatmstId", query = "SELECT s FROM Subcatmst s WHERE s.subcatmstId = :subcatmstId")})
public class Subcatmst implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "subcatmst_id")
    private Integer subcatmstId;
    @JoinColumn(name = "category_id", referencedColumnName = "category_id")
    @ManyToOne(optional = false)
    private Category categoryId;
    @JoinColumn(name = "subcategory_id", referencedColumnName = "subcategory_id")
    @ManyToOne(optional = false)
    private Subcategory subcategoryId;

    public Subcatmst() {
    }

    public Subcatmst(Integer subcatmstId) {
        this.subcatmstId = subcatmstId;
    }

    public Integer getSubcatmstId() {
        return subcatmstId;
    }

    public void setSubcatmstId(Integer subcatmstId) {
        this.subcatmstId = subcatmstId;
    }

    public Category getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Category categoryId) {
        this.categoryId = categoryId;
    }

    public Subcategory getSubcategoryId() {
        return subcategoryId;
    }

    public void setSubcategoryId(Subcategory subcategoryId) {
        this.subcategoryId = subcategoryId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (subcatmstId != null ? subcatmstId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Subcatmst)) {
            return false;
        }
        Subcatmst other = (Subcatmst) object;
        if ((this.subcatmstId == null && other.subcatmstId != null) || (this.subcatmstId != null && !this.subcatmstId.equals(other.subcatmstId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity_bean.Subcatmst[ subcatmstId=" + subcatmstId + " ]";
    }
    
}
