/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.tegareng.hrd.facade;

import com.tegareng.hrd.entity.Orang;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Tegareng
 */
@Stateless
public class OrangFacade extends AbstractDatabaseFacade<Orang> implements OrangFacadeLocal {
    @PersistenceContext(unitName = "HRDPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public OrangFacade() {
        super(Orang.class);
    }
}
