/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.tegareng.hrd.bean;

import com.tegareng.hrd.beanLocal.MailerBeanLocal;
import com.tegareng.hrd.beanLocal.OrangBeanLocal;
import com.tegareng.hrd.entity.Orang;
import com.tegareng.hrd.facade.OrangFacadeLocal;
import com.tegareng.hrd.model.OrangModel;
import com.tegareng.hrd.model.ResponseModel;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Singleton;

/**
 *
 * @author Tegareng
 */
@Singleton
public class OrangBean implements OrangBeanLocal {
   
    @EJB
    private OrangFacadeLocal orangFacade;
	@EJB
	private MailerBeanLocal mailerBeanLocal;
    
    @Override
    public List<OrangModel> getList() throws Exception {
        
        List<OrangModel> models = new ArrayList<>();
        List<Orang> entityList = orangFacade.findAll();
        
        for(Orang entity : entityList){
            OrangModel model = new OrangModel();
            model.setId(entity.getId());
            model.setNama(entity.getNama());
            model.setEmail(entity.getEmail());
            
            models.add(model);
        }
        return models;
    }

    @Override
    public OrangModel getSingle(String id) throws Exception {
        
        Orang entity = orangFacade.find(id);
        OrangModel model = new OrangModel(entity);
        return model;
    }

    @Override
    public ResponseModel create(OrangModel model) throws Exception {
        
        ResponseModel response = new ResponseModel();
        Orang entity = new Orang(model);
        try{
            orangFacade.create(entity);
            response.setResponseCode(200);
            response.setMessage("Success");
			
			//email notif
			mailerBeanLocal.sendMail("omoturaget3@gmail.com", constructEmailMessage(model));
			
            return response;
        }catch(Exception e){
            response.setMessage("Failed");
            response.setResponseCode(500);
            return response;
        }
    }
    
    @Override
    public OrangModel edit(OrangModel model, String id) throws Exception {
        
        Orang entity = orangFacade.find(id);
        entity.setNama(model.getNama());
        entity.setEmail(model.getEmail());
        
        orangFacade.edit(entity);
        return new OrangModel(entity);
    }

    @Override
    public ResponseModel delete(String id) throws Exception {
        
        ResponseModel response = new ResponseModel();
        
        try{
            Orang entity = orangFacade.find(id);
            orangFacade.remove(entity);
            response.setResponseCode(200);
            response.setMessage("Success");
            
            return response;
        }catch(Exception e){
            response.setMessage("Failed");
            response.setResponseCode(500);
            return response;
        }
    }
	
	private String constructEmailMessage(OrangModel model){
		
		StringBuilder sb = new StringBuilder();
		sb.append("Dear Bapak/Ibu ");
		sb.append(model.getNama()).append("<br/><br/>");
		sb.append("Data anda Sudah terdaftar kedalam sistem HRD Java Buatan Mochamad Tegar Utomo");
		sb.append("<br/><br/>");
		sb.append("Regards,");
		sb.append("<br/><br/>");
		sb.append("HRD Admin");
		
		return sb.toString();
	}
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
