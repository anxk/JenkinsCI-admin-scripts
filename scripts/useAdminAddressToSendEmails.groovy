// Use Jenkins admin address to send emails.

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.Transport;

String subject = "test";
String body = "test";
String[] recipientsList = ["xxx@qq.com", "yyy@gmail.com"];

JenkinsLocationConfiguration jlc = JenkinsLocationConfiguration.get();
InternetAddress from = new InternetAddress();
from.setAddress(jlc.getAdminAddress());

List<InternetAddress> recipients = new ArrayList<InternetAddress>();
recipientsList.each {recipients.add(new InternetAddress(it))};
InternetAddress[] addresses = new InternetAddress[recipients.size()]

Session session  = hudson.tasks.Mailer.descriptor().createSession();
Message message = new MimeMessage(session);
message.setFrom(from);
message.setRecipients(Message.RecipientType.TO, recipients.toArray(addresses));
message.setSubject(subject);
message.setText(body);

Transport.send(message, message.getAllRecipients());
