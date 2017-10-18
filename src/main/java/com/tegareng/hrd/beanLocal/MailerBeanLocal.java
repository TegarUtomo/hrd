/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tegareng.hrd.beanLocal;

import javax.ejb.Local;

/**
 *
 * @author Moch. Tegar
 */
@Local
public interface MailerBeanLocal {
	public void sendMail(String recipient, String bodyMessage) throws Exception;
}
