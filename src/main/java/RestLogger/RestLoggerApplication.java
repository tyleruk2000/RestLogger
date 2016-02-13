package RestLogger;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RestLoggerApplication
{
    private static final Logger logger = LogManager.getLogger("MOTD");
    public static void main(String[] args)
    {
        SpringApplication.run(RestLoggerApplication.class, args);
        logger.info("#########################################################");
        logger.info("Application to log all REST hits");
        logger.info("for example run:");
        logger.info("curl 127.0.0.1:8080/log?log=Hello%20World!");
        logger.info("this will log 'Hello World!' to /var/tmp/spring.log");
        logger.info("curl 127.0.0.1:8080/email?subject=Hello%20World!");
        logger.info("This will email tyler.allen@nativ.tv a blank email with the subject Hello World");
        logger.info("#########################################################");
    }
}
