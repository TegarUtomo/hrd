/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.tegareng.hrd.beanLocal;

import com.tegareng.hrd.model.OrangModel;
import com.tegareng.hrd.model.ResponseModel;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Tegareng
 */
@Local
public interface OrangBeanLocal {
    
    public List<OrangModel> getList() throws Exception;
    public OrangModel getSingle(String id) throws Exception;
    public ResponseModel create(OrangModel model) throws Exception;
    public OrangModel edit(OrangModel model, String id) throws Exception;
    public ResponseModel delete(String id) throws Exception;
    
}
