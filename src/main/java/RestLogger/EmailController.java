package RestLogger;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import java.util.Properties;


@RestController
public class EmailController
{
    private final Logger logger = LogManager.getLogger(this.getClass().getName());


    @RequestMapping("/email")
    public String greeting(@RequestParam(value="subject", defaultValue = "Email From Rest Logger") String subject,HttpServletRequest request)
    {
        logger.info(request.getLocalAddr() + " " + request.getMethod() + " " + "sending email");
        sendMail(subject);
        return subject;
    }

    private void sendMail(String subject)
    {
        String to = "tyler.allen";
        String from = "tyler.allen";

        String host = "10.3.3.3";

        Properties properties = System.getProperties();
        properties.setProperty("mail.smtp.host", host);
        Session session = Session.getDefaultInstance(properties);

        try{
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.addRecipient(Message.RecipientType.TO,
                    new InternetAddress(to));

            message.setSubject(subject);
            message.setText("");

            Transport.send(message);
            System.out.println("Sent message successfully....");
        }catch (MessagingException mex) {
            mex.printStackTrace();
        }
    }

}
