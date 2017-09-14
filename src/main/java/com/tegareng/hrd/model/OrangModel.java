/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.tegareng.hrd.model;

import com.tegareng.hrd.entity.Orang;
import java.io.Serializable;

/**
 *
 * @author Tegareng
 */
public class OrangModel implements Serializable{
    
    private String id;
    private String nama;
    private String email;

    public OrangModel(Orang entity) {
        
        if(entity == null){
            return;
        }
        
        this.id = entity.getId();
        this.nama = entity.getNama();
        this.email = entity.getEmail();
    }

    public OrangModel(){
        
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
}
