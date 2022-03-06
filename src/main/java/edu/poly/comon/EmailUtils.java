package edu.poly.comon;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import edu.poly.domain.Email;

public class EmailUtils {
	public static void send(Email email) throws Exception {
		Properties prop = new Properties();

		prop.put("mail.smtp.host", "smtp.gmail.com");
		prop.put("mail.smtp.port", "587");
		prop.put("mail.smtp.auth", "true");
		prop.put("mail.smtp.starttls.enable", "true");
		prop.put("mail.smtp.ssl.trust", "smtp.gmail.com");
		prop.put("mail.smtp.ssl.protocols", "TLSv1.2");
		Session session = Session.getInstance(prop, new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(email.getFrom(), email.getFromPassword());
			}
		});

		try {
			Message mess = new MimeMessage(session);
			mess.setFrom(new InternetAddress(email.getFrom()));
			mess.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email.getTo()));
			mess.setSubject(email.getSubject());
			mess.setContent(email.getContent(), "text/html; charset=utf-8");

			Transport.send(mess);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
}
