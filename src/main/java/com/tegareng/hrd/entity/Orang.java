/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.tegareng.hrd.entity;

import com.tegareng.hrd.facade.AbstractDatabaseFacade;
import com.tegareng.hrd.model.OrangModel;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Tegareng
 */
@Entity
@Table(name = "orang")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Orang.findAll", query = "SELECT o FROM Orang o"),
    @NamedQuery(name = "Orang.findById", query = "SELECT o FROM Orang o WHERE o.id = :id"),
    @NamedQuery(name = "Orang.findByNama", query = "SELECT o FROM Orang o WHERE o.nama = :nama"),
    @NamedQuery(name = "Orang.findByEmail", query = "SELECT o FROM Orang o WHERE o.email = :email")})
public class Orang implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "id")
    private String id;
    @Size(max = 2147483647)
    @Column(name = "nama")
    private String nama;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 2147483647)
    @Column(name = "email")
    private String email;

    public Orang() {
    }

    public Orang(OrangModel model) {
        if(model == null){
            return;
        }
        
        this.id = AbstractDatabaseFacade.generateId();
        this.nama = model.getNama();
        this.email = model.getEmail();
    }
    
    public Orang(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
        if (!(object instanceof Orang)) {
            return false;
        }
        Orang other = (Orang) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.tegareng.hrd.Orang[ id=" + id + " ]";
    }
    
}
