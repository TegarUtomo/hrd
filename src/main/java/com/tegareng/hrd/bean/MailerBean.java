/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tegareng.hrd.bean;

import com.tegareng.hrd.beanLocal.MailerBeanLocal;
import com.tegareng.hrd.util.StaticVars;
import java.util.Calendar;
import javax.annotation.Resource;
import javax.ejb.Singleton;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

/**
 *
 * @author Moch. Tegar
 */
@Singleton
public class MailerBean implements MailerBeanLocal{
	
	@Resource(lookup = "mail/ownEmail")
	private Session session;

	@Override
	public void sendMail(String recipient, String bodyMessage) throws Exception{
		MimeMessage message = new MimeMessage(session);
		message.addRecipients(Message.RecipientType.TO
				, InternetAddress.parse(recipient));
		
		message.setSubject(StaticVars.MAIL_SUBJECT);
		
		Multipart mp = new MimeMultipart();
		BodyPart bodyPart = new MimeBodyPart();
		
		//if html, ex in message there are a <> html tag, use below
		// yeah
		bodyPart.setContent(bodyMessage, "text/html");
		mp.addBodyPart(bodyPart);
		
		message.setSentDate(Calendar.getInstance().getTime());
		message.setContent(mp);
		Transport.send(message);
		System.out.println("Email has been sent . . . !");
	}
}
