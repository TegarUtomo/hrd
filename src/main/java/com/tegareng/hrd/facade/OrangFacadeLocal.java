/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.tegareng.hrd.facade;

import com.tegareng.hrd.entity.Orang;
import javax.ejb.Local;

/**
 *
 * @author Tegareng
 */
@Local
public interface OrangFacadeLocal extends DatabaseFacadeLocal<Orang>{
    // tambahan query spesifik orang,
    // ex:
    //findNama()
    //findEmail()
}
