/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity_bean;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Admin
 */
@Entity
@Table(name = "subcategory")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Subcategory.findAll", query = "SELECT s FROM Subcategory s")
    , @NamedQuery(name = "Subcategory.findBySubcategoryId", query = "SELECT s FROM Subcategory s WHERE s.subcategoryId = :subcategoryId")
    , @NamedQuery(name = "Subcategory.findBySubcategoryName", query = "SELECT s FROM Subcategory s WHERE s.subcategoryName = :subcategoryName")})
public class Subcategory implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "subcategory_id")
    private Integer subcategoryId;
    @Basic(optional = false)
    @Column(name = "subcategory_name")
    private String subcategoryName;
    @JoinColumn(name = "category_id", referencedColumnName = "category_id")
    @ManyToOne(optional = false)
    private Category categoryId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "subcategoryId")
    private Collection<Subcatmst> subcatmstCollection;

    public Subcategory() {
    }

    public Subcategory(Integer subcategoryId) {
        this.subcategoryId = subcategoryId;
    }

    public Subcategory(Integer subcategoryId, String subcategoryName) {
        this.subcategoryId = subcategoryId;
        this.subcategoryName = subcategoryName;
    }

    public Integer getSubcategoryId() {
        return subcategoryId;
    }

    public void setSubcategoryId(Integer subcategoryId) {
        this.subcategoryId = subcategoryId;
    }

    public String getSubcategoryName() {
        return subcategoryName;
    }

    public void setSubcategoryName(String subcategoryName) {
        this.subcategoryName = subcategoryName;
    }

    public Category getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Category categoryId) {
        this.categoryId = categoryId;
    }

    @XmlTransient
    public Collection<Subcatmst> getSubcatmstCollection() {
        return subcatmstCollection;
    }

    public void setSubcatmstCollection(Collection<Subcatmst> subcatmstCollection) {
        this.subcatmstCollection = subcatmstCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (subcategoryId != null ? subcategoryId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Subcategory)) {
            return false;
        }
        Subcategory other = (Subcategory) object;
        if ((this.subcategoryId == null && other.subcategoryId != null) || (this.subcategoryId != null && !this.subcategoryId.equals(other.subcategoryId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity_bean.Subcategory[ subcategoryId=" + subcategoryId + " ]";
    }
    
}
