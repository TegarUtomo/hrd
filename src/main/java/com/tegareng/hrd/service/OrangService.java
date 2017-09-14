/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.tegareng.hrd.service;

import com.tegareng.hrd.bean.OrangBeanLocal;
import com.tegareng.hrd.model.OrangModel;
import com.tegareng.hrd.model.ResponseModel;
import java.util.List;
import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Tegareng
 */
@Path("/people")
public class OrangService {
    
    @EJB
    private OrangBeanLocal orangBean;
    
    @GET
    @Path("")
    @Produces(MediaType.APPLICATION_JSON)
    public List<OrangModel> getAll() throws Exception{
        try{
            return orangBean.getList();
        }catch(Exception e){
           throw new Exception(e);          
        }
    }
    
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public OrangModel getSingle(@PathParam("id") String id) throws Exception{
        try{
            return orangBean.getSingle(id);
        }catch(Exception e){
            throw new Exception(e);
        }
    }
    
    @POST
    @Path("/create")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public ResponseModel create(OrangModel model) throws Exception{
        
        try{
            return orangBean.create(model);
        }catch(Exception e){
           
            throw new Exception(e);
        }
    }
    
    @PUT
    @Path("/edit/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public OrangModel edit(OrangModel model, @PathParam("id") String id) throws Exception{
        try{
            return orangBean.edit(model, id);
        }catch(Exception e){
            throw new Exception(e);
        }
    }
    
    @DELETE
    @Path("/delete/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public ResponseModel delete(@PathParam("id") String id) throws Exception{
        try{
            return orangBean.delete(id);
        }catch(Exception e){
            throw new Exception(e);
        }
    }
}
